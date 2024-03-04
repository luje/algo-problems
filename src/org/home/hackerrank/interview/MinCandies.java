package org.home.hackerrank.interview;

import java.util.List;

public class MinCandies {

    public static long candies(int n, List<Integer> arr) {
        return candies(arr, 0, 0);
    }

    public static long candies(List<Integer> arr, int start, int min) {
        if(start == arr.size() - 1) {
            return arr.get(start) > arr.get(start - 1) ? min + 1 : 1;
        }


        candies(arr, start + 1, arr.get(start) > arr.get(start - 1) ? min + 1 : 1);

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("4=" + candies(3, List.of(1, 2, 2)));
        System.out.println("19=" + candies(10, List.of(2, 4, 2, 6, 1, 7, 8, 9, 2, 1)));
        System.out.println("12=" + candies(8, List.of(2, 4, 3, 5, 2, 6, 4, 5)));
    }
}
