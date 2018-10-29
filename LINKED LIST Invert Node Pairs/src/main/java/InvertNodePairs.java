package main.java;

public class InvertNodePairs
{
    public static LinkedListNode invertNodePairs(LinkedListNode head)
    {
        if(head == null) return null;
        if(head.next == null) return head;

        LinkedListNode dummyHead = new LinkedListNode();
        LinkedListNode p1, p2, prev;

        dummyHead.next = head;
        prev = dummyHead;

        do {
            // Shift p1 and p2 accordingly.
            p1 = prev.next;
            p2 = prev.next.next;

            // Swap positions.
            prev.next = p2;
            p1.next = p2.next;
            p2.next = p1;

            // Set new previous node for next iteration.
            prev = p1;
        } while(prev.next != null && prev.next.next != null);

        // Assign the new head to the parameter, so it's consistent.
        head = dummyHead.next;

        return head;
    }
}
