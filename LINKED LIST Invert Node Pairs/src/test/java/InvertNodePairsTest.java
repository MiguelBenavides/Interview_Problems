package test.java;

import main.java.*;
import org.junit.Test;

import static main.java.InvertNodePairs.invertNodePairs;
import static org.junit.Assert.assertEquals;

public class InvertNodePairsTest {

    @Test
    public void InvertNodePairsTest()
    {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);

        assertEquals("Verify function works for an even number of nodes.", "{2, 1, 4, 3}", invertNodePairs(head).toString());

        head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        assertEquals("Verify function works for an odd number of nodes.", "{2, 1, 4, 3, 5}", invertNodePairs(head).toString());

        head = new LinkedListNode(1);

        assertEquals("Verify function works for a list with one node.", "{1}", invertNodePairs(head).toString());

        assertEquals("Verify function works for a null input.", null, invertNodePairs(null));
    }
}
