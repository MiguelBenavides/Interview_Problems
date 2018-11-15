package test.java;

import main.java.*;
import org.junit.Test;

import java.util.ArrayList;

import static main.java.GetKClosestStars.getKClosestStarts;
import static org.junit.Assert.assertEquals;

public class GetKClosestStarsTest {
    @Test
    public void emptyArrayTest()
    {
        assertEquals(null, getKClosestStarts(null, 10));
    }

    @Test
    public void kEqualsZeroTest()
    {
        ArrayList<ArrayList<Integer>> stars = new ArrayList<>();

        ArrayList<Integer> star = new ArrayList<>();
        star.add(3);
        star.add(3);
        star.add(3);
        stars.add(star);

        star = new ArrayList<>();
        star.add(4);
        star.add(4);
        star.add(4);
        stars.add(star);

        star = new ArrayList<>();
        star.add(1);
        star.add(1);
        star.add(1);
        stars.add(star);

        assertEquals(null, getKClosestStarts(stars, 0));
    }

    @Test
    public void kEqualsArraySizeTest()
    {
        ArrayList<ArrayList<Integer>> stars = new ArrayList<>();

        ArrayList<Integer> star = new ArrayList<>();
        star.add(3);
        star.add(3);
        star.add(3);
        stars.add(star);

        star = new ArrayList<>();
        star.add(4);
        star.add(4);
        star.add(4);
        stars.add(star);

        star = new ArrayList<>();
        star.add(1);
        star.add(1);
        star.add(1);
        stars.add(star);

        assertEquals("[[4, 4, 4], [3, 3, 3], [1, 1, 1]]", getKClosestStarts(stars, 3).toString());
    }

    @Test
    public void kEqualsOne()
    {
        ArrayList<ArrayList<Integer>> stars = new ArrayList<>();

        ArrayList<Integer> star = new ArrayList<>();
        star.add(3);
        star.add(3);
        star.add(3);
        stars.add(star);

        star = new ArrayList<>();
        star.add(4);
        star.add(4);
        star.add(4);
        stars.add(star);

        star = new ArrayList<>();
        star.add(1);
        star.add(1);
        star.add(1);
        stars.add(star);

        assertEquals("[[1, 1, 1]]", getKClosestStarts(stars, 1).toString());
    }

    @Test
    public void normalScenarioTest()
    {
        ArrayList<ArrayList<Integer>> stars = new ArrayList<>();

        ArrayList<Integer> star = new ArrayList<>();
        star.add(3);
        star.add(3);
        star.add(3);
        stars.add(star);

        star = new ArrayList<>();
        star.add(4);
        star.add(4);
        star.add(4);
        stars.add(star);

        star = new ArrayList<>();
        star.add(1);
        star.add(1);
        star.add(1);
        stars.add(star);

        star = new ArrayList<>();
        star.add(2);
        star.add(2);
        star.add(2);
        stars.add(star);

        assertEquals("[[2, 2, 2], [1, 1, 1]]", getKClosestStarts(stars, 2).toString());
    }
}
