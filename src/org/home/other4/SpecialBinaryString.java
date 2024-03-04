package org.home.other4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/special-binary-string/
public class SpecialBinaryString {

    public String makeLargestSpecial(String s) {
        var current = new Node();

        for (char c : s.toCharArray()) {
            if (c == '1') {
                current = current.addNode();
            } else {
                current = current.parent;
            }
        }

        return append(current.nodes, new StringBuilder()).toString();
    }

    static class Node {

        Node parent;
        List<Node> nodes = new ArrayList<>();

        public Node addNode() {
            final var result = new Node();

            result.parent = this;
            nodes.add(result);

            return result;
        }

        public String toString() {
            var sb = new StringBuilder();

            sb.append("1");
            append(nodes, sb);
            sb.append("0");

            return sb.toString();
        }
    }

    private static StringBuilder append(List<Node> nodes, StringBuilder sb) {
        List<String> parts = new ArrayList<>();

        for (Node node : nodes) {
            parts.add(node.toString());
        }

        parts.sort(Collections.reverseOrder());

        for (String part:parts) {
            sb.append(part);
        }

        return sb;
    }

    public static void main(String[] args) {
        final var solver = new SpecialBinaryString();

        System.out.println("11100100 = \n" + solver.makeLargestSpecial("11011000"));
        System.out.println("1110010101010011100011010010 = \n" + solver.makeLargestSpecial("1101001110001101010110010010"));
        System.out.println("1110010101010011100011010010 = \n" + solver.makeLargestSpecial("1110010101010011100011010010"));
    }
}
