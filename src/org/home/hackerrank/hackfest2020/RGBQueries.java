package org.home.hackerrank.hackfest2020;

import java.util.*;
import java.util.stream.Collectors;

// https://www.hackerrank.com/contests/hackerrank-hackfest-2020/challenges/rbg
public class RGBQueries {

    public static List<String> mixColors(List<List<Integer>> colors, List<List<Integer>> queries) {
        // Write your code here
        final List<String> result = new ArrayList<>();

        final List<Color> dColors = colors.stream().map(Color::new)
                .distinct()
                .collect(Collectors.toList());

        final Map<Integer, List<Color>> rIndex = dColors.stream().collect(Collectors.groupingBy(it -> it.r));
        final Map<Integer, List<Color>> gIndex = dColors.stream().collect(Collectors.groupingBy(it -> it.g));
        final Map<Integer, List<Color>> bIndex = dColors.stream().collect(Collectors.groupingBy(it -> it.b));

        for (List<Integer> query : queries) {
            result.add(mix(rIndex, gIndex, bIndex, new Color(query)));
        }

        return result;
    }

    private static String mix(Map<Integer, List<Color>> rIndex,
                              Map<Integer, List<Color>> gIndex,
                              Map<Integer, List<Color>> bIndex,
                              Color query) {

        if (rIndex.getOrDefault(query.r, Collections.emptyList())
                .stream()
                .noneMatch(it -> it.g <= query.g && it.b <= query.b))
            return "NO";

        if (gIndex.getOrDefault(query.g, Collections.emptyList())
                .stream()
                .noneMatch(it -> it.r <= query.r && it.b <= query.b))
            return "NO";

        if (bIndex.getOrDefault(query.b, Collections.emptyList())
                .stream()
                .noneMatch(it -> it.r <= query.r && it.g <= query.g))
            return "NO";

        return "YES";
    }

    public static class Color {
        final int r;
        final int g;
        final int b;

        public Color(List<Integer> it) {
            this(it.get(0), it.get(1), it.get(2));
        }

        public Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Color color = (Color) o;

            if (r != color.r) return false;
            if (g != color.g) return false;
            return b == color.b;
        }

        @Override
        public int hashCode() {
            int result = r;
            result = 31 * result + g;
            result = 31 * result + b;
            return result;
        }
    }

    public static void main(String[] args) {
//        System.out.println(mixColors(
//                Arrays.asList(
//                        Arrays.asList(1, 3, 5),
//                        Arrays.asList(5, 3, 1)
//                ),
//                Arrays.asList(
//                        Arrays.asList(5, 3, 5),
//                        Arrays.asList(3, 3, 3)
//                )
//        ));

//        System.out.println(mixColors(
//                Arrays.asList(
//                        Arrays.asList(3, 2, 1),
//                        Arrays.asList(1, 2, 3),
//                        Arrays.asList(1, 3, 2),
//                        Arrays.asList(2, 3, 1)
//                ),
//                Arrays.asList(
//                        Arrays.asList(3, 3, 3),
//                        Arrays.asList(1, 1, 1),
//                        Arrays.asList(2, 2, 2),
//                        Arrays.asList(3, 2, 1),
//                        Arrays.asList(3, 2, 3),
//                        Arrays.asList(2, 1, 2)
//                )
//        ));

        System.out.println(mixColors(
                Arrays.asList(
                        Arrays.asList(0, 0, 0),
                        Arrays.asList(255, 255, 255)
                ),
                Arrays.asList(
                        Arrays.asList(0, 0, 0),
                        Arrays.asList(255, 255, 255),
                        Arrays.asList(255, 255, 0),
                        Arrays.asList(0, 0, 255),
                        Arrays.asList(255, 0, 255),
                        Arrays.asList(255, 0, 0),
                        Arrays.asList(0, 255, 0),
                        Arrays.asList(0, 0, 255)
                )
        ));
    }

}
