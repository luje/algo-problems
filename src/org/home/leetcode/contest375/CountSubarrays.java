package org.home.leetcode.contest375;

//https://leetcode.com/contest/weekly-contest-375/problems/count-subarrays-where-max-element-appears-at-least-k-times/
public class CountSubarrays {

    public long countSubarrays(int[] nums, int k) {
        var max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        var result = 0L;
        var l = 0;
        var r = 0;
        var count = 0;

        while (l < nums.length && r < nums.length) {
            if (nums[r] == max) {
                count++;
            }

            r++;

            if (count < k)
                continue;

            while (nums[l] != max) {
                l++;
            }

            while (r < nums.length && nums[r] != max) {
                result += (l + 1L);
                r++;
            }

            result += (l + 1L);
            l += 1;
            count--;
        }

        return result;
    }

    public static void main(String[] args) {
        var solver = new CountSubarrays();

        System.out.println("4 = " + solver.countSubarrays(new int[]{1, 2, 2, 1}, 2));
        System.out.println("6 = " + solver.countSubarrays(new int[]{1, 2, 1, 2, 1, 1}, 2));
        System.out.println("10 = " + solver.countSubarrays(new int[]{1, 2, 1, 2, 1, 1, 2}, 2));
        System.out.println("14 = " + solver.countSubarrays(new int[]{1, 2, 1, 2, 1, 1, 2, 1}, 2));
        System.out.println("224 = " + solver.countSubarrays(new int[]{61, 23, 38, 23, 56, 40, 82, 56, 82, 82, 82, 70, 8, 69, 8, 7, 19, 14, 58, 42, 82, 10, 82, 78, 15, 82}, 2));
        System.out.println("6 = " + solver.countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
        System.out.println("0 = " + solver.countSubarrays(new int[]{1, 4, 2, 1}, 3));
    }
}
