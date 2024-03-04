package org.home.ace.day5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : tasks) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        return count(freq, n);
    }

    private int count(Map<Character, Integer> freq, int n) {
        if (freq.isEmpty())
            return 0;

        int sum = 0;

        final List<Character> ordered = freq.keySet()
                .stream()
                .sorted(Comparator.comparing(freq::get).reversed())
                .collect(Collectors.toList());

        int j = 0;
        for (int i = 0; i <= n; i++) {
            if (freq.isEmpty()) {
                return sum;
            }

            if (j < ordered.size()) {
                final char c = ordered.get(j++);

                freq.put(c, freq.get(c) - 1);

                if (freq.get(c) == 0)
                    freq.remove(c);
            }

            sum += 1;
        }

        return sum + count(freq, n);
    }

    public static void main(String[] args) {
        TaskScheduler solver = new TaskScheduler();

//        System.out.println(solver.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(solver.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    }
}
