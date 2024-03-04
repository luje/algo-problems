package org.home.ace.day8;

public class BinarySearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        return searchL(matrix, target, 0, matrix.length);
    }

    public boolean searchL(int[][] matrix, int target, int r1, int r2) {
        if (r1 >= r2)
            return searchR(matrix[r1], target, 0, matrix[0].length);

        final int mid = (r1 + r2) / 2;

        if (target <= matrix[mid][matrix[0].length - 1]) {
            return searchL(matrix, target, r1, mid);
        } else if(mid + 1 < matrix.length) {
            return searchL(matrix, target, mid + 1, r2);
        } else {
            return false;
        }
    }

    private boolean searchR(int[] matrix, int target, int i, int j) {
        if (i == j)
            return matrix[i] == target;

        final int mid = (i + j) / 2;

        if (target == matrix[mid]) {
            return true;
        } else if (target < matrix[mid]) {
            return searchR(matrix, target, i, mid);
        } else {
            return searchR(matrix, target, mid + 1, j);
        }
    }

    public static void main(String[] args) {
        BinarySearchMatrix solver = new BinarySearchMatrix();

        System.out.println(solver.searchMatrix(new int[][]{
                {1}
        }, 2));

        System.out.println(solver.searchMatrix(new int[][]{
                {1}
        }, 1));

        System.out.println(solver.searchMatrix(new int[][]{
                {1}
        }, 0));

//        System.out.println(solver.searchMatrix(new int[][]{
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 60}
//        }, 3));

        System.out.println(solver.searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 16));

        System.out.println(solver.searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 17));
    }
}
