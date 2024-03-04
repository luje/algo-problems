package org.home.leetcode.contest378;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/contest/weekly-contest-378/problems/find-longest-special-substring-that-occurs-thrice-i/
// https://leetcode.com/contest/weekly-contest-378/problems/find-longest-special-substring-that-occurs-thrice-ii/
public class LongestSpecialSubstring {

    public int maximumLength(String s) {
        final Map<Character, Map<Integer, Integer>> cache = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            final var c = s.charAt(i);

            cache.putIfAbsent(c, new HashMap<>());

            var count = 1;

            while (i + 1 < s.length() && s.charAt(i + 1) == c) {
                count++;
                i++;
            }

            cache.get(c)
                    .put(count, cache.get(c).getOrDefault(count, 0) + 1);
        }

        return cache.values().stream()
                .mapToInt(this::max)
                .max()
                .orElse(-1);
    }

    private int max(Map<Integer, Integer> value) {
        int max = -1;
        int maxLength = -1;

        for (var e : value.entrySet()) {
            maxLength = Math.max(e.getKey(), maxLength);
        }

        int size = maxLength;

        while (size > 0) {
            if (size < max)
                break;

            int count = value.getOrDefault(size, 0);

            if (count >= 3) {
                max = size;
            } else {
                value.put(size - 1, value.getOrDefault(size -1, 0) + 2 * count);
                value.put(size - 2, value.getOrDefault(size - 2, 0) + 3 * count);
            }

            size --;
        }

        return max;
    }

    public static void main(String[] args) {
        var solver = new LongestSpecialSubstring();

        System.out.println("2 = " + solver.maximumLength("ereerrrererrrererre"));
        System.out.println("1 = " + solver.maximumLength("aada"));
        System.out.println("-1 = " + solver.maximumLength("bbc"));
        System.out.println("2 = " + solver.maximumLength("abqvpcsjtiqhbwamypfxwdzqaoirhuyiqiaveraobmbtgncawlwvxplukrxkkhksnrchuimbwgjdqmtmlczzzzzzeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbepjuqvhtnogzltwuhpeoadfvskcxklxebbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssstgmdrizpczdvxehjqjjhbrlymw"));
        System.out.println("2 = " + solver.maximumLength("aaaa"));
        System.out.println("2 = " + solver.maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde"));
        System.out.println("-1 = " + solver.maximumLength("abcdef"));
        System.out.println("1 = " + solver.maximumLength("abcaba"));
    }
}
