package org.home.other4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        final var clones = new HashMap<Node, Node>();
        final var stack = new ArrayDeque<Node>(100);

        stack.add(node);

        while (!stack.isEmpty()) {
            var current = stack.pop();

            clones.computeIfAbsent(current, c -> new Node(c.val, new ArrayList<>(c.neighbors.size())));

            current.neighbors
                    .stream()
                    .filter(neighbor -> !clones.containsKey(neighbor))
                    .forEach(stack::add);
        }

        clones.forEach((original, clone) -> original.neighbors
                .stream()
                .map(clones::get)
                .forEach(clone.neighbors::add));

        return clones.get(node);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
        final var sover = new CloneGraph();

        final var nodes = new HashMap<Integer, Node>();

        nodes.put(1, new Node(1));
        nodes.put(2, new Node(2));
        nodes.put(3, new Node(3));
        nodes.put(4, new Node(4));

        nodes.get(1).neighbors.add(nodes.get(2));
        nodes.get(1).neighbors.add(nodes.get(4));
        nodes.get(2).neighbors.add(nodes.get(1));
        nodes.get(2).neighbors.add(nodes.get(3));
        nodes.get(3).neighbors.add(nodes.get(2));
        nodes.get(3).neighbors.add(nodes.get(4));
        nodes.get(4).neighbors.add(nodes.get(1));
        nodes.get(4).neighbors.add(nodes.get(3));

        System.out.println(sover.cloneGraph(nodes.get(1)));
    }
}
