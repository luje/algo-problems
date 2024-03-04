package org.home.advent2022;

import java.util.Scanner;

public class P3_2 {

    private static int[] PRIORITIES = new int['z' + 1];

    static {
        for (short i = 0; i <= 'z' - 'a'; i++) {
            PRIORITIES[(char) ('a' + i)] = i + 1;
        }

        for (short i = 0; i <= 'Z' - 'A'; i++) {
            PRIORITIES[(char) (i + 'A')] = 27 + i;
        }
    }

    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        long score = 0;

        while (input.hasNext()) {
            String r1 = input.nextLine();
            String r2 = input.nextLine();
            String r3 = input.nextLine();

            score += calc(r1, r2, r3);
        }

        System.out.println(score);
    }

    private static long calc(String r1, String r2, String r3) {
        boolean[] found1 = new boolean['z' + 1];
        boolean[] found2 = new boolean['z' + 1];

        r1.chars().forEach(c -> found1[c] = true);
        r2.chars().forEach(c -> found2[c] = found1[c]);

        return r3.chars().mapToObj(c -> (char) c)
                .filter(c -> found2[c])
                .findFirst()
                .map(c -> PRIORITIES[c])
                .orElse(0);
    }
}
