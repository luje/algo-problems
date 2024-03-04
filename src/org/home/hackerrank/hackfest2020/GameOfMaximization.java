package org.home.hackerrank.hackfest2020;

import java.util.List;

//https://www.hackerrank.com/contests/hackerrank-hackfest-2020/challenges/stones-piles
public class GameOfMaximization {

    public static int maximumStones(List<Integer> arr) {
        int sl = 0;
        int sr = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (i % 2 == 0) {
                sl += arr.get(i);
            } else {
                sr += arr.get(i);
            }
        }

        return 2 * Math.min(sl, sr);
    }
}
