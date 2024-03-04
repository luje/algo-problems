package org.home.leetcode.random;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/build-an-array-with-stack-operations/description/
public class ArrayWithStackOperations {

    public List<String> buildArray(int[] target, int n) {
        final var result = new ArrayList<String>();

        var i = 1;

        for(int c : target) {
            result.add("Push");

            while(c > i++) {
                result.add("Pop");
                result.add("Push");
            }
        }

        return result;
    }

    public static void main(String[] args) {
        var solver = new ArrayWithStackOperations();

        System.out.println(solver.buildArray(new int[]{1, 3}, 3));
        System.out.println(solver.buildArray(new int[]{1, 2, 3}, 3));
        System.out.println(solver.buildArray(new int[]{1, 2}, 4));
    }
}
