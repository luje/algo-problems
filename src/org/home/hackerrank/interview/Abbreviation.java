package org.home.hackerrank.interview;

import java.util.Arrays;

public class Abbreviation {
    public static String abbreviation(String a, String b) {
        byte[][] cache = new byte[a.length()][b.length()];

        for (int i = 0; i < a.length(); i++) {
            Arrays.fill(cache[i], (byte) -1);
        }

        return abbreviation(a, b, 0, 0, cache) ? "YES" : "NO";
    }

    public static boolean abbreviation(String a, String b, int i, int j, byte[][] cache) {
        if (i == a.length())
            return j == b.length();

        if (j == b.length()) {
            for (int k = i; k < a.length(); k++) {
                if (Character.isUpperCase(a.charAt(k))) {
                    return false;
                }
            }

            return true;
        }

        if (cache[i][j] >= 0) {
            return cache[i][j] != 0;
        }

        char aa = a.charAt(i);
        char bb = b.charAt(j);

        if (Character.isLowerCase(aa)) {
            cache[i][j] = (byte) ((abbreviation(a, b, i + 1, j, cache) ||
                    (Character.toUpperCase(aa) == bb && abbreviation(a, b, i + 1, j + 1, cache))) ? 1 : 0);
        } else {
            cache[i][j] = (byte) ((Character.toUpperCase(aa) == bb && abbreviation(a, b, i + 1, j + 1, cache)) ? 1 : 0);
        }

        return cache[i][j] != 0;
    }

    public static void main(String[] args) {
        System.out.println("YES=" + abbreviation("daBcd", "ABC"));
        System.out.println("1=" + abbreviation("daBcd", "ABC"));
    }
}
