package test.java;

import main.java.*;
import org.junit.Test;

import java.util.ArrayList;

import static main.java.GetMedian.getMedian;
import static org.junit.Assert.assertEquals;

public class GetMedianTest {
    @Test
    public void orderedInputTest(){
        ArrayList<Integer> elements = new ArrayList<>();

        elements.add(0);
        elements.add(1);
        elements.add(2);
        elements.add(3);
        elements.add(4);
        elements.add(5);
        elements.add(6);
        elements.add(7);
        elements.add(8);
        elements.add(9);

        assertEquals(4.5, (double)getMedian(elements), 0);
    }

    @Test
    public void reverseOrderedInputTest(){
        ArrayList<Integer> elements = new ArrayList<>();

        elements.add(9);
        elements.add(8);
        elements.add(7);
        elements.add(6);
        elements.add(5);
        elements.add(4);
        elements.add(3);
        elements.add(2);
        elements.add(1);
        elements.add(0);

        assertEquals(4.5, (double)getMedian(elements), 0);
    }

    @Test
    public void emptyListTest()
    {
        assertEquals(null, getMedian(null));
    }
}
