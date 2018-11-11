package test.java;

import org.junit.Test;
import main.java.*;

import static org.junit.Assert.assertEquals;

public class MaxQueueTest {

    @Test
    public void enqueueDequeueTest()
    {
        MaxQueue q = new MaxQueue();

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);

        assertEquals(1, (long)q.dequeue());
        assertEquals(2, (long)q.dequeue());
        assertEquals(3, (long)q.dequeue());
        assertEquals(4, (long)q.dequeue());
        assertEquals(5, (long)q.dequeue());
        assertEquals(6, (long)q.dequeue());
        assertEquals(null, q.dequeue());
    }

    @Test
    public void getMaxTest()
    {
        MaxQueue q = new MaxQueue();

        q.enqueue(7);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(5);

        assertEquals(7, (long)q.getMax());
        assertEquals(7, (long)q.dequeue());

        assertEquals(6, (long)q.getMax());

        assertEquals(3, (long)q.dequeue());
        assertEquals(4, (long)q.dequeue());
        assertEquals(5, (long)q.dequeue());
        assertEquals(6, (long)q.dequeue());

        assertEquals(5, (long)q.getMax());
        assertEquals(5, (long)q.dequeue());

        assertEquals(null, q.getMax());
    }
}
