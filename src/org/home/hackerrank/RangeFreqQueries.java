package org.home.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RangeFreqQueries {

    static class FreqSet {
        final Map<Integer, Integer> freq = new HashMap<>();
        final Map<Integer, Integer> rfreq = new HashMap<>();

        public void add(Integer element) {
            final Integer orig = freq.getOrDefault(element, 0);

            freq.put(element, orig + 1);

            rfreq.put(orig, rfreq.getOrDefault(orig, 0) - 1);
            rfreq.put(orig + 1, rfreq.getOrDefault(orig + 1, 0) + 1);

            if(rfreq.get(orig) <= 0) rfreq.remove(orig);
        }

        public void remove(Integer element) {
            if(freq.containsKey(element)) {
                final Integer orig = freq.get(element);

                freq.put(element, orig - 1);

                if(orig == 0) {
                    freq.remove(element);
                }

                rfreq.put(orig, rfreq.getOrDefault(orig, 0) - 1);
                rfreq.put(orig - 1, rfreq.getOrDefault(orig - 1, 0) + 1);

                if(rfreq.get(orig) <= 0) rfreq.remove(orig);
            }
        }

        public Integer check(Integer frequency) {
            return rfreq.getOrDefault(frequency, 0) > 0 ? 1 : 0;
        }
    }
    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        final List<Integer> result = new ArrayList<>();
        final FreqSet freqSet = new FreqSet();

        for (List<Integer> q : queries) {
            final Integer op = q.get(0);
            final Integer val = q.get(1);

            switch (op) {
                case 1:
                    freqSet.add(val);
                    break;
                case 2:
                    freqSet.remove(val);
                    break;
                case 3:
                    result.add(freqSet.check(val));
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        System.out.println(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
    }
}
