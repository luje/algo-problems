package advent2023;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        long sum = 0;

        while (scanner.hasNext()) {
            final var line = scanner.nextLine();

            sum += reduce(line);
        }

        System.out.println(sum);
    }

    private static long reduce(String line) {
        final var game = line.split(":");
        final var gameId = Integer.parseInt(game[0].replaceAll("Game ", ""));

        var mr = 0L;
        var mg = 0L;
        var mb = 0L;

        for(String g : game[1].split(";")) {
            for(String b: g.split(",")) {
                if(b.contains("red")) {
                    var cr = Long.parseLong(b.replaceAll("red", "").trim());

                    mr = Math.max(mr, cr);
                }
                if(b.contains("green")) {
                    var cg = Long.parseLong(b.replaceAll("green", "").trim());
                    mg = Math.max(mg, cg);
                }
                if(b.contains("blue")) {
                    var cb = Long.parseLong(b.replaceAll("blue", "").trim());
                    mb = Math.max(mb, cb);
                }
            }
        }

        return mr * mg * mb;
    }
}
