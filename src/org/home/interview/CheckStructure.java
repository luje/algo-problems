package org.home.interview;

import java.util.List;

public class CheckStructure {

    public static String isValid2(List<Integer> a) {
        final var constructed = construct(a, 1, a.size(), 0);

        System.out.println(constructed);

        return isBst(constructed) ? "YES" : "NO";
    }

    public static String isValid(List<Integer> a) {
        final var root = a.get(0);

        return isValid(a, 1, a.size(), root) ? "YES" : "NO";
    }

    private static boolean isValid(List<Integer> a, int start, int end, Integer data) {
        if(start >= end)
            return true;

        var mid = start;
        for (int i = start; i < end; i++) {
            if(a.get(i) > data) {
                break;
            }

            mid++;
        }

        if(mid == end)
            return isValid(a, start + 1, mid, a.get(start));

        for (int i = mid; i < end; i++) {
            if(a.get(i) < data)
                return false;
        }

        return isValid(a, start + 1, mid, a.get(start)) &&
                isValid(a, mid + 1, a.size(), a.get(mid));
    }

    static Node construct(List<Integer> a, int start, int end, int index) {
        if (index >= a.size()) {
            return null;
        }

        final Node root = new Node(a.get(index));

        if (start == end)
            return root;
        if (start > end)
            return null;

        int mid = start;
        for (int i = start; i < end; i++) {
            if (root.data < a.get(i)) {
                break;
            }

            mid++;
        }

        root.left = construct(a, start + 1, mid, start);
        root.right = construct(a, mid + 1, end, mid);

        return root;
    }

    static boolean isBst(Node root) {
        return root == null ||
                (isGt(root.data, root.left) && isLt(root.data, root.right) && isBst(root.left) && isBst(root.right));
    }

    static boolean isGt(int data, Node root) {
        return root == null ||
                (root.data < data && isGt(data, root.left) && isGt(data, root.right));
    }

    static boolean isLt(int data, Node root) {
        return root == null ||
                (root.data > data && isLt(data, root.left) && isLt(data, root.right));
    }

    static class Node {
        final int data;

        Node left;
        Node right;


        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println("YES = " + isValid(List.of(3, 2, 1, 5, 4, 6)));
        System.out.println("YES = " + isValid(List.of(1, 3, 2)));
        System.out.println("YES = " + isValid(List.of(2, 1, 3)));
        System.out.println("NO = " + isValid(List.of(1, 3, 4, 2)));
        System.out.println("NO = " + isValid(List.of(3, 4, 5, 1, 2)));

//        YES
//                YES
//        YES
//                NO
//        NO

//        5
//        3
//        1 3 2
//        3
//        2 1 3
//        6
//        3 2 1 5 4 6
//        4
//        1 3 4 2
//        5
//        3 4 5 1 2
    }
}
