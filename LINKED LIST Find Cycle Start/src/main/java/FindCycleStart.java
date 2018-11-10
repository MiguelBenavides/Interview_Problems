package main.java;
import main.java.LinkedListNode.*;

import java.util.HashSet;

public class FindCycleStart {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        LinkedListNode cycleStart = new LinkedListNode(3);
        head.next.next = cycleStart;
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = cycleStart;

        cycleStart = findCycleStart(head);
    }

    public static LinkedListNode findCycleStartWithHashSet(LinkedListNode head)
    {
        if(head == null) return null;

        HashSet<LinkedListNode> nodes = new HashSet<>();

        while(head != null && !nodes.contains(head)){
            nodes.add(head);
            head = head.next;
        }
        return head;
    }

    public static LinkedListNode findCycleStart(LinkedListNode head)
    {
        if(head ==  null || head.next == null) return null;

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        //Find if there is a cycle in the list.
        do {
            slow = slow.next;

            //If the end of the list was reached, there is no cycle.
            if(fast.next == null || fast.next.next == null)
                return null;

            fast = fast.next.next;
        }while(slow != fast);

        //Find the length of the cycle.
        int cycleLenght = 0;
        do{
            ++cycleLenght;
            fast = fast.next;
        }while (slow != fast);

        slow = head;
        fast = head;

        //Separate both nodes by the length of the cycle.
        while(cycleLenght-- > 0)
            fast = fast.next;

        //Find start of cycle.
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
