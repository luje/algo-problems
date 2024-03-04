package advent2023;

import java.util.Map;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        var sum = 0;

        while (scanner.hasNext()) {
            final var line = scanner.nextLine();

            sum += reduce(line);
        }

        System.out.println(sum);
    }

    static Map<String, Integer> digits = Map.of(
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9
    );

    private static int reduce(final String line) {
        System.out.println("-------------");
        System.out.println(line);

        var n = 0;
        var i = 0;

        for (i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if ('0' <= c && c <= '9') {
                n = (c - '0');

                System.out.println("found int: " + c);

                break;
            }

            var found = false;
            for (var digit : digits.keySet()) {
                if(line.indexOf(digit, i) == i) {
                    n = digits.get(digit);

                    System.out.println("found char: " + digit);

                    found = true;

                    break;
                }
            }

            if(found) break;
        }

        for (int j = line.length() - 1; j >= i; j--) {
            char c = line.charAt(j);

            if ('0' <= c && c <= '9') {
                n = n * 10 + (c - '0');

                System.out.println("found int: " + c);

                break;
            }

            var found = false;
            for (var digit : digits.keySet()) {
                if(line.indexOf(digit, j) == j) {
                    n = n * 10 + digits.get(digit);

                    System.out.println("found char: " + digit);

                    found = true;

                    break;
                }
            }

            if(found) break;
        }

        System.out.println(n);

        return n;
    }
}
