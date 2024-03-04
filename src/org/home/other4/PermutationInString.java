package org.home.other4;

// https://leetcode.com/problems/permutation-in-string/
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        final var f1 = new int['z' - 'a' + 1];

        for (int i = 0; i < s1.length(); i++) {
            f1[s1.charAt(i) - 'a']++;
        }

        final var f2 = new int['z' - 'a' + 1];

        for (int i = 0; i < s2.length(); i++) {
            f2[s2.charAt(i) - 'a']++;

            if (i >= s1.length() - 1) {
                var result = true;

                for (int j = 0; j < f1.length; j++) {
                    if (f1[j] != f2[j]) {
                        result = false;
                        break;
                    }
                }

                if (result)
                    return true;

                f2[s2.charAt(i - s1.length() + 1) - 'a']--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        final var solver = new PermutationInString();

        System.out.println("true = " + solver.checkInclusion("ab", "eidbaooo"));
        System.out.println("true = " + solver.checkInclusion("adc", "dcda"));
        System.out.println("false = " + solver.checkInclusion("rokx", "otrxvfszxroxrzdsltg"));
        System.out.println("false = " + solver.checkInclusion("ab", "a"));
        System.out.println("false = " + solver.checkInclusion("ab", "eidboaoo"));
    }
}
