package org.home.other4;

//https://leetcode.com/problems/split-array-largest-sum/description/
public class SplitArraysLargestSum {
    public int splitArray(int[] nums, int k) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }

        final var avg = nums[nums.length - 1] / (double) k;
        int min = 0;

        return min;
    }

    public static void main(String[] args) {
        final var solver = new SplitArraysLargestSum();

        System.out.println("18 = " + solver.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println("18 = " + solver.splitArray(new int[]{1, 2, 3, 4, 5}, 2));
    }
}
