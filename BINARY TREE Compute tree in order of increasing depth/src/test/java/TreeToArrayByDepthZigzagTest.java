package test.java;

import main.java.*;
import org.junit.Test;

import static main.java.TreeToArrayByDepth.treeToArrayByDepthZigzag;
import static org.junit.Assert.assertEquals;


public class TreeToArrayByDepthZigzagTest {
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

        assertEquals("[[0], [2, 1], [3, 4, 5, 6], [8, 7]]", treeToArrayByDepthZigzag(root).toString());
    }

    @Test
    public void emptyTreeTest()
    {
        assertEquals(null, treeToArrayByDepthZigzag(null));
    }
}
