package org.home.hackerrank.interview;

import java.util.Map;
import java.util.TreeMap;

public class MinimumTimeRequired {
    static long minTime2(long[] machines, long goal) {

        Map<Long, Long> tmp = new TreeMap<>();
        for (long machine : machines) {
            tmp.putIfAbsent(machine, 0L);
            tmp.put(machine, tmp.get(machine) + 1);
        }

        long target = 0;
        long day = 0;

        do {
            day++;

            for (Long key : tmp.keySet()) {
                if (key > day)
                    break;

                if (day % key == 0) {
                    target += tmp.get(key);
                }
            }
        } while (target < goal);

        return day;
    }

    static long minTime(long[] machines, long goal) {
        TreeMap<Long, Long> tmp = new TreeMap<>();

        for (long machine : machines) {
            tmp.putIfAbsent(machine, 0L);
            tmp.put(machine, tmp.get(machine) + 1);
        }

        return search(tmp, goal, 1, (goal * tmp.descendingKeySet().first()) + 1);
    }

    static long search(Map<Long, Long> machines, long goal, long startDay, long endDay) {
        if (startDay == endDay)
            return startDay;

        long mid = (startDay + endDay) / 2;
        long production = 0;

        for (long key : machines.keySet()) {
            production += (mid / key) * machines.get(key);
        }

        return production >= goal ?
                search(machines, goal, startDay, mid) :
                search(machines, goal, mid + 1, endDay);
    }

    public static void main(String[] args) {
        System.out.println("8 = " + minTime(new long[]{2, 3, 2}, 10));
        System.out.println("82 = " + minTime(new long[]{2, 16, 21, 26, 55, 59, 63, 65, 98, 99}, 56));
        System.out.println("20 = " + minTime(new long[]{4, 5, 6}, 12));
        System.out.println("6 = " + minTime(new long[]{2, 3}, 5));
        System.out.println("7 = " + minTime(new long[]{1, 3, 4}, 10));
    }
}
