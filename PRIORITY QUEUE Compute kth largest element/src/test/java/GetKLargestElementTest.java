package test.java;

import org.junit.Test;
import java.util.ArrayList;

import static main.java.GetKthLargestElement.getKthLargestElement;
import static org.junit.Assert.assertEquals;

public class GetKLargestElementTest {
    @Test
    public void emptyListTest()
    {
        assertEquals(null, getKthLargestElement(null, 10));
    }

    @Test
    public void kEqualsZeroTest()
    {
        ArrayList<Integer> elements = new ArrayList();

        elements.add(3);
        elements.add(2);
        elements.add(1);
        elements.add(5);
        elements.add(6);
        elements.add(7);
        elements.add(2);
        elements.add(3);
        elements.add(7);
        elements.add(4);
        elements.add(9);
        elements.add(8);
        elements.add(4);

        assertEquals(null, getKthLargestElement(elements, 0));
    }

    @Test
    public void normalScenarioTest()
    {
        ArrayList<Integer> elements = new ArrayList<>();

        elements.add(3);
        elements.add(2);
        elements.add(1);
        elements.add(5);
        elements.add(6);
        elements.add(7);
        elements.add(2);
        elements.add(3);
        elements.add(7);
        elements.add(4);
        elements.add(9);
        elements.add(8);
        elements.add(4);

        assertEquals((long)6, (long)getKthLargestElement(elements, 5));
    }

    @Test
    public void kEqualsSizeOfListTest()
    {
        ArrayList<Integer> elements = new ArrayList<>();

        elements.add(3);
        elements.add(2);
        elements.add(1);
        elements.add(5);
        elements.add(6);
        elements.add(7);
        elements.add(2);
        elements.add(3);
        elements.add(7);
        elements.add(4);
        elements.add(9);
        elements.add(8);
        elements.add(4);

        assertEquals((long)1, (long)getKthLargestElement(elements, 13));
    }

    @Test
    public void kEqualsOneTest()
    {
        ArrayList<Integer> elements = new ArrayList<>();

        elements.add(3);
        elements.add(2);
        elements.add(1);
        elements.add(5);
        elements.add(6);
        elements.add(7);
        elements.add(2);
        elements.add(3);
        elements.add(7);
        elements.add(4);
        elements.add(9);
        elements.add(8);
        elements.add(4);

        assertEquals((long)9, (long)getKthLargestElement(elements, 1));
    }
}
