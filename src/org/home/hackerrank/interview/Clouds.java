package org.home.hackerrank.interview;

import java.util.List;

public class Clouds {
    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        final var n = c.size();
        var result = 0;

        for (int i = 0; i < n; i++) {
            if(i + 2 < n && c.get(i) == 0) {
                i++;
            }

            result++;
        }

        return result - 1;
    }

    public static void main(String[] args) {
        final var solver = new Clouds();

        System.out.println(Clouds.jumpingOnClouds(List.of(0, 0, 1, 0, 0, 1, 0)));
        System.out.println(Clouds.jumpingOnClouds(List.of(0, 0, 0, 0, 1, 0)));
    }
}
