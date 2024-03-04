package org.home.hackerrank.hackfest2020;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.hackerrank.com/contests/hackerrank-hackfest-2020/challenges/strictly-increasing-sequence
public class StrictlyIncreasingSequence {

    public static String whoIsTheWinner(List<Integer> arr) {
        // WRITE DOWN YOUR CODE HERE
        final Map<Integer, Integer> freq = new HashMap<>();

        for (int i : arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        if (freq.entrySet().stream()
                .allMatch(it -> it.getValue() == 1)) {
            return "First";
        }

        int turns = 0;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            turns += entry.getValue();
        }

        return turns % 2 == 1 ? "First" : "Second";
    }

}
