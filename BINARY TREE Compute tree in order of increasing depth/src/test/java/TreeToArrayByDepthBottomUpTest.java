package test.java;

import main.java.*;
import org.junit.Test;

import static main.java.TreeToArrayByDepth.treeToArrayByDepthBottomUp;
import static org.junit.Assert.assertEquals;


public class TreeToArrayByDepthBottomUpTest {
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

        assertEquals("[[7, 8], [3, 4, 5, 6], [1, 2], [0]]", treeToArrayByDepthBottomUp(root).toString());
    }

    @Test
    public void emptyTreeTest()
    {
        assertEquals(null, treeToArrayByDepthBottomUp(null));
    }
}
