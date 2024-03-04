package org.home.leetcode.contest377;

import java.util.Arrays;

public class MinNumbersGame {

    public int[] numberGame(int[] nums) {
        var result = new int[nums.length];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 2) {
            result[i + 1] = nums[i];
            result[i] = nums[i + 1];
        }

        return result;
    }
}
