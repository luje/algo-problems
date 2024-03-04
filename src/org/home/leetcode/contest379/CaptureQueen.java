package org.home.leetcode.contest379;

public class CaptureQueen {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {

        if (a == e) {
            if (a != c)
                return 1;

            for (int i = b; i > 0 && i < 9; i += (f - b) / Math.abs(f - b)) {
                if (i == f)
                    return 1;
                if (i == d)
                    return 2;
            }

            return 1;
        }

        if (b == f) {
            if (b != d)
                return 1;

            for (int i = a; i > 0 && i < 9; i += (e - a) / Math.abs(e - a)) {
                if( i == e)
                    return 1;
                if (i == c)
                    return 2;
            }

            return 1;
        }

        if (Math.abs(c - e) == Math.abs(d - f)) {
            if (Math.abs(c - a) != Math.abs(b - d))
                return 1;

            for (int i = c, j = d;
                 i > 0 && i < 9 && j > 0 && j < 9;
                 i += (e - c) / Math.abs(e - c),
                         j += (f - d) / Math.abs(f - d)) {
                if (i == e && j == f)
                    return 1;
                if (i == a && j == b)
                    return 2;
            }

            return 1;
        }

        return 2;
    }

    public static void main(String[] args) {
        var solver = new CaptureQueen();

        System.out.println(solver.minMovesToCaptureTheQueen(4, 7, 8, 3, 7, 4));
        System.out.println(solver.minMovesToCaptureTheQueen(4, 5, 7, 8, 2, 3));
        System.out.println(solver.minMovesToCaptureTheQueen(3, 4, 4, 8, 7, 4));
        System.out.println(solver.minMovesToCaptureTheQueen(4, 3, 3, 4, 2, 5));
        System.out.println(solver.minMovesToCaptureTheQueen(1, 1, 1, 4, 1, 8));
        System.out.println(solver.minMovesToCaptureTheQueen(4, 3, 3, 4, 5, 2));
    }
}
