package org.home.contest306;

public class LargestLocalValueMatrix {

    public int[][] largestLocal(int[][] grid) {
        final int n = grid.length;
        final int[][] result = new int[n - 2][n - 2];

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                result[i - 1][j - 1] = max(i, j, grid);
            }
        }

        return result;
    }

    private int max(int i, int j, int[][] grid) {
        int max = Integer.MIN_VALUE;

        for (int p = -1; p < 2; p++) {
            for (int q = -1; q < 2; q++) {
                max = Math.max(max, grid[i + p][j + q]);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        final LargestLocalValueMatrix solver = new LargestLocalValueMatrix();

        solver.largestLocal(new int[][]{
                {9, 9, 8, 1},
                {5, 6, 2, 6},
                {8, 2, 6, 4},
                {6, 2, 2, 2}
        });

    }
}
