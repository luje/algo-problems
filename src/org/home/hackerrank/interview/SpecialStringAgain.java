package org.home.hackerrank.interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpecialStringAgain {

    public static long substrCount(int n, String s) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            result += count(s, i, i);

            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                result += count(s, i, i + 1);
            }
        }

        return result;
    }

    public static int count(String s, int x, int y) {
        var result = 1;
        Character c = x == y ? null : s.charAt(x);

        for (int i = 1; x - i >= 0 && y + i < s.length(); i++) {
            if(c == null) {
                c = s.charAt(x - i);
            }

            if (s.charAt(x - i) != c) {
                return result;
            }

            if (s.charAt(y + i) != c) {
                return result;
            }

            result++;
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("7=" + substrCount(5, "asasd"));
        System.out.println("10=" + substrCount(7, "abcbaba"));
        System.out.println("10=" + substrCount(4, "aaaa"));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        long result = substrCount(n, s);

        System.out.println("66516 = " + result);
    }
}
