package org.home.other3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> ht = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            final int rest = target - nums[i];

            if (ht.containsKey(rest))
                return new int[]{i, ht.get(rest)};

            ht.put(nums[i], i);
        }

        throw new IllegalStateException("Should not be here");
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();

//        print(solution.twoSum(new int[]{2, 7, 11, 15}, 9));
//        print(solution.twoSum(new int[]{3, 3}, 6));
        print(solution.twoSum(new int[]{3, 2, 4}, 6));
    }

    private static void print(int[] twoSum) {
        System.out.println(
                Arrays.stream(twoSum)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "))
        );
    }
}
