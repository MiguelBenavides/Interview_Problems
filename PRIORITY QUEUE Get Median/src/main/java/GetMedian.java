package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedian {
    public static Double getMedian(ArrayList<Integer> elements)
    {
        if(elements == null) return null;

        Comparator<Integer> reversedComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        PriorityQueue<Integer> smaller = new PriorityQueue<>(reversedComparator);
        PriorityQueue<Integer> bigger = new PriorityQueue<>();

        double median = elements.get(0);
        smaller.add((int)median);
        System.out.println(median);

        for(int i = 1; i < elements.size(); ++i)
        {
            int e = elements.get(i);

            if(e < smaller.peek()){
                smaller.add(e);
                if(smaller.size() - bigger.size() > 1)
                    bigger.add(smaller.poll());
            }
            else{
                bigger.add(e);
                if(smaller.size() < bigger.size())
                    smaller.add(bigger.poll());
            }

            if((smaller.size() + bigger.size()) % 2 == 0)
                median = (smaller.peek() + bigger.peek()) / 2.0;
            else
                median = smaller.peek();

            System.out.println(median);
        }
        return median;
    }
}
