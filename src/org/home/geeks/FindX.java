package org.home.geeks;

public class FindX {

    int countX(int L, int R, int X) {
        return countX(R, X) - countX(L, X);
    }

    int countX(int r, int x) {

        return countX(r / 10, x) * 9 + r / 10;
    }

    public static void main(String[] args) {
        final var solver = new FindX();

        System.out.println("9 = " + solver.countX(10, 19, 1));
        System.out.println("7 = " + solver.countX(18, 81, 9));
    }
}
