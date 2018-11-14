package main.java;

public class SumOfR2LPaths {
    public static int sumOfR2LPaths(BinaryTreeNode root)
    {
        if(root == null) return 0;

        return sumOfPaths(root, 0);
    }

    private static int sumOfPaths(BinaryTreeNode node, int numSoFar)
    {
        numSoFar = (numSoFar * 2) + node.data;

        if(node.left == null && node.right == null)
            return numSoFar;

        int sum = 0;

        if(node.left != null)
            sum += sumOfPaths(node.left, numSoFar);

        if(node.right != null)
            sum += sumOfPaths(node.right, numSoFar);

        return sum;
    }
}
