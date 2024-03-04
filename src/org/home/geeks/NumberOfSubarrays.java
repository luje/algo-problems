package org.home.geeks;

// https://www.geeksforgeeks.org/problems/number-of-subarrays-with-maximum-values-in-given-range5949/1
public class NumberOfSubarrays {

    static long countSubarrays(int a[], int n, int L, int R) {
        // Complete the function

        var count = 0L;


        for (int i = 0; i < n; i++) {
            if (L > a[i] || R < a[i]) {
                continue;
            }

            int min = i;
            int max = i;

            while (min - 1 >= 0 && a[min - 1] < a[i]) {
                min--;
            }

            while (max + 1 < n && a[max + 1] <= a[i]) {
                max++;
            }

            count += (long) (i - min + 1) * (max - i + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println("19 = " + NumberOfSubarrays.countSubarrays(new int[]{1, 1, 3, 1, 1, 2, 3}, 7, 3, 3));
        System.out.println("4 = " + NumberOfSubarrays.countSubarrays(new int[]{2, 0, 11, 3, 0}, 5, 1, 10));
        System.out.println("5 = " + NumberOfSubarrays.countSubarrays(new int[]{3, 4, 1}, 3, 2, 4));
        System.out.println("5 = " + NumberOfSubarrays.countSubarrays(new int[]{1, 4, 3}, 3, 2, 4));
    }
}
