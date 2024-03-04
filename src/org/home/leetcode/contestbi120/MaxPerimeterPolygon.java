package org.home.leetcode.contestbi120;

import java.util.Arrays;

// https://leetcode.com/contest/biweekly-contest-120/problems/find-polygon-with-the-largest-perimeter/
public class MaxPerimeterPolygon {

    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        long[] sums = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        for (int i = nums.length; i > 0; i--) {
            if (nums[i - 1] < sums[i - 1]) {
                return sums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        var solver = new MaxPerimeterPolygon();

        System.out.println("15 = " + solver.largestPerimeter(new int[]{5, 5, 5}));
        System.out.println("12 = " + solver.largestPerimeter(new int[]{1, 12, 1, 2, 5, 50, 3}));
        System.out.println("-1 = " + solver.largestPerimeter(new int[]{5, 5, 50}));
    }
}
