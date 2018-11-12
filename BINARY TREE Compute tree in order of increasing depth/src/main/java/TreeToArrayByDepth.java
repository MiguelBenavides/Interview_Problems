package main.java;

import java.util.ArrayList;

public class TreeToArrayByDepth {
    public static ArrayList<ArrayList<Integer>> treeToArrayByDepth(BinaryTreeNode root)
    {
        if(root == null) return null;

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

        buildArrayList(root, 0, tree);

        return tree;
    }

    private static void buildArrayList(BinaryTreeNode node, int depth, ArrayList<ArrayList<Integer>> tree)
    {
        if(tree.size() - 1 >= depth)
            tree.get(depth).add(node.data);
        else
        {
            ArrayList<Integer> depthLevelArrayList = new ArrayList<>();
            depthLevelArrayList.add(node.data);
            tree.add(depthLevelArrayList);
        }

        if(node.left != null)
            buildArrayList(node.left, depth + 1, tree);

        if(node.right != null)
            buildArrayList(node.right, depth + 1, tree);
    }
}
