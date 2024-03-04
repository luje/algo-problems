package org.home.other;

import java.math.BigDecimal;
import java.util.*;

public class Solution {

    public static int[] solution(int area) {
        final List<Integer> result = new ArrayList<>();
        int s = area;

        while (s > 0) {
            int p = (int) Math.floor(Math.sqrt(s));
            int a = p * p;

            result.add(a);
            s -= a;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static int solution3(int[] l) {
        Arrays.sort(l);

        int s = 0;

        for (int i = 0; i < l.length; i++) {
            s += l[i];
            s %= 3;
        }

        if (s == 0) return asNum(l);

        for (int i = 0; i < l.length; i++) {
            if (l[i] % 3 == s) {
                l[i] = -1;

                return asNum(l);
            }
        }

        for (int i = 0; i < l.length - 1; i++) {
            for (int j = i + 1; j < l.length; j++)
                if ((l[i] + l[j]) % 3 == s) {
                    l[i] = -1;
                    l[j] = -1;

                    return asNum(l);
                }
        }

        return 0;
    }

    private static int asNum(int[] l) {

        int d = 1;
        int r = 0;

        for (int i = 0; i < l.length; i++) {
            if (l[i] < 0) continue;

            r += l[i] * d;
            d *= 10;
        }

        return r;
    }

    public static int solution2(String s) {
        String V = s.replace("-", "");
        int[] l = new int[V.length()];
        int[] r = new int[V.length()];

        int c = 0;
        for (int i = 0; i < V.length(); i++) {
            if (V.charAt(i) == '>')
                c++;

            l[i] = c;
        }

        c = 0;
        for (int i = V.length() - 1; i >= 0; i--) {
            if (V.charAt(i) == '<')
                c++;

            r[i] = c;
        }

        c = 0;

        for (int i = 0; i < V.length(); i++) {
            if (V.charAt(i) == '>') c += r[i];
            if (V.charAt(i) == '<') c += l[i];
        }

        return c;
    }

    private static final Map<BigDecimal, Integer> cache = new HashMap<>();

    public static int solution(String x) {
        return solution(new BigDecimal(x));
    }

    public static int solution(BigDecimal x) {
        if (cache.containsKey(x))
            return cache.get(x);

        if (x.compareTo(BigDecimal.ONE) == 0)
            return 0;

        if (!x.toBigInteger().testBit(0)) {
            cache.put(x, 1 + solution(x.divide(new BigDecimal("2"))));
        } else {
            final int a = solution(x.add(BigDecimal.ONE));
            final int b = solution(x.subtract(BigDecimal.ONE));

            cache.put(x, 1 + Math.min(a, b));
        }

        return cache.get(x);
    }

    public static int solution(int[] l) {
        Arrays.sort(l);

        int[] r = new int[l.length];

        for (int i = 0; i < l.length - 1; i++) {
            for (int j = i + 1; j < l.length; j++) {
                if (l[j] % l[i] == 0) r[i]++;
            }
        }

        int c = 0;

        for (int i = 0; i < l.length - 1; i++) {
            for (int j = i + 1; j < l.length; j++) {
                if (l[j] % l[i] == 0) c += r[j];
            }
        }

        return c;
    }

    static Map<String, Integer> pathCache = new HashMap<>();
    static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int solution(int[][] map) {
        pathCache = new HashMap<>();

        // Your code here
        int n = map.length;
        int m = map[0].length;

        boolean[][] visited = new boolean[n][m];

        visited[0][0] = true;

        return move(0, 0, map, visited, true);
    }

    private static int move(int i, int j, int[][] map, boolean[][] v, boolean canSkip) {
        final int n = map.length;
        final int m = map[0].length;

        if (i == n - 1 && j == m - 1)
            return 1;

        final String key = i + "#" + j + "#" + canSkip;
        if(pathCache.containsKey(key)) {
            return pathCache.get(key);
        }

        int c = 20 * 20 + 1;

        for (int[] e : directions) {
            final int x = i + e[0];
            final int y = j + e[1];

            if (x < 0) continue;
            if (x >= n) continue;
            if (y < 0) continue;
            if (y >= m) continue;

            if (v[x][y]) continue;

            if (map[x][y] == 1 && !canSkip) continue;

            v[x][y] = true;

            if (map[x][y] == 1 && canSkip) {
                c = Math.min(c, move(x, y, map, v, false) + 1);
            } else {
                c = Math.min(c, move(x, y, map, v, canSkip) + 1);
            }

            v[x][y] = false;
        }

        pathCache.put(key, c);

        return c;
    }

    public static void main(String[] args) {
        System.out.println("3=" + solution(new int[][]{
                new int[]{0, 1},
                new int[]{1, 0}
        }));

        System.out.println("7=" + solution(new int[][]{
                new int[]{0, 1, 1, 0},
                new int[]{0, 0, 0, 1},
                new int[]{1, 1, 0, 0},
                new int[]{1, 1, 1, 0}
        }));

        System.out.println("11=" + solution(new int[][]{
                new int[]{0, 0, 0, 0, 0, 0},
                new int[]{1, 1, 1, 1, 1, 0},
                new int[]{0, 0, 0, 0, 0, 0},
                new int[]{0, 1, 1, 1, 1, 1},
                new int[]{0, 1, 1, 1, 1, 1},
                new int[]{0, 0, 0, 0, 0, 0}
        }));

        System.out.println("11=" + solution(new int[][]{
                new int[]{0, 0, 0, 0, 0, 0},
                new int[]{1, 1, 1, 1, 1, 0},
                new int[]{0, 0, 0, 1, 0, 0},
                new int[]{0, 1, 0, 1, 0, 1},
                new int[]{0, 1, 0, 0, 0, 1},
                new int[]{0, 1, 1, 1, 1, 1},
                new int[]{0, 1, 1, 1, 1, 1},
                new int[]{0, 0, 0, 0, 0, 0}
        }));
    }
}
