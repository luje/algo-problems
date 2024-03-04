package org.home.interview2;

public class Solution {
    public int solution(String S) {
        // Implement your solution here

        int houses = 0;
        int solvedHouses = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'H') {
                houses++;

                solvedHouses +=
                        (i - 1 >= 0 && S.charAt(i - 1) == 'T') ||
                                (i + 1 < S.length() && S.charAt(i + 1) == 'T') ? 1 : 0;
            }
        }

        if (houses == solvedHouses)
            return 0;

        if (S.isEmpty())
            return 0;
        if (S.equals("H"))
            return -1;
        if (S.equals("H-") || S.equals("-H"))
            return 1;
        if (S.equals("H-H"))
            return 1;

        int min = -1;
        String ml = "";
        String mr = "";

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '-') {

                if (!((i - 1 >= 0 && S.charAt(i - 1) == 'H') || (i + 1 <S.length() && S.charAt(i + 1) == 'H'))) {
                    continue;
                }

                String l = S.substring(0, i) + "T";
                String r = "T" + S.substring(i + 1);

                int sl = solution(l);
                int sr = solution(r);

                if (sl >= 0 && sr >= 0 && (min == -1 || sl + sr + 1 < min)) {
                    min = sl + sr + 1;
                }
            }
        }

        return min;
    }

    public static void main(String[] args) {
        var solver = new Solution();

        System.out.println(solver.solution("---------------H---"));
//                                              "---------------HT--"
        System.out.println("------------------------");
        System.out.println(solver.solution("-H-H-H-H-H-H-H-H-H-"));
        System.out.println("------------------------");
        System.out.println(solver.solution("-H-HH-"));
        System.out.println("------------------------");
        System.out.println(solver.solution("H"));
        System.out.println("------------------------");
        System.out.println(solver.solution("HH-HH"));
        System.out.println("------------------------");
        System.out.println(solver.solution("-H-H-H-H-H"));
        System.out.println("------------------------");

    }
}
