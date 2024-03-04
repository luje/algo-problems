package org.home.leetcode.contestbi119;

import java.util.HashMap;

// https://leetcode.com/contest/biweekly-contest-119/problems/length-of-longest-subarray-with-at-most-k-frequency/
public class ArraysWithFrequ {

    public int maxSubarrayLength(int[] nums, int k) {
        var f = new HashMap<Integer, Integer>();
        var result = 0;

        var l = 0;
        var r = 0;

        while (r < nums.length) {
            final var x = nums[r++];

            f.merge(x, 1, Integer::sum);

            if (f.get(x) <= k) {
                result = Math.max(result, r - l);

                continue;
            }

            while (l < r) {
                var y = nums[l++];
                f.merge(y, -1, Integer::sum);

                if (y == x) break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        var solver = new ArraysWithFrequ();

        System.out.println("2 = " + solver.maxSubarrayLength(new int[]{2, 3, 3, 2, 2,}, 1));
        System.out.println("3 = " + solver.maxSubarrayLength(new int[]{2, 1, 2, 3}, 1));
        System.out.println("2 = " + solver.maxSubarrayLength(new int[]{1, 4, 4, 3}, 1));
        System.out.println("2 = " + solver.maxSubarrayLength(new int[]{2, 2, 3}, 1));
        System.out.println("6 = " + solver.maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
        System.out.println("2 = " + solver.maxSubarrayLength(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1));
        System.out.println("4 = " + solver.maxSubarrayLength(new int[]{5, 5, 5, 5, 5, 5, 5}, 4));
    }

}
