package org.home.hackerrank.interview;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TripleSum {

    public static long triplets(List<Integer> aa, List<Integer> bb, List<Integer> cc) {
        var a = aa.stream().distinct().sorted().collect(Collectors.toList());
        var b = bb.stream().distinct().sorted().collect(Collectors.toList());
        var c = cc.stream().distinct().sorted().collect(Collectors.toList());

        long result = 0;

        for (final Integer q : b) {
            final var ip = Collections.binarySearch(a, q);
            final var cp = (long) (ip >= 0 ? ip + 1 : -ip - 1);

            final var ir = Collections.binarySearch(c, q);
            final var cr = (long) (ir >= 0 ? ir + 1 : -ir - 1);

            result += cp * cr;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("5=" + triplets(List.of(1, 4, 5), List.of(2, 3, 3), List.of(1, 2, 3)));
        System.out.println("12=" + triplets(List.of(1, 3, 5, 7), List.of(5, 7, 9), List.of(7, 9, 11, 13)));
        System.out.println("8=" + triplets(List.of(1, 3, 5), List.of(2, 3), List.of(1, 2, 3)));
    }
}
