package main.java;

import java.util.ArrayList;

public class MaxQueue {
    private LinkedListNode front;
    private LinkedListNode back;

    ArrayList<Integer> maxValues = new ArrayList<>();

    public void enqueue(int data)
    {
        LinkedListNode newNode = new LinkedListNode(data);

        //If queue is empty, both pointers point to the new node.
        if(back == null)
        {
            back = newNode;
            front = newNode;
        }
        else
        {
            newNode.next = back;
            back = newNode;
        }

        //Remove last elements if they're less than the enqueued data.
        while(!maxValues.isEmpty() && maxValues.get(maxValues.size() - 1) < data)
            maxValues.remove(maxValues.size() - 1);

        //Add data to the end of the list.
        maxValues.add(data);
    }

    public Integer dequeue()
    {
        if(front == null) return null;

        int retVal = front.data;

        //If front is equal to max, remove from maxValues.
        if(!maxValues.isEmpty() && maxValues.get(0) == retVal)
            maxValues.remove(0);

        //Find new front.
        front = back;
        while(front.next != null && front.next.next != null)
            front = front.next;

        //If just one element in the queue, empty the queue, if not, get new front.
        if(front.next == null)
            front = null;
        else
            front.next = null;

        return retVal;
    }

    public Integer getMax()
    {
        return maxValues.isEmpty() ? null : maxValues.get(0);
    }
}
