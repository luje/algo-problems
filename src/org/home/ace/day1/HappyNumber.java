package org.home.ace.day1;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    private Set<Integer> seen = new HashSet<>();

    public boolean isHappy(int n) {
        if(seen.contains(n))
            return false;

        seen.add(n);

        if(n == 1)
            return true;

        int sum = 0;

        while (n > 0) {
            int p = n % 10;
            n = n / 10;

            sum += p * p;
        }

        return isHappy(sum);
    }

    public static void main(String[] args) {
        final HappyNumber solver = new HappyNumber();

//        System.out.println("true=" + solver.isHappy(19));
        System.out.println("true=" + solver.isHappy(2));
    }
}
