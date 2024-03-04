package org.home.other4;

import java.util.stream.IntStream;

// https://leetcode.com/problems/max-chunks-to-make-sorted/
public class MaxChunksSorted {

    public int maxChunksToSorted(int[] arr) {
        final var n = arr.length;
        final var p = new int[n];

        var partition = 0;
        var mark = 0;

        do {
            final var start = IntStream.range(0, n)
                    .filter(i -> p[i] == 0)
                    .findFirst()
                    .orElse(-1);

            mark = start == -1 ? 0 :
                    close(arr, n, start, p, ++partition);
        } while (mark != 0);

        return partition;
    }

    private int close(int[] arr, int n, int current, int[] p, int partition) {
        int count = 0;

        int min = n;
        int max = 0;

        while (p[current] == 0) {
            count++;
            p[current] = partition;
            current = arr[current];

            min = Math.min(min, current);
            max = Math.max(max, current);
        }

        for (int i = min; i < max; i++) {
            if (p[i] == 0) {
                count += close(arr, n, i, p, partition);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        final var solver = new MaxChunksSorted();

        System.out.println("2 = " + solver.maxChunksToSorted(new int[]{0, 4, 5, 2, 1, 3}));
        System.out.println("4 = " + solver.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        System.out.println("1 = " + solver.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
    }
}
