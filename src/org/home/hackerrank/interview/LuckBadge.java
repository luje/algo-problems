package org.home.hackerrank.interview;

import java.util.List;
import java.util.PriorityQueue;

public class LuckBadge {

    public static int luckBalance(int k, List<List<Integer>> contests) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int sum = 0;

        for (List<Integer> contest : contests) {
            if(contest.get(1) == 1) {
                pq.add(contest.get(0));
            }

            sum += contest.get(0);
        }

        while (pq.size() > k) {
            sum -= 2 * pq.poll();
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("8=" + luckBalance(2, List.of(
                List.of(5, 1),
                List.of(1, 1),
                List.of(4, 1)
        )));

        System.out.println("29=" + luckBalance(3, List.of(
                List.of(5, 1),
                List.of(2, 1),
                List.of(1, 1),
                List.of(8, 1),
                List.of(10, 0),
                List.of(5, 0)
        )));
    }
}
