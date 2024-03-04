package org.home.leetcode.random;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/editorial/
public class MinAreaHistogram {

    public int largestRectangleArea(int[] heights) {
//        System.out.println("-----------------------------------------------------------------------------------");

        var lh = new int[heights.length];
        var rh = new int[heights.length];

        Arrays.fill(lh, -1);
        Arrays.fill(rh, heights.length);

        Stack<Integer> stack;

        stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                lh[i] = stack.peek();
            }

            if (stack.isEmpty() || stack.peek() != i) {
                stack.push(i);
            }
        }

        stack = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                rh[i] = stack.peek();
            }

            if (stack.isEmpty() || stack.peek() != i) {
                stack.push(i);
            }
        }

        var min = -1;
        for (int i = 0; i < heights.length; i++) {
            var w = (i - lh[i] - 1) +
                    (rh[i] - i - 1) + 1;

//            System.out.println(i + " " + w);

            min = Math.max(min, w * heights[i]);
        }

//        System.out.println(Arrays.stream(lh).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
//        System.out.println(Arrays.stream(rh).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

        return min;
    }

    public static void main(String[] args) {
        var solver = new MinAreaHistogram();

        System.out.println("2=" + solver.largestRectangleArea(new int[]{1, 1}));
        System.out.println("4=" + solver.largestRectangleArea(new int[]{2, 4}));
        System.out.println("10=" + solver.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

}
