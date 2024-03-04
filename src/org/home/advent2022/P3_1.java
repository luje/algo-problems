package org.home.advent2022;

import java.util.Scanner;

public class P3_1 {

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

        long score1 = 0;

        while (input.hasNext()) {
            score1 += calc(input.nextLine());
        }

        System.out.println(score1);
    }

    private static long calc(String line) {
        boolean[] found = new boolean['z' + 1];
        long result = 0;

        for (int i = 0; i < line.length() / 2; i++) {
            found[line.charAt(i)] = true;
        }

        for (int i = line.length() / 2; i < line.length(); i++) {
            if (found[line.charAt(i)]) {
                return PRIORITIES[line.charAt(i)];
            }
        }

        return result;
    }
}
