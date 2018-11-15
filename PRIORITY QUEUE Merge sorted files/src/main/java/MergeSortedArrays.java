package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSortedArrays {
    private static class ValAndLoc{
        public Integer value;
        public Integer arrayIndex;
        public Integer elementIndex;

        public ValAndLoc(){}
        public ValAndLoc(int d, int a, int e){value = d; arrayIndex = a; elementIndex = e;}
    }

    public static ArrayList<Integer> mergeSortedArrays(ArrayList<ArrayList<Integer>> in)
    {
        if(in == null) return null;

        Comparator<ValAndLoc> valueComparator = new Comparator<ValAndLoc>() {
            @Override
            public int compare(ValAndLoc o1, ValAndLoc o2) {
                return o1.value - o2.value;
            }
        };

        PriorityQueue<ValAndLoc> mins = new PriorityQueue<>(in.size(), valueComparator);

        //Add first elements to the priority Queue.
        for(int i = 0; i < in.size(); ++i)
            mins.add(new ValAndLoc(in.get(i).get(0), i, 0));

        ArrayList<Integer> out = new ArrayList<>();

        while(mins.size() > 0)
        {
            ValAndLoc temp = mins.poll();

            out.add(temp.value);
            temp.elementIndex++;

            if(in.get(temp.arrayIndex).size() > temp.elementIndex) {
                temp.value = in.get(temp.arrayIndex).get(temp.elementIndex);
                mins.add(temp);
            }
        }
        return out;
    }
}
