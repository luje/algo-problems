package org.home.other4;

import java.util.Arrays;
import java.util.BitSet;
import java.util.stream.Collectors;

// https://leetcode.com/problems/set-mismatch/
public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        final var other = new BitSet(nums.length + 1);
        final var result = new int[2];

        for (int num : nums) {
            if(other.get(num))
                result[0] = num;

            other.set(num);
        }

        for (int i = 1; i < nums.length + 1; i++) {
            if (!other.get(i)) result[1] = i;
        }

        return result;
    }

    public static void main(String[] args) {
        final var solver = new SetMismatch();

        print(solver.findErrorNums(new int[]{1, 2, 2, 4}));
        print(solver.findErrorNums(new int[]{1, 1}));
    }

    private static void print(int[] result) {
        System.out.println(
                Arrays.stream(result)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(" "))
        );
    }
}
