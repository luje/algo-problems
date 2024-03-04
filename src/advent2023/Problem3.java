package advent2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Problem3 {
    private static final String digit = "0123456879";

    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        var in = new ArrayList<char[]>();

        while (scanner.hasNext()) {
            final var line = scanner.nextLine();

            in.add(line.toCharArray());
        }

        final char[][] a = in.toArray(new char[][]{});

        var sum = getSum(a);
        var gears = getGears(a);

        System.out.println(sum);
        System.out.println(gears);
    }

    private static long getSum(char[][] a) {
        var sum = 0L;

        for (int i = 0; i < a.length; i++) {
            var line = a[i];
            var num = 0L;
            var consider = false;

            for (int j = 0; j < line.length; j++) {
                var c = line[j];

                if (isDigit(c)) {
                    num = num * 10L + (c - '0');

                    // @formatter:off

                    if (i - 1 >= 0       && j - 1 >= 0           && isSymbol(a[i - 1][j - 1])) consider = true;
                    if (i - 1 >= 0                               && isSymbol(a[i - 1][j    ])) consider = true;
                    if (i - 1 >= 0       && j + 1 < line.length  && isSymbol(a[i - 1][j + 1])) consider = true;

                    if (                    j - 1 >= 0           && isSymbol(a[i    ][j - 1])) consider = true;
                    if (                    j + 1 < line.length  && isSymbol(a[i    ][j + 1])) consider = true;

                    if (i + 1 < a.length && j - 1 >= 0           && isSymbol(a[i + 1][j - 1])) consider = true;
                    if (i + 1 < a.length                         && isSymbol(a[i + 1][j    ])) consider = true;
                    if (i + 1 < a.length && j + 1 < line.length  && isSymbol(a[i + 1][j + 1])) consider = true;

                    // @formatter:on
                } else {

                    sum += consider ? num : 0;

                    num = 0;
                    consider = false;
                }
            }

            if (consider) {
                sum += num;
            }
        }

        return sum;
    }

    private static long getGears(char[][] a) {
        var gears = new HashMap<Gear, List<Long>>();

        for (int i = 0; i < a.length; i++) {
            var line = a[i];
            var num = 0L;
            var gear = (Gear) null;

            for (int j = 0; j < line.length; j++) {
                var c = line[j];

                if (isDigit(c)) {
                    num = num * 10L + (c - '0');

                    // @formatter:off

                    if (i - 1 >= 0       && j - 1 >= 0           && isGear(a[i - 1][j - 1])) gear = new Gear(i - 1 , j - 1);
                    if (i - 1 >= 0                               && isGear(a[i - 1][j    ])) gear = new Gear(i - 1 , j      );
                    if (i - 1 >= 0       && j + 1 < line.length  && isGear(a[i - 1][j + 1])) gear = new Gear(i - 1 , j + 1);

                    if (                    j - 1 >= 0           && isGear(a[i    ][j - 1])) gear = new Gear(i     , j - 1);
                    if (                    j + 1 < line.length  && isGear(a[i    ][j + 1])) gear = new Gear(i     , j + 1);

                    if (i + 1 < a.length && j - 1 >= 0           && isGear(a[i + 1][j - 1])) gear = new Gear(i + 1 , j - 1);
                    if (i + 1 < a.length                         && isGear(a[i + 1][j    ])) gear = new Gear(i + 1 , j       );
                    if (i + 1 < a.length && j + 1 < line.length  && isGear(a[i + 1][j + 1])) gear = new Gear(i + 1 , j + 1);

                    // @formatter:on
                } else {
                    if (gear != null) {
                        gears.putIfAbsent(gear, new ArrayList<>());
                        gears.get(gear).add(num);
                    }

                    num = 0;
                    gear = null;
                }
            }

            if (gear != null) {
                gears.putIfAbsent(gear, new ArrayList<>());
                gears.get(gear).add(num);
            }
        }

        return gears.values().stream()
                .filter(ratios -> ratios.size() == 2)
                .mapToLong(ratios -> ratios.get(0) * ratios.get(1))
                .sum();
    }

    record Gear(int i, int j) {
    }

    private static boolean isGear(char c) {
        return c == '*';
    }

    private static boolean isSymbol(char c) {
        return c != '.' && !isDigit(c);
    }

    private static boolean isDigit(char c) {
        for (char o : digit.toCharArray()) {
            if (o == c)
                return true;
        }

        return false;
    }
}
