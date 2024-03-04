package org.home.advent2022;

import java.util.Scanner;

public class P4_1 {

    public static void main(String[] args) {
        final Scanner input = new Scanner(System.in);

        int resultInclude = 0;
        int resultOverlap = 0;

        while (input.hasNext()) {
            final String line = input.nextLine();

            final String[] sections = line.split(",");

            final int[] s1 = asPair(sections[0]);
            final int[] s2 = asPair(sections[1]);

            resultInclude += calcInclude(s1, s2);
            resultOverlap += calcOverlap(s1, s2);
        }

        System.out.println(resultInclude);
        System.out.println(resultOverlap);
    }

    private static int calcInclude(int s1[], int s2[]) {
        return s1[0] <= s2[0] && s2[1] <= s1[1] ||
                s2[0] <= s1[0] && s1[1] <= s2[1] ? 1 : 0;
    }

    private static int calcOverlap(int s1[], int s2[]) {
        if(s1[0] < s2[0] && s1[1] < s2[0]) return 0;
        else if(s2[0] < s1[0] && s2[1] < s1[0]) return 0;
        else return 1;
    }

    private static int[] asPair(String section) {
        final String[] split = section.split("-");

        return new int[]{Integer.valueOf(split[0]), Integer.valueOf(split[1])};
    }

    private static String print(int[] section) {
        return section[0] + "-" + section[1];
    }
}
