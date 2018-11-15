package main.java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetKClosestStars {
    private static class LocAndDist{
        ArrayList<Integer> loc;
        double dist;
        LocAndDist() {}
        LocAndDist(ArrayList<Integer> l, double d) {loc = l; dist = d;}
    }

    public static ArrayList<ArrayList<Integer>> getKClosestStarts(ArrayList<ArrayList<Integer>> stars, int k)
    {
        if(stars == null || k == 0) return null;

        Comparator<LocAndDist> distanceComparator = new Comparator<LocAndDist>() {
            @Override
            public int compare(LocAndDist o1, LocAndDist o2) {
                return (int)(o2.dist - o1.dist);
            }
        };

        PriorityQueue<LocAndDist> closestStars = new PriorityQueue<>(k, distanceComparator);

        for(ArrayList<Integer> star : stars)
        {
            double dist = getDistanceToOrigin(star);

            if(closestStars.size() < k)
                closestStars.add(new LocAndDist(star, dist));
            else{
                if(dist < closestStars.peek().dist) {
                    closestStars.poll();
                    closestStars.add(new LocAndDist(star, dist));
                }
            }
        }

        ArrayList<ArrayList<Integer>> retVal = new ArrayList<>();

        while(closestStars.size() > 0)
            retVal.add(closestStars.poll().loc);

        return retVal;
    }

    private static double getDistanceToOrigin(ArrayList<Integer> l)
    {
        return Math.sqrt(l.get(0) * l.get(0) + l.get(1) * l.get(1) + l.get(2) * l.get(2));
    }
}
