package test.java;

import main.java.*;
import org.junit.Test;

import static main.java.ReverseSublist.*;
import static org.junit.Assert.assertEquals;

public class ReverseSublistTestByValueWithStack {

    @Test
    public void evenNumberOfNodesTest()
    {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);

        head = reverseSublistByValueWithStack(head, 2, 5);
        assertEquals("Verify function works for an even number of nodes.", "{1, 5, 4, 3, 2, 6}", head.toString());
    }

    @Test
    public void oddNumberOfNodesTest()
    {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);

        head = reverseSublistByValueWithStack(head, 2, 4);
        assertEquals("Verify function works for an even number of nodes.", "{1, 4, 3, 2, 5, 6}", head.toString());
    }

    @Test
    public void wholeListAsSublist()
    {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);

        head = reverseSublistByValueWithStack(head, 1, 6);
        assertEquals("Verify function works for an even number of nodes.", "{6, 5, 4, 3, 2, 1}", head.toString());
    }

    @Test
    public void equalStartAndEnd()
    {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);

        head = reverseSublistByValueWithStack(head, 4, 4);
        assertEquals("Verify function works for an even number of nodes.", "{1, 2, 3, 4, 5, 6}", head.toString());
    }

    @Test
    public void startLargerThanEnd()
    {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);

        head = reverseSublistByValueWithStack(head, 5, 2);
        assertEquals("Verify function works for an even number of nodes.", "{1, 2, 3, 4, 5, 6}", head.toString());

    }
}
