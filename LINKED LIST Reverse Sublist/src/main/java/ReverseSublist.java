package main.java;

import java.util.Stack;

public class ReverseSublist {

    public static LinkedListNode reverseSublistByValueWithStack(LinkedListNode head, int start, int end)
    {
        if(head == null) return null;
        if(start >= end) return head;

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

    public static LinkedListNode reverseSublistByNode(LinkedListNode head, int start, int end)
    {
        if(start >= end) return head;
        if(head == null) return null;

        LinkedListNode dummyHead = new LinkedListNode();
        dummyHead.next = head;

        int index = 0;

        LinkedListNode iterator = dummyHead;

        while(++index < start)
            iterator = iterator.next;

        LinkedListNode sublistDummyHead = iterator;
        iterator = sublistDummyHead.next;

        while(++index <= end) {
            LinkedListNode temp = iterator.next;
            iterator.next = temp.next;
            temp.next = sublistDummyHead.next;
            sublistDummyHead.next = temp;
        }
        return dummyHead.next;
    }

}
