package org.home.geeks;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1
public class MinimizeHeights2 {

    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);

        int ans = arr[n - 1] - arr[0];

        int tmin;
        int tmax;

        for (int i = 1; i < n; i++) {
            if (arr[i] < k) {
                continue;
            }

            tmin = Math.min(arr[0] + k, arr[i] - k);
            tmax = Math.max(arr[i - 1] + k, arr[n - 1] - k);

            ans = Math.min(ans, tmax - tmin);
        }

        return ans;
    }

    public static void main(String[] args) {
        final var solver = new MinimizeHeights2();

        System.out.println("5 = " + solver.getMinDiff(new int[]{2, 4, 3, 9, 9, 10, 9, 7, 1, 2}, 10, 7));
        System.out.println("11 = " + solver.getMinDiff(new int[]{3, 9, 12, 16, 20}, 5, 3));
        System.out.println("2 = " + solver.getMinDiff(new int[]{7, 7, 3, 5}, 4, 1));
        System.out.println("5 = " + solver.getMinDiff(new int[]{1, 5, 8, 10}, 4, 2));
        System.out.println("9 = " + solver.getMinDiff(new int[]{1, 8, 10, 6, 4, 6, 9, 1}, 8, 7));
        System.out.println("5 = " + solver.getMinDiff(new int[]{2, 4, 3, 9, 9, 10, 9, 7, 1, 2}, 10, 4));
    }
}
