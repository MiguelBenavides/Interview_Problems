package main.java;

public class IsTreeHeightBalanced {
    private static class BinaryTreeNodeStatus{
        public Boolean isBalanced;
        public int height;

        public BinaryTreeNodeStatus(){};
        public BinaryTreeNodeStatus(Boolean b, int h){
            isBalanced = b;
            height = h;
        }
    }

    public static Boolean isTreeHeightBalanced(BinaryTreeNode root)
    {
        if(root == null) return null;

        BinaryTreeNodeStatus status = getNodeStatus(root);
        return status.isBalanced;
    }

    private static BinaryTreeNodeStatus getNodeStatus(BinaryTreeNode node){
        if(node == null) return new BinaryTreeNodeStatus(true, -1);

        BinaryTreeNodeStatus leftStatus = getNodeStatus(node.left);
        if(!leftStatus.isBalanced)
            return new BinaryTreeNodeStatus(false, 0);

        BinaryTreeNodeStatus rightStatus = getNodeStatus(node.right);
        if(!rightStatus.isBalanced)
            return new BinaryTreeNodeStatus(false, 0);

        BinaryTreeNodeStatus currentStatus = new BinaryTreeNodeStatus();

        currentStatus.isBalanced = Math.abs(leftStatus.height - rightStatus.height) <= 1;
        currentStatus.height = Math.max(leftStatus.height, rightStatus.height) + 1;

        return currentStatus;
    }

    private static class BinaryTreeSubtreeStatus{
        public Boolean isBalanced;
        public int height;
        public int numOfNodes;

        public BinaryTreeSubtreeStatus(){};
        public BinaryTreeSubtreeStatus(Boolean b, int h, int n){
            isBalanced = b;
            height = h;
            numOfNodes = n;
        }
    }

    //Needed because Integers cant be passed by reference.
    private static class IntegerWrapper{
        public int value;
        public IntegerWrapper(){};
    }
    public static Integer getSizeOfBiggestBalancedSubtree(BinaryTreeNode root)
    {
        if(root == null) return 0;

        IntegerWrapper max = new IntegerWrapper();

        getSubtreeStatus(root, max);

        return max.value;
    }

    private static BinaryTreeSubtreeStatus getSubtreeStatus(BinaryTreeNode node, IntegerWrapper max)
    {
        if(node == null) return new BinaryTreeSubtreeStatus(true, 0, 0);

        BinaryTreeSubtreeStatus left = getSubtreeStatus(node.left, max);
        BinaryTreeSubtreeStatus right = getSubtreeStatus(node.right, max);

        BinaryTreeSubtreeStatus curr = new BinaryTreeSubtreeStatus();

        curr.isBalanced = (Math.abs(left.height - right.height) <= 1) && left.isBalanced && right.isBalanced;
        curr.height = Math.max(left.height, right.height) + 1;
        curr.numOfNodes = left.numOfNodes + right.numOfNodes + 1;

        if(curr.isBalanced) {
            max.value = Math.max(curr.numOfNodes, max.value);
        }
        return curr;
    }
}
