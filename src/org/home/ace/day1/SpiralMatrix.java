package org.home.ace.day1;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;

        final ArrayList<Integer> result = new ArrayList<>();

        int level;

        for (level = 0; level < Math.min(m, n) / 2; level++) {
            result.addAll(spiralOrder(matrix, level));
        }

        for (int i = level; i < m - level; i++) {
            for (int j = level; j < n - level; j++) {
                result.add(matrix[i][j]);
            }
        }

        return result;
    }

    public List<Integer> spiralOrder(int[][] matrix, int level) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        for (int i = level; i < n - level; i++) {
            result.add(matrix[level][i]);
        }

        for (int i = level + 1; i < m - level; i++) {
            result.add(matrix[i][n - level - 1]);
        }

        for (int i = n - level - 1 - 1; i > level; i--) {
            result.add(matrix[m - level - 1][i]);
        }

        for (int i = m - level - 1; i > level; i--) {
            result.add(matrix[i][level]);
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix solver = new SpiralMatrix();

        System.out.println(solver.spiralOrder(new int[][]{
                {1}, {4}, {7}
        }));
    }
}
