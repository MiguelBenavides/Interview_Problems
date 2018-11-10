package main.java;

import java.util.Stack;

public class ReverseSublist {

    public static LinkedListNode reverseSublistByValueWithStack(LinkedListNode head, int start, int end)
    {
        if(head == null) return null;
        if(start == end) return head;
        if(start > end) return head;

        Stack<Integer> values = new Stack<>();

        LinkedListNode iterator = head;

        int index = 1;

        while(index < start) {
            iterator = iterator.next;
            ++index;
        }

        LinkedListNode startNode = iterator;

        while(index <= end) {
            values.push(iterator.data);
            iterator = iterator.next;
            ++index;
        }

        iterator = startNode;

        while(!values.isEmpty()){
            iterator.data = values.pop();
            iterator = iterator.next;
        }
        return head;
    }

}
