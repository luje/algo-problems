package org.home.other4;

// https://leetcode.com/problems/toeplitz-matrix/
public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int l = 0; l < matrix.length - 1; l++) {
            for (int i = 0; i < matrix[0].length - 1; i++) {
                if (matrix[l][i] != matrix[l + 1][i + 1]) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        final var solver = new ToeplitzMatrix();

        System.out.println(solver.isToeplitzMatrix(new int[][]{
                {36, 59, 71, 15, 26, 82, 87},
                {56, 36, 59, 71, 15, 26, 82},
                {15, 0, 36, 59, 71, 15, 26}
        }));

        System.out.println(solver.isToeplitzMatrix(new int[][]{
                {11, 74, 0, 93},
                {40, 11, 74, 7}
        }));

        System.out.println(solver.isToeplitzMatrix(new int[][]{
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        }));

    }
}
