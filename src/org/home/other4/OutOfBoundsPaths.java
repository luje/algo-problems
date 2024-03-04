package org.home.other4;

import java.util.Arrays;
import java.util.stream.Stream;


// https://leetcode.com/problems/out-of-boundary-paths/
public class OutOfBoundsPaths {

    public static final int MOD = 1_000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] cache = new int[maxMove + 1][m][n];

        for (int[][] line : cache)
            for (int[] row : line)
                Arrays.fill(row, -1);

        return findPaths(m, n, maxMove, startRow, startColumn, cache);
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn, int[][][] cache) {
        if (maxMove < 0)
            return 0;

        if ((startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n))
            return 1;

        if (cache[maxMove][startRow][startColumn] >= 0) {
            return cache[maxMove][startRow][startColumn];
        }

        cache[maxMove][startRow][startColumn] = Stream.of(
                        findPaths(m, n, maxMove - 1, startRow - 1, startColumn, cache),
                        findPaths(m, n, maxMove - 1, startRow + 1, startColumn, cache),
                        findPaths(m, n, maxMove - 1, startRow, startColumn - 1, cache),
                        findPaths(m, n, maxMove - 1, startRow, startColumn + 1, cache))
                .reduce((a, b) -> (a + b) % MOD)
                .get();

        return cache[maxMove][startRow][startColumn];
    }

    public static void main(String[] args) {
        final var solver = new OutOfBoundsPaths();

        System.out.println("9 = " + solver.findPaths(1, 2, 3, 0, 0));
        System.out.println("150 = " + solver.findPaths(1, 2, 50, 0, 0));
        System.out.println("6 = " + solver.findPaths(2, 2, 2, 0, 0));
        System.out.println("12 = " + solver.findPaths(1, 3, 3, 0, 1));
        System.out.println("1104 = " + solver.findPaths(2, 3, 8, 1, 0));
        System.out.println("12 = " + solver.findPaths(1, 2, 4, 0, 0));
        System.out.println("15 = " + solver.findPaths(1, 2, 5, 0, 0));
        System.out.println("102984580 = " + solver.findPaths(8, 7, 16, 1, 5));
        System.out.println("914783380 = " + solver.findPaths(8, 50, 23, 5, 26));
        System.out.println("355074438 = " + solver.findPaths(30, 24, 23, 26, 12));
    }
}
