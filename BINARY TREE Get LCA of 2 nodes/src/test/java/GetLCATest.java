package test.java;

import org.junit.Test;
import main.java.*;

import static org.junit.Assert.assertEquals;
import static main.java.GetLCA.getLCA;

public class GetLCATest {
    @Test
    public void normalTreeTest()
    {
        BinaryTreeNode root = new BinaryTreeNode(0);

        root.left = new BinaryTreeNode(1);

        BinaryTreeNode LCA = new BinaryTreeNode(2);
        root.right = LCA;

        root.left.left = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(4);

        root.right.left = new BinaryTreeNode(5);
        BinaryTreeNode n1 = new BinaryTreeNode(6);
        root.right.right = n1;

        root.left.left.left = null;
        root.left.left.right = new BinaryTreeNode(7);

        BinaryTreeNode n2 = new BinaryTreeNode(8);
        root.right.left.left = n2;
        root.right.left.right = null;

        assertEquals(LCA, getLCA(root, n1, n2));
    }

    @Test
    public void emptyTreeTest()
    {
        BinaryTreeNode n1 = new BinaryTreeNode();
        BinaryTreeNode n2 = new BinaryTreeNode();
        assertEquals(null, getLCA(null, n1, n2));
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

        assertEquals(null, getLCA(root, null, n2));
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

        assertEquals(null, getLCA(root, n1, null));
    }

    @Test
    public void rootAsLCATest()
    {
        BinaryTreeNode root = new BinaryTreeNode(0);

        root.left = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(2);

        root.left.left = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(4);

        root.right.left = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(6);

        root.left.left.left = null;

        BinaryTreeNode n1 = new BinaryTreeNode(7);
        root.left.left.right = n1;

        BinaryTreeNode n2 = new BinaryTreeNode(8);
        root.right.left.left = n2;
        root.right.left.right = null;

        assertEquals(root, getLCA(root, n1, n2));
    }

    @Test
    public void node1AsLCATest()
    {
        BinaryTreeNode root = new BinaryTreeNode(0);

        root.left = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(2);

        root.left.left = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(4);

        BinaryTreeNode n1 = new BinaryTreeNode(5);
        root.right.left = n1;
        root.right.right = new BinaryTreeNode(6);

        root.left.left.left = null;
        root.left.left.right = new BinaryTreeNode(7);

        BinaryTreeNode n2 = new BinaryTreeNode(8);
        root.right.left.left = n2;
        root.right.left.right = null;

        assertEquals(n1, getLCA(root, n1, n2));
    }

    @Test
    public void node2AsLCATest()
    {
        BinaryTreeNode root = new BinaryTreeNode(0);

        root.left = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        root.right = n2;

        root.left.left = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(4);

        root.right.left = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(6);

        root.left.left.left = null;
        root.left.left.right = new BinaryTreeNode(7);

        BinaryTreeNode n1 = new BinaryTreeNode(8);
        root.right.left.left = n1;
        root.right.left.right = null;

        assertEquals(n2, getLCA(root, n1, n2));
    }
}
