package main.java;

import java.util.Stack;

public class MaxStack {
    public int data;
    private LinkedListNode top = null;

    private Stack<Integer> maxValues = new Stack<>();

    public void push(int data)
    {
        LinkedListNode newNode = new LinkedListNode(data);

        //Insert the node on top of the stack.
        newNode.next = top;

        //Update the top.
        top = newNode;

        //If greater than or equal to current max, push it.
        if(maxValues.isEmpty() || data >= maxValues.peek())
            maxValues.push(data);
    }

    public Integer pop()
    {
        //If empty, return null.
        if(top == null) return null;

        //Store return value.
        int retVal = top.data;

        //Update top.
        top = top.next;

        //If the value was the current max, pop it from maxValues.
        if(!maxValues.isEmpty() && maxValues.peek() == retVal)
            maxValues.pop();

        return retVal;
    }

    public Integer getMax()
    {
        return maxValues.isEmpty() ? null : maxValues.peek();
    }

    public String toString()
    {
        return top.toString();
    }
}
