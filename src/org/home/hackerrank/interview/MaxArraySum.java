package org.home.hackerrank.interview;

import java.util.Arrays;

public class MaxArraySum {
    static int maxSubsetSum(int[] arr) {
        int[] cache = new int[arr.length + 2];

        Arrays.fill(cache, -1);

        return maxSubsetSum(arr, 0, cache);
    }

    static int maxSubsetSum(int[] arr, int start, int[] cache) {
        if(cache[start] >= 0)
            return cache[start];

        if (start >= arr.length)
            return cache[start] = 0;

        if(arr[start] < 0) {
            return cache[start] = maxSubsetSum(arr, start + 1, cache);
        }

        return cache[start] = Math.max(
                arr[start] + maxSubsetSum(arr, start + 2, cache),
                maxSubsetSum(arr, start + 1, cache)
        );
    }

    public static void main(String[] args) {
        System.out.println("8=" + maxSubsetSum(new int[]{-2, 1, 3, -4, 5}));
        System.out.println("13=" + maxSubsetSum(new int[]{3, 7, 4, 6, 5}));
        System.out.println("11=" + maxSubsetSum(new int[]{2, 1, 5, 8, 4}));
        System.out.println("15=" + maxSubsetSum(new int[]{3, 5, -7, 8, 10}));
    }
}
