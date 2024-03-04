package org.home.leetcode.contest375;

import java.util.ArrayList;
import java.util.List;

//
public class DoubleModExp {

    public List<Integer> getGoodIndices(int[][] variables, int target) {
        var result = new ArrayList<Integer>();

        for (int i = 0; i < variables.length; i++) {
            var v = variables[i];
            var a = v[0];
            var b = v[1];
            var c = v[2];
            var d = v[3];

            if (powMod(powMod(a, b, 10), c, d) == target) {
                result.add(i);
            }
        }

        return result;
    }

    private int powMod(int a, int b, int mod) {
        if (b % 2 == 1) {
            return (a * powMod(a, b - 1, mod)) % mod;
        }

        if (b == 0)
            return 1;

        var x = powMod(a, b / 2, mod) % mod;

        return (x * x) % mod;
    }

    public static void main(String[] args) {
        var solver = new DoubleModExp();

        System.out.println(solver.getGoodIndices(new int[][]{{33, 51, 31, 42}}, 40));
        System.out.println(solver.getGoodIndices(new int[][]{{55, 19, 87, 22}, {64, 8, 83, 81}, {72, 3, 19, 83}}, 34));
        System.out.println(solver.getGoodIndices(new int[][]{{31, 12, 21, 24}}, 1));
        System.out.println(solver.getGoodIndices(new int[][]{{51, 35, 21, 52}}, 1));
        System.out.println(solver.getGoodIndices(new int[][]{{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}}, 2));
        System.out.println(solver.getGoodIndices(new int[][]{{39, 3, 1000, 1000}}, 17));
    }

}
