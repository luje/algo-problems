package org.home.ace.day2;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int c = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            c = longestCommonPrefix(strs[0], strs[i], c);

            if(c == 0)
                return "";
        }

        return strs[0].substring(0, c);
    }

    private int longestCommonPrefix(String result, String other, int c) {
        int lim = 0;

        for (lim = 0; lim < Math.min(c, other.length()); lim++) {
            if(result.charAt(lim) != other.charAt(lim)) {
                break;
            }
        }

        return lim;
    }

    public static void main(String[] args) {
        LongestCommonPrefix solver = new LongestCommonPrefix();

        System.out.println(solver.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
