package org.home.interview3;

import java.util.LinkedList;

public class Solution {

    /*
     *
     *
     *
     * */

    public static void main(String[] args) {
        final var s = new Queue<Integer>();

        /*
         *  s <
         *  d >
         *
         * */
    }

    private static class Queue<T> {

        private java.util.Stack<T> l = new java.util.Stack<T>();
        private java.util.Stack<T> r = new java.util.Stack<T>();

        public void enqueue(T e) {
            l.push(e);
        }

        public T dequeue() {
            if (!r.isEmpty())
                return r.pop();

            while (!l.isEmpty()) {
                r.push(l.pop());
            }

            return r.pop();
        }

        public boolean isEmpty() {
            return l.isEmpty() && r.isEmpty();
        }

    }

    private static class OtherStack<T> {

        private java.util.Queue<T> l = new LinkedList<>();
        private java.util.Queue<T> r = new LinkedList<>();


        /*
         *  r: <>
         *  l: <>
         * - add 1
         *  r: <>
         *  l: 1
         * - add 2
         *  r: <>
         *  l: 1 2
         * - add 3
         *  r: 3
         *  l: 1 2
         *  ...
         *  r: 1 2 3
         *  l: <>
         *
         *
         * */

        public void push(T e) {
            r.add(e);

            while (!l.isEmpty()) {
                r.add(l.poll());
            }

            var aux = l;
            l = r;
            r = aux;

            /*
             *   r: 1 2 3
             *   l: <>
             *
             *   r: <>
             *   l: 0 1 2 3
             *
             *   switch
             *   r: 0 1 2 3
             *   l: <>
             *
             * */
        }

        public T pop() {
            return l.poll();
        }

        public boolean isEmpty() {
            return l.isEmpty() && r.isEmpty();
        }
    }

    // int[]{ minVal, maxVal}
    public static Result getMinMax(Node root) {
        if (root == null) return new Result();

        Result mm1 = getMinMax(root.left);
        Result mm2 = getMinMax(root.right);

        return new Result(
                Math.min(mm1.min, root.val),
                Math.max(mm2.max, root.val),
                mm1.max < root.val &&
                        mm2.min > root.val &&
                        mm1.isBST && mm2.isBST
        );
    }

    public static class Result {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean isBST = true;

        public Result(int min, int max, boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }

        public Result() {}
    }

    /*
     *
     * 10
     * 6   14
     * 4 8 12 16
     *
     * */

    private static class Node {
        int val;
        Node left;
        Node right;

    }

}
