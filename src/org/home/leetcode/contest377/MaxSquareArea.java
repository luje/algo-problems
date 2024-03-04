package org.home.leetcode.contest377;

import java.util.HashSet;
import java.util.Set;

public class MaxSquareArea {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        var h = edges(m, hFences);
        var v = edges(n, vFences);

        var area = -1L;

        for (Integer e : h) {
            if (v.contains(e)) {
                area = Math.max(((long) e) * ((long) e), area);
            }
        }

        return (int) (area % 1_000_000_007L);
    }

    public Set<Integer> edges(int size, int[] fences) {
        var result = new HashSet<Integer>();

        for (int i = 0; i < fences.length; i++) {
            int e = fences[i];

            result.add(e - 1);
            result.add(size - e);
        }

        result.add(size - 1);

        for (int i = 0; i < fences.length - 1; i++) {
            for (int j = i + 1; j < fences.length; j++) {
                var f1 = fences[i];
                var f2 = fences[j];

                result.add(Math.abs(f1 - f2));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final var solver = new MaxSquareArea();

        System.out.println("9 = " + solver.maximizeSquareArea(4, 5, new int[]{2}, new int[]{4}));
        System.out.println("16 = " + solver.maximizeSquareArea(8, 5, new int[]{5, 4}, new int[]{4}));
        System.out.println("4 = " + solver.maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2}));
        System.out.println("4 = " + solver.maximizeSquareArea(3, 9, new int[]{2}, new int[]{8, 6, 5, 4}));
        System.out.println("-1 = " + solver.maximizeSquareArea(6, 7, new int[]{2}, new int[]{4}));
    }
}
