package org.home.ace.day1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WhereTheBallFall {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];

        for (int i = 0; i < grid[0].length; i++) {
            result[i] = findBall(grid, i);
        }

        return result;
    }

    private int findBall(int[][] grid, int i) {
        int r = i;

        for (int j = 0; j < grid.length; j++) {
            int nr = r + grid[j][r];

            if(nr < 0 || nr >= grid[0].length) {
                return -1;
            }

            if(grid[j][r] != grid[j][nr]) {
                return -1;
            }

            r = nr;
        }

        return r;
    }

    public static void main(String[] args) {
        WhereTheBallFall solver = new WhereTheBallFall();

        final int[] result = solver.findBall(new int[][]{
                {1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1}
        });

        System.out.println(Arrays.stream(result)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }
}
