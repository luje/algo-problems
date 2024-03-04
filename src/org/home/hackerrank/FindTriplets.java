package org.home.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FindTriplets {

    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> le = new HashMap<>();
        Map<Long, Long> ri = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            ri.put(arr.get(i), ri.getOrDefault(arr.get(i), 0l) + 1);
        }

        long count = 0;

        for (Long k : arr) {
            ri.put(k, ri.get(k) - 1);

            if( k % r == 0) {
                count += le.getOrDefault(k / r, 0l) * ri.getOrDefault(k * r, 0l);
            }

            le.put(k, le.getOrDefault(k, 0l) + 1);
        }

        return count;
    }

    static long countTriplets2(List<Long> arr, long r) {
        Map<Long, List<Integer>> idx = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            final Long key = arr.get(i);

            idx.computeIfAbsent(key, k -> new ArrayList<>());

            idx.get(key).add(i);
        }

        List<Long> a = idx.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        long count = 0;

        for (int i = 0; i < a.size(); i++) {
            List<Integer> x = idx.get(a.get(i));
            List<Integer> y = idx.get(a.get(i) * r);
            List<Integer> z = idx.get(a.get(i) * r * r);

            if (y == null || z == null)
                continue;

            if (r == 1) {
                count += x.size() * (x.size() - 1l) * (x.size() - 2l) / 6l;

                continue;
            }

            Map<Integer, Long> cache = new HashMap<>();

            for (int pi = 0; pi < x.size(); pi++) {
                int q = abs(Collections.binarySearch(y, x.get(pi)));

                if (cache.containsKey(q)) {
                    count += cache.get(q);

                    continue;
                }

                for (int qi = y.size() - 1; qi >= q; qi--) {
                    int s = abs(Collections.binarySearch(z, y.get(qi)));

                    cache.put(qi, cache.getOrDefault(qi + 1, 0l) + (z.size() - s));
                }

                count += cache.getOrDefault(q, 0l);
            }
        }

        return count;
    }

    public static int abs(int i) {
        return i < 0 ? -(i) - 1 : i;
    }

//    public static void main(String[] args) {
//
//        System.out.println(166661666700000l);
//        System.out.println(100000l * (100000l - 1) * (100000l - 2) / 6);
//
//        System.out.println("1=" + countTriplets(Arrays.asList(1l, 1l, 1l, 1l), 1));
//        System.out.println("2=" + countTriplets(Arrays.asList(1l, 2l, 2l, 4l), 2));
//        System.out.println("6=" + countTriplets(Arrays.asList(1l, 3l, 9l, 9l, 27l, 81l), 3));
//        System.out.println("4=" + countTriplets(Arrays.asList(1l, 5l, 5l, 25l, 125l), 5));
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(ans);
        System.out.println(161700 - ans);

        bufferedReader.close();
    }
}
