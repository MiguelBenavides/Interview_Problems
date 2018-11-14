package test.java;

import main.java.BinaryTreeNode;
import org.junit.Test;

import static main.java.GetLCA.getLCAInBinarySearchTree;
import static org.junit.Assert.assertEquals;

public class GetLCAInBinarySearchTreeTest {
    @Test
    public void normalTreeTest()
    {
        BinaryTreeNode root = new BinaryTreeNode(10);

        root.left = new BinaryTreeNode(5);

        BinaryTreeNode LCA = new BinaryTreeNode(15);
        root.right = LCA;

        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(7);

        root.right.left = new BinaryTreeNode(12);
        BinaryTreeNode n1 = new BinaryTreeNode(17);
        root.right.right = n1;

        root.left.left.left = null;
        root.left.left.right = new BinaryTreeNode(3);

        BinaryTreeNode n2 = new BinaryTreeNode(11);
        root.right.left.left = n2;
        root.right.left.right = null;

        assertEquals(LCA, getLCAInBinarySearchTree(root, n1, n2));
    }

    @Test
    public void emptyTreeTest()
    {
        BinaryTreeNode n1 = new BinaryTreeNode();
        BinaryTreeNode n2 = new BinaryTreeNode();
        assertEquals(null, getLCAInBinarySearchTree(null, n1, n2));
    }

    @Test
    public void emptyNode1Test()
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

        BinaryTreeNode n2 = root.right.left.left;

        assertEquals(null, getLCAInBinarySearchTree(root, null, n2));
    }

    @Test
    public void emptyNode2Test()
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

        root.right.left.left = new BinaryTreeNode(2);
        root.right.left.right = null;

        BinaryTreeNode n1 = root.right.left.left;

        assertEquals(null, getLCAInBinarySearchTree(root, n1, null));
    }

    @Test
    public void rootAsLCATest()
    {
        BinaryTreeNode root = new BinaryTreeNode(10);

        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(15);

        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(7);

        root.right.left = new BinaryTreeNode(12);
        root.right.right = new BinaryTreeNode(17);

        root.left.left.left = null;
        BinaryTreeNode n1 = new BinaryTreeNode(3);
        root.left.left.right = n1;

        BinaryTreeNode n2 = new BinaryTreeNode(11);
        root.right.left.left = n2;
        root.right.left.right = null;

        assertEquals(root, getLCAInBinarySearchTree(root, n1, n2));
    }

    @Test
    public void node1AsLCA()
    {
        BinaryTreeNode root = new BinaryTreeNode(10);

        root.left = new BinaryTreeNode(5);

        BinaryTreeNode n1 = new BinaryTreeNode(15);
        root.right = n1;

        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(7);

        root.right.left = new BinaryTreeNode(12);
        root.right.right = new BinaryTreeNode(17);

        root.left.left.left = null;
        root.left.left.right = new BinaryTreeNode(3);

        BinaryTreeNode n2 = new BinaryTreeNode(11);
        root.right.left.left = n2;
        root.right.left.right = null;

        assertEquals(n1, getLCAInBinarySearchTree(root, n1, n2));
    }

    @Test
    public void node2AsLCA()
    {
        BinaryTreeNode root = new BinaryTreeNode(10);

        BinaryTreeNode n2 = new BinaryTreeNode(5);
        root.left = n2;
        root.right = new BinaryTreeNode(15);

        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(7);

        root.right.left = new BinaryTreeNode(12);
        root.right.right = new BinaryTreeNode(17);

        root.left.left.left = null;
        BinaryTreeNode n1 = new BinaryTreeNode(3);
        root.left.left.right = n1;

        root.right.left.left = new BinaryTreeNode(11);
        root.right.left.right = null;

        assertEquals(n2, getLCAInBinarySearchTree(root, n1, n2));
    }
}
