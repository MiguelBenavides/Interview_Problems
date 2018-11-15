package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetKthLargestElement {

    public static Integer getKthLargestElement(ArrayList<Integer> elements, int k)
    {
        if(elements == null || k == 0) return null;

        PriorityQueue<Integer> largestKElements = new PriorityQueue<>(k);

        int i = 0;
        for(; i < k; ++i)
            largestKElements.add(elements.get(i));

        for(; i < elements.size(); ++i)
        {
            Integer e = elements.get(i);
            if(e > largestKElements.peek()){
                largestKElements.poll();
                largestKElements.add(e);
            }
        }

        return largestKElements.peek();
    }
}
