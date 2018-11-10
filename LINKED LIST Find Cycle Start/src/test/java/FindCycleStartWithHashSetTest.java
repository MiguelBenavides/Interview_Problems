package test.java;

import static main.java.FindCycleStart.*;
import main.java.LinkedListNode;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FindCycleStartWithHashSetTest {
    @Test
    public void noCycleInList()
    {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        head = findCycleStartWithHashSet(head);
        assertEquals("Verify function works for a list without a cycle.", null, head);
    }

    @Test
    public void evenNumberOfNodesInCycle()
    {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        LinkedListNode cycleStart = new LinkedListNode(3);
        head.next.next = cycleStart;
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);
        head.next.next.next.next.next.next = cycleStart;

        head = findCycleStartWithHashSet(head);
        assertEquals("Verify function works for an even number of nodes in the cycle.", cycleStart, head);
    }

    @Test
    public void oddNumberOfNodesInCycle()
    {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        LinkedListNode cycleStart = new LinkedListNode(3);
        head.next.next = cycleStart;
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = cycleStart;

        head = findCycleStartWithHashSet(head);
        assertEquals("Verify function works for an odd number of nodes in the cycle.", cycleStart, head);
    }

    @Test
    public void oneNodeInCycle()
    {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        LinkedListNode cycleStart = new LinkedListNode(5);
        head.next.next.next.next = cycleStart;
        head.next.next.next.next.next = cycleStart;

        head = findCycleStartWithHashSet(head);
        assertEquals("Verify function works for just one node in the cycle.", cycleStart, head);
    }
}
