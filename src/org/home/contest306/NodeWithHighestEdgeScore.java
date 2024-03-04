package org.home.contest306;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class NodeWithHighestEdgeScore {

    public int edgeScore(int[] edges) {
        final Map<Integer, Long> scores = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            final int key = edges[i];

            scores.put(key, scores.getOrDefault(key, 0l) + i);
        }

        return scores.keySet().stream()
                .sorted()
                .max(Comparator.comparing(scores::get))
                .get();
    }

    public static void main(String[] args) {
        NodeWithHighestEdgeScore solver = new NodeWithHighestEdgeScore();

        System.out.println(solver.edgeScore(new int[]{1, 0, 0, 0, 0, 7, 7, 5}));
        System.out.println(solver.edgeScore(new int[]{1, 0, 1, 1, 1, 1, 1, 1}));
        System.out.println(solver.edgeScore(new int[]{1, 3, 1, 2}));
    }
}
