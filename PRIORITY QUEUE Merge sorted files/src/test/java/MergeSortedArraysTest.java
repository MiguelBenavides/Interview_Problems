package test.java;

import main.java.*;
import org.junit.Test;

import java.util.ArrayList;

import static main.java.MergeSortedArrays.mergeSortedArrays;
import static org.junit.Assert.assertEquals;

public class MergeSortedArraysTest {
    @Test
    public void normalArrayTest(){
        ArrayList<ArrayList<Integer>> in = new ArrayList<>();

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(3);
        temp.add(5);
        temp.add(7);
        in.add(temp);

        temp = new ArrayList<>();
        temp.add(0);
        temp.add(6);
        temp.add(28);
        in.add(temp);

        temp = new ArrayList<>();
        temp.add(0);
        temp.add(6);
        in.add(temp);

        assertEquals("[0, 0, 3, 5, 6, 6, 7, 28]", mergeSortedArrays(in).toString());
    }

    @Test
    public void emptyArrayTest()
    {
        assertEquals(null, mergeSortedArrays(null));
    }
}
