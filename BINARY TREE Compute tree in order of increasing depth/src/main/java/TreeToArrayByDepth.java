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

    public static ArrayList<ArrayList<Integer>> treeToArrayByDepthZigzag(BinaryTreeNode root)
    {
        if(root == null) return null;

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

        buildArrayListZigzag(root, 0, tree);

        return tree;
    }

    private static void buildArrayListZigzag(BinaryTreeNode node, int depth, ArrayList<ArrayList<Integer>> tree)
    {
        if(tree.size() - 1 >= depth) {
            if(depth % 2 == 0)
                tree.get(depth).add(node.data);
            else
                tree.get(depth).add(0, node.data);
        }
        else
        {
            ArrayList<Integer> depthLevelArrayList = new ArrayList<>();
            depthLevelArrayList.add(node.data);
            tree.add(depthLevelArrayList);
        }

        if(node.left != null)
            buildArrayListZigzag(node.left, depth + 1, tree);

        if(node.right != null)
            buildArrayListZigzag(node.right, depth + 1, tree);
    }

    public static ArrayList<ArrayList<Integer>> treeToArrayByDepthBottomUp(BinaryTreeNode root)
    {
        if(root == null) return null;

        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

        buildArrayListBottomUp(root, 0, tree);

        return tree;
    }

    private static void buildArrayListBottomUp(BinaryTreeNode node, int depth, ArrayList<ArrayList<Integer>> tree)
    {
        if(tree.size() - 1 >= depth)
            tree.get(tree.size() - 1 - depth).add(node.data);
        else
        {
            ArrayList<Integer> depthLevelArrayList = new ArrayList<>();
            depthLevelArrayList.add(node.data);
            tree.add(0, depthLevelArrayList);
        }

        if(node.left != null)
            buildArrayListBottomUp(node.left, depth + 1, tree);

        if(node.right != null)
            buildArrayListBottomUp(node.right, depth + 1, tree);
    }
}
