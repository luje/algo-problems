package org.home.contest306;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SmallestNumberDIString {

    public String smallestNumber(String pattern) {
        return Arrays.stream(back(0, pattern, new int[pattern.length() + 1] , new HashSet<>()))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    public int[] back(int k, String pattern, int[] result, Set<Integer> used) {
        if (k == pattern.length() + 1)
            return result;

        int initial = 1;
        int increment = 1;

        if (k == 0) {
            initial = 1;
            increment = 1;
        } else if (pattern.charAt(k - 1) == 'I') {
            initial = result[k - 1] + 1;
            increment = 1;
        } else if (pattern.charAt(k - 1) == 'D') {
            initial = result[k - 1] - 1;
            increment = -1;
        }

        for (int i = initial; 0 < i && i < 10; i += increment) {

            if(used.contains(i)) {
                continue;
            }

            result[k] = i;

            used.add(i);

            back(k + 1, pattern, result, used);

            used.remove(i);

            if (result[result.length - 1] != 0) {
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SmallestNumberDIString solver = new SmallestNumberDIString();

        System.out.println(solver.smallestNumber("IIIDIDDD"));
    }
}
