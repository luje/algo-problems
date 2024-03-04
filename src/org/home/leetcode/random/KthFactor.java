package org.home.leetcode.random;

// https://leetcode.com/problems/the-kth-factor-of-n/?envType=study-plan-v2&envId=amazon-spring-23-high-frequency
public class KthFactor {

    public int kthFactor(int n, int k) {
        if(k == 1)
            return 1;

        int count = 1;

        for (int i = 2; i < n / 2 + 1; i++) {
            if(n % i == 0) {
                count++;
            }

            if(count == k) {
                return i;
            }
        }

        return count == k - 1 ? n : -1;
    }

    public static void main(String[] args) {
        var solver = new KthFactor();

        System.out.println("1 = " + solver.kthFactor(4, 1));
        System.out.println("1 = " + solver.kthFactor(1, 1));
        System.out.println("3 = " + solver.kthFactor(12, 3));
        System.out.println("7 = " + solver.kthFactor(7, 2));
        System.out.println("-1 = " + solver.kthFactor(4, 4));
    }
}
