package advent2023;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        var sum = 0L;
        var cards = new int[188];

        Arrays.fill(cards, 1);

        while (scanner.hasNext()) {
            final var line = scanner.nextLine();

            sum += reduce2(line, cards);
        }

        System.out.println(sum);

        System.out.println(Arrays.stream(cards).sum());
    }

    private static long reduce2(String line, int[] cache) {
        final var game = line.split(":");
        final var gameNo = Integer.parseInt(game[0].replaceAll("Card ", "").trim()) - 1;
        final var cards = game[1].split("\\|");

        var winning = new HashSet<>();
        for (String c : cards[0].split(" ")) {
            if(!c.isEmpty()) {
                winning.add(c.trim());
            }
        }

        var result = gameNo + 1;

        for (String num : cards[1].split(" ")) {
            if (winning.contains(num)) {
                cache[result++] += cache[gameNo];
            }
        }

        System.out.println(game[0] + " : " + result);

        return result;
    }

    private static long reduce(String line) {
        final var game = line.split(":");
        final var cards = game[1].split("\\|");

        var winning = new HashSet<>();
        for (String c : cards[0].split(" ")) {
            if(!c.isEmpty()) {
                winning.add(c.trim());
            }
        }

        var result = 0L;

        for (String num : cards[1].split(" ")) {
            if (winning.contains(num)) {
                if (result == 0) result = 1L;
                else result = result * 2;
            }
        }

        System.out.println(game[0] + " : " + result);

        return result;
    }
}
