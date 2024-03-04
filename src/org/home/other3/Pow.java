package org.home.other3;

import java.util.HashMap;
import java.util.Map;

public class Pow {

    public Map<Integer, Double> cache = new HashMap<>();

    public double myPow(double x, long n) {
        if (n == 0) return 1;
        if (n < 0) return 1 / myPow(x, -1 * n);
        else return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x, n - 1);
    }

    public static void main(String[] args) {
        final Pow p = new Pow();

//        System.out.println(p.myPow(2.0, -2));
//        System.out.println(p.myPow(2.0, 10));
//        System.out.println(p.myPow(2.1, 3));
        System.out.println(p.myPow(1.00000, -2147483648));
        System.out.println(p.myPow(0.00001, 2147483647));
    }
}
