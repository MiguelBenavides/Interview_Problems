package test.java;

import org.junit.Test;
import main.java.*;

import static org.junit.Assert.assertEquals;
import static main.java.SumOfR2LPaths.sumOfR2LPaths;

public class SumOfR2LPathsTest {
    @Test
    public void normalTreeTest()
    {
        BinaryTreeNode root = new BinaryTreeNode(1);

        root.left = new BinaryTreeNode(0);
        root.right = new BinaryTreeNode(1);

        root.left.left = new BinaryTreeNode(0);
        root.left.right = new BinaryTreeNode(1);

        root.left.left.left = new BinaryTreeNode(0);
        root.left.left.right = new BinaryTreeNode(1);

        root.left.right.left = null;
        root.left.right.right = new BinaryTreeNode(1);

        root.left.right.right.left = new BinaryTreeNode(0);
        root.left.right.right.right = null;

        root.right.left = new BinaryTreeNode(0);
        root.right.right = new BinaryTreeNode(0);

        root.right.left.left = null;
        root.right.left.right = new BinaryTreeNode(0);

        root.right.left.right.left = new BinaryTreeNode(1);
        root.right.left.right.right = new BinaryTreeNode(0);

        root.right.left.right.left.left = null;
        root.right.left.right.left.right = new BinaryTreeNode(1);

        root.right.right.left = null;
        root.right.right.right = new BinaryTreeNode(0);

        assertEquals((long)126, (long)sumOfR2LPaths(root));
    }

    @Test
    public void emptyTreeTest()
    {
        assertEquals((long)0, (long)sumOfR2LPaths(null));
    }

    @Test
    public void oneNodeInTreeTest()
    {
        BinaryTreeNode root = new BinaryTreeNode(1);

        assertEquals((long)1, (long)sumOfR2LPaths(root));
    }
}
