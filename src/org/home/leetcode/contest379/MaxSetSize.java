package org.home.leetcode.contest379;

import java.util.HashSet;

public class MaxSetSize {

    public int maximumSetSize(int[] nums1, int[] nums2) {
        var limit = nums1.length;

        var f1 = new HashSet<Integer>();
        var f2 = new HashSet<Integer>();

        for (int e : nums1) {
            f1.add(e);
        }

        int common = 0;

        for (int e : nums2) {
            if (f2.add(e)) {
                if (f1.contains(e)) {
                    common++;
                }
            }
        }

        var uf1 = Math.min(f1.size() - common, limit / 2);
        var uf2 = Math.min(f2.size() - common, limit / 2);

        if (uf1 < limit / 2) {
            var diff = (limit / 2) - uf1;

            uf1 += Math.min(diff, common);
            common = Math.max(common - diff, 0);
        }

        if (uf2 < limit / 2) {
            var diff = (limit / 2) - uf2;

            uf2 += Math.min(diff, common);
        }

        return uf1 + uf2;
    }

    public static void main(String[] args) {
        var solver = new MaxSetSize();

        System.out.println("5 = " + solver.maximumSetSize(new int[]{1, 2, 3, 4, 5, 6}, new int[]{2, 3, 2, 3, 2, 3}));
        System.out.println("4 = " + solver.maximumSetSize(new int[]{2, 4, 1, 4}, new int[]{10, 2, 4, 10}));
        System.out.println("4 = " + solver.maximumSetSize(new int[]{1, 2, 1, 1}, new int[]{1, 2, 3, 4}));
        System.out.println("2 = " + solver.maximumSetSize(new int[]{1, 2, 1, 2}, new int[]{1, 1, 1, 1}));
        System.out.println("6 = " + solver.maximumSetSize(new int[]{1, 1, 2, 2, 3, 3}, new int[]{4, 4, 5, 5, 6, 6}));
    }
}
