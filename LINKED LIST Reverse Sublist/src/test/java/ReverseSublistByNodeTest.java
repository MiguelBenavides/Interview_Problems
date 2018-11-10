package test.java;

import main.java.LinkedListNode;
import org.junit.Test;

import static main.java.ReverseSublist.reverseSublistByNode;
import static org.junit.Assert.assertEquals;

public class ReverseSublistByNodeTest {

    @Test
    public void evenNumberOfNodesTest()
    {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);

        head = reverseSublistByNode(head, 2, 5);
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

        head = reverseSublistByNode(head, 2, 4);
        assertEquals("Verify function works for an odd number of nodes.", "{1, 4, 3, 2, 5, 6}", head.toString());
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

        head = reverseSublistByNode(head, 1, 6);
        assertEquals("Verify function works when the sublist is the whole list.", "{6, 5, 4, 3, 2, 1}", head.toString());
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

        head = reverseSublistByNode(head, 4, 4);
        assertEquals("Verify function works when the start is equal to the end", "{1, 2, 3, 4, 5, 6}", head.toString());
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

        head = reverseSublistByNode(head, 5, 2);
        assertEquals("Verify function works when the start is larger than the end.", "{1, 2, 3, 4, 5, 6}", head.toString());
    }
}