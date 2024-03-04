package org.home.leetcode.contestbi120;

//https://leetcode.com/contest/biweekly-contest-120/problems/count-the-number-of-incremovable-subarrays-i/
public class IncremovableSubarays {

    public int incremovableSubarrayCount(int[] nums) {
//        System.out.println("----------");

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length + 1; j++) {

                if (increasing(nums, i, j)) {
//                    System.out.println(i + " -> " + j);
                    count++;
                }
            }
        }

        return count;
    }

    private boolean increasing(int[] nums, int s, int e) {
        int prev = -1;

        for (int i = 0; i < nums.length; i++) {
            if (i >= s && i < e)
                continue;

            if (prev == -1) {
                prev = nums[i];

                continue;
            }

            if (prev >= nums[i]) {
                return false;
            }

            prev = nums[i];
        }

        return true;
    }

    public static void main(String[] args) {
        var solver = new IncremovableSubarays();

        System.out.println("6 = " + solver.incremovableSubarrayCount(new int[]{3, 5, 3, 5}));
        System.out.println("10 = " + solver.incremovableSubarrayCount(new int[]{1, 2, 3, 4}));
        System.out.println("7 = " + solver.incremovableSubarrayCount(new int[]{6, 5, 7, 8}));
        System.out.println("3 = " + solver.incremovableSubarrayCount(new int[]{8, 7, 6, 6}));
    }
}
