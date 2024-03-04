package org.home.hackerrank.interview;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GreedyFlorist {
    static int getMinimumCost(int k, int[] c) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>(c.length, Comparator.<Integer>naturalOrder().reversed());

        for (int flower : c) {
            pq.add(flower);
        }

        var sum = 0;
        var counter = 0;

        do {
            final var flower = pq.poll();

            sum += (counter / k + 1) * flower;
            counter++;
        } while (!pq.isEmpty());

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("13=" + getMinimumCost(3, new int[]{2, 5, 6}));
        System.out.println("15=" + getMinimumCost(2, new int[]{2, 5, 6}));
        System.out.println("29=" + getMinimumCost(3, new int[]{1, 3, 5, 7, 9}));
    }
}
