package org.home.other4;

// https://leetcode.com/problems/subarray-product-less-than-k/
public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int end = 0;

        int c = 1;
        int count = 0;

        while (start < nums.length && end < nums.length) {
            c *= nums[end++];

            while (start < nums.length && c >= k) {
                c = c / nums[start++];
            }

            if (c == 0)
                return count;

            if (start < nums.length)
                count += end - start;
        }

        return count;
    }

    public static void main(String[] args) {
        final var solver = new SubarrayProductLessThanK();

        System.out.println("8=" + solver.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println("0=" + solver.numSubarrayProductLessThanK(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println("18=" + solver.numSubarrayProductLessThanK(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
        System.out.println("0=" + solver.numSubarrayProductLessThanK(new int[]{1, 1, 1}, 1));
        System.out.println("0=" + solver.numSubarrayProductLessThanK(new int[]{1, 2, 3}, 0));
    }
}
