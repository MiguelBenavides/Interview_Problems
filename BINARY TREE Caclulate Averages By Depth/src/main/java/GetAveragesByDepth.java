package main.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GetAveragesByDepth
{
    public static ArrayList<Double> getAveragesByDepth(BinaryTreeNode root)
    {
        if(root == null) return null;

        ArrayList<Double> averages = new ArrayList<>();

        Queue<BinaryTreeNode> currentLevelQ = new LinkedList<>();

        currentLevelQ.add(root);

        do{
            int sum = 0;
            int numOfNodes = 0;

            Queue<BinaryTreeNode> nextLevelQ = new LinkedList<>();
            while(!currentLevelQ.isEmpty())
            {
                BinaryTreeNode curr = currentLevelQ.poll();

                sum += curr.data;
                ++numOfNodes;

                //Add next level nodes to the queue.
                if(curr.left != null)
                    nextLevelQ.add(curr.left);
                if(curr.right != null)
                    nextLevelQ.add(curr.right);
            }
            //Add Average to the list.
            averages.add((double)sum/numOfNodes);

            //Update queue.
            currentLevelQ = nextLevelQ;

        }while(!currentLevelQ.isEmpty());

        return averages;
    }
}
