package org.home.other4;

// https://leetcode.com/problems/count-number-of-homogenous-substrings/description/?envType=daily-question&envId=2023-11-09
public class CountNumberOfHomogenousSubstrings {

    public int countHomogenous(String s) {
        long count = 0;
        long ss = 0;

        for (int i = 1; i < s.length(); i++, ss++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                count += ss * (ss + 1) / 2;
                ss = 0;
            }
        }

        ss++;
        count += ss * (ss + 1) / 2;

        return (int) (count % 1_000_000_007);
    }

    public static void main(String[] args) {
        final var solver = new CountNumberOfHomogenousSubstrings();

        System.out.println("13 = " + solver.countHomogenous("abbcccaa"));
        System.out.println("2 = " + solver.countHomogenous("xy"));
        System.out.println("15 = " + solver.countHomogenous("zzzzz"));
    }

}
