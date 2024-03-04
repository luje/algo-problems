package org.home.leetcode.contest379;

// https://leetcode.com/contest/weekly-contest-379/problems/maximum-area-of-longest-diagonal-rectangle/
public class Rectangle {

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int diag = 0;
        int area = 0;

        for (int i = 0; i < dimensions.length; i++) {
            var l = dimensions[i][0];
            var w = dimensions[i][1];

            final var cDiag = l * l + w * w;

            if (cDiag > diag) {
                diag = cDiag;
                area = l * w;
            } else if(cDiag == diag) {
                area = Math.max(l * w, area);
            }
        }

        return area;
    }


}
