package org.home.other4;

// https://leetcode.com/problems/2-keys-keyboard/
public class _2KeysKeyboard {

    public int minSteps(int n) {
        return minSteps(n, 1, 0) - 1;
    }

    public int minSteps(int target, int current, int cb) {
        if (current > target || cb > target)
            return 10001;
        if (current == target)
            return 1;
        if (cb != 0 && target % cb == 0)
            return target / cb;

        return Math.min(
                cb == current ? 10001 : 1 + minSteps(target, current, current), // copy
                cb == 0 ? 10001 : 1 + minSteps(target, current + cb, cb) // paste
        );
    }

    public static void main(String[] args) {
        final var solver = new _2KeysKeyboard();

        System.out.println("5 = " + solver.minSteps(6));
//        System.out.println("4 = " + solver.minSteps(4));
//        System.out.println("2 = " + solver.minSteps(2));
//        System.out.println("0 = " + solver.minSteps(1));
//        System.out.println("3 = " + solver.minSteps(3));
    }
}
