package test.java;

import main.java.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MaxStackTest {

    @Test
    public void toStringTest()
    {
        MaxStack s = new MaxStack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);

        assertEquals("Verify toString() works properly.", "{6, 5, 4, 3, 2, 1}", s.toString());
    }

    @Test
    public void popTest()
    {
        MaxStack s = new MaxStack();

        s.push(3);
        s.push(1);
        s.push(5);
        s.push(5);
        s.push(6);
        s.push(3);
        s.pop();
        s.pop();

        assertEquals("Verify pop() works properly.", "{5, 5, 1, 3}", s.toString());
    }

    @Test
    public void pushTest()
    {
        MaxStack s = new MaxStack();

        s.push(3);
        s.push(1);
        s.push(5);
        s.push(5);
        s.push(6);
        s.push(3);

        assertEquals("Verify push() works properly.", "{3, 6, 5, 5, 1, 3}", s.toString());
    }

    @Test
    public void popWhenEmptyTest()
    {
        MaxStack s = new MaxStack();

        assertEquals("Verify pop() returns Null when empty.", null, s.pop());
    }

    @Test
    public void getMaxTest()
    {
        MaxStack s = new MaxStack();

        s.push(3);
        s.push(1);
        s.push(5);
        s.push(5);
        s.push(6);
        s.push(3);

        assertEquals("Verify getMax() function work properly.", (long)6, (long)s.getMax());
    }

    @Test
    public void getMaxWhenRepeatedTest()
    {
        MaxStack s = new MaxStack();

        s.push(3);
        s.push(1);
        s.push(5);
        s.push(5);
        s.push(6);
        s.push(3);
        s.pop();
        s.pop();
        s.pop();

        assertEquals("Verify getMax function work properly when the maximum was repeated.", (long)5, (long)s.getMax());
    }

    @Test
    public void getMaxWhenEmpty()
    {
        MaxStack s = new MaxStack();

        assertEquals("Verify getMax function work properly when empty.", null, s.getMax());
    }
}
