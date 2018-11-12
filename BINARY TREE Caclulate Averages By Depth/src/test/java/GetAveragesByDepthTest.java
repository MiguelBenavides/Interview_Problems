package test.java;

import main.java.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static main.java.GetAveragesByDepth.getAveragesByDepth;

public class GetAveragesByDepthTest
{
    @Test
    public void normalTreeTest()
    {
        BinaryTreeNode root = new BinaryTreeNode(0);

        root.left = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(2);

        root.left.left = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(4);

        root.right.left = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(6);

        root.left.left.left = null;
        root.left.left.right = new BinaryTreeNode(7);

        root.right.left.left = new BinaryTreeNode(8);
        root.right.left.right = null;

        assertEquals("[0.0, 1.5, 4.5, 7.5]", getAveragesByDepth(root).toString());
    }

    @Test
    public void emptyTreeTest()
    {
        assertEquals(null, getAveragesByDepth(null));
    }
}
