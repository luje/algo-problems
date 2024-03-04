package org.home.hackerrank.interview;

import java.util.List;
import java.util.Stack;

public class LargestRectangle {

    public static long largestRectangle(List<Integer> h) {
        // Write your code here
        final var n = h.size();

        int[] l = new int[n];
        int[] r = new int[n];

        Stack<Integer> stack;

        stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && h.get(stack.peek()) >= h.get(i)) {
                stack.pop();
            }

            l[i] = stack.isEmpty() ? -1 : stack.peek();

            if(stack.isEmpty() || stack.peek() != h.get(i)) {
                stack.push(i);
            }
        }

        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && h.get(stack.peek()) >= h.get(i)) {
                stack.pop();
            }

            r[i] = stack.isEmpty() ? n : stack.peek();

            if(stack.isEmpty() || stack.peek() != h.get(i)) {
                stack.push(i);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(h.get(i) * (r[i] - l[i] - 1), max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("9 = " + largestRectangle(List.of(1, 2, 3, 4, 5)));
    }
}
