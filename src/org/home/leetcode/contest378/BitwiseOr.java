package org.home.leetcode.contest378;

// https://leetcode.com/contest/weekly-contest-378/problems/check-if-bitwise-or-has-trailing-zeros/
public class BitwiseOr {

    public boolean hasTrailingZeros(int[] nums) {
        int e = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) e++;

            if(e == 2) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        var solver = new BitwiseOr();

        System.out.println(solver.hasTrailingZeros(new int[]{1, 2, 3, 4, 5}));
        System.out.println(solver.hasTrailingZeros(new int[]{2, 4, 8, 16}));
        System.out.println(solver.hasTrailingZeros(new int[]{1, 3, 5, 7, 9}));
    }
}
