package org.home.other3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortColors {

    public void sortColors(int[] nums) {
        int[] freq = new int[3];

        for (int i : nums) {
            freq[i]++;
        }

        int idx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < freq[i]; j++) {
                nums[idx++] = i;
            }
        }
    }

    public static void main(String[] args) {
        SortColors solver = new SortColors();

        int[] nums = new int[]{2, 0, 2, 1, 1, 0};

        solver.sortColors(nums);

        System.out.println(Arrays.stream(nums)
                .mapToObj(it -> String.valueOf(it))
                .collect(Collectors.joining(" ")));
    }
}
