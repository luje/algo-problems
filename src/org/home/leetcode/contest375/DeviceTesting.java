package org.home.leetcode.contest375;

import java.util.Arrays;

// https://leetcode.com/contest/weekly-contest-375/problems/count-tested-devices-after-test-operations/
public class DeviceTesting {

    public int countTestedDevices(int[] bp) {
        return Arrays.stream(bp)
                .reduce(0, (r, e) -> e - r > 0 ? r + 1 : r);
    }

    public static void main(String[] args) {
        var solver = new DeviceTesting();

        System.out.println("3 = " + solver.countTestedDevices(new int[]{1, 1, 2, 1, 3}));
        System.out.println("2 = " + solver.countTestedDevices(new int[]{0, 1, 2}));
    }
}
