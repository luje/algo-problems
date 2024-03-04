package org.home.advent2022;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        long score = 0;

        while (input.hasNext()) {
            final String line = input.nextLine();

            score += calc(line.charAt(0), line.charAt(2));
        }

        System.out.println(score);
    }

    private static long calc(char him, char target) {
        System.out.println(him + " " + target + " => " + choose(him, target));


        return score(him, choose(him, target));
    }

    private static char choose(char him, char target) {
        if (target == 'Z') {
            return (char) ('A' + (him - 'A' + 1 + 3) % 3);
        } else if (target == 'X') {
            return (char) ('A' + (him - 'A' - 1 + 3) % 3);
        } else return him;
    }

    private static long score(char him, char me) {
        int choice = Math.abs('A' - me) + 1;
        int score = 0;

        if (him == 'A' && me == 'A') score = 3;
        else if (him == 'B' && me == 'B') score = 3;
        else if (him == 'C' && me == 'C') score = 3;
        else if (him == 'A' && me == 'B') score = 6;
        else if (him == 'B' && me == 'C') score = 6;
        else if (him == 'C' && me == 'A') score = 6;

        return choice + score;
    }
}
