package org.home.geeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.geeksforgeeks.org/problems/transform-to-prime4635/1
public class TransformToPrime {

    final int MAX = 1_000_005;

    static boolean[] isPrime;

    public int minNumber(int arr[], int N) {
        final var sum = Arrays.stream(arr).sum();
        final var primes = primes();

        return java.util.stream.IntStream.range(sum, MAX)
                .filter(it -> primes[it])
                .mapToObj(it -> (Integer) it)
                .findFirst()
                .map(it -> it - sum)
                .get();
    }

    public boolean[] primes() {
        if (isPrime != null) {
            return isPrime;
        }

        int n = MAX;

        final List<Integer> primes = new ArrayList<>(MAX);
        isPrime = new boolean[MAX];
        final int[] pf = new int[MAX];

        Arrays.fill(isPrime, true);

        for (int i = 2; i < n; i++) {

            if(isPrime[i]) {
                primes.add(i);
                pf[i] = i;
            }

            for (int j = 0; j < primes.size(); j++) {

                final var op = primes.get(j);

                if(i * op >= n || op > pf[i])
                    break;

                isPrime[i * op] = false;
                pf[i * op] = op;
            }
        }

        return isPrime;
    }

    public static void main(String[] args) {
        final var solver = new TransformToPrime();

        System.out.println("5 = " + solver.minNumber(new int[]{2, 4, 6, 8, 12}, 5));
        System.out.println("0 = " + solver.minNumber(new int[]{1, 5, 7}, 3));
    }
}
