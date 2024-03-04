package org.home.other4;

import java.util.Arrays;
import java.util.Random;

// https://leetcode.com/problems/random-pick-with-weight/description/
public class RandomWeight {

    static class Solution {

        private final int sum;
        private final int[] w;
        private final Random r = new Random();

        public Solution(int[] w) {
            this.w = w;

            for (int i = 1; i < w.length; i++) {
                w[i] = w[i - 1] + w[i];
            }

            sum = w[w.length - 1];
        }

        public int pickIndex() {
            final var i = r.nextInt(sum);

            return Math.abs(Arrays.binarySearch(w, i));
        }
    }

    public static void main(String[] args) {
        final var solver = new Solution(new int[]{1, 1, 1, 0});

        System.out.println(solver.pickIndex());
    }

}
