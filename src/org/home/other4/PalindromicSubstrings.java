package org.home.other4;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        var count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, 0, 0);

            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count += expand(s, i, 0, 1);
            }
        }

        return count;
    }

    private static int expand(String s, int i, int startLeft, int startRight) {
        var count = 0;
        var l = startLeft;
        var r = startRight;

        while (i - l >= 0 && i + r < s.length()) {
            if (s.charAt(i - l) != s.charAt(i + r)) {
                break;
            }

            count++;

            l++;
            r++;
        }

        return count;
    }

    public static void main(String[] args) {
        final var solver = new PalindromicSubstrings();

        System.out.println("3 = " + solver.countSubstrings("abc"));
        System.out.println("----------------------");
        System.out.println("6 = " + solver.countSubstrings("aaa"));
        System.out.println("----------------------");
    }
}
