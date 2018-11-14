package main.java;

public class GetLCA {
    private static class LCAWrapper
    {
        Boolean containsLCA;
        BinaryTreeNode LCA;
        LCAWrapper() {}
        LCAWrapper(Boolean c){containsLCA = c;}
        LCAWrapper(Boolean c, BinaryTreeNode l){containsLCA = c; LCA = l;}
    }

    public static BinaryTreeNode getLCA(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2)
    {
        if(root == null || n1 == null || n2 == null) return null;

        LCAWrapper res = checkForLCA(root, n1, n2);

        return res.LCA;
    }

    private static LCAWrapper checkForLCA(BinaryTreeNode node, BinaryTreeNode n1, BinaryTreeNode n2)
    {
        if(node ==  null) return new LCAWrapper(false);

        LCAWrapper left = checkForLCA(node.left, n1, n2);
        if(left.LCA != null) return left;

        LCAWrapper right = checkForLCA(node.right, n1, n2);
        if(right.LCA != null) return right;

        Boolean isCurrentANode = node == n1 || node == n2;

        LCAWrapper retVal = new LCAWrapper(isCurrentANode || left.containsLCA || right.containsLCA);
        if((isCurrentANode && left.containsLCA) || (isCurrentANode && right.containsLCA) || (left.containsLCA && right.containsLCA))
            retVal.LCA = node;

        return retVal;
    }

    public static BinaryTreeNode getLCAInBinarySearchTree(BinaryTreeNode root, BinaryTreeNode n1, BinaryTreeNode n2)
    {
        if(root == null || n1 == null || n2 == null) return null;

        BinaryTreeNode curr = root;

        int big = Math.max(n1.data, n2.data);
        int small = Math.min(n1.data, n2.data);

        do{
            if(small <= curr.data && curr.data <= big)
                return curr;

            if(curr.data > big)
                curr = curr.left;
            else
                curr = curr.right;
        }while (curr != null);

        return null;
    }
}
