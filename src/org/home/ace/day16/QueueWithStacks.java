package org.home.ace.day16;

import java.util.Stack;

public class QueueWithStacks {

    static class MyQueue {

        Stack<Integer> left;
        Stack<Integer> right;

        public MyQueue() {
            left = new Stack<>();
            right = new Stack<>();
        }

        public void push(int x) {
            left.push(x);
        }

        public int pop() {
            if(right.isEmpty()) {
                while (!left.isEmpty()) {
                    right.push(left.pop());
                }
            }

            return right.pop();
        }

        public int peek() {
            if(right.isEmpty()) {
                while (!left.isEmpty()) {
                    right.push(left.pop());
                }
            }

            return right.peek();
        }

        public boolean empty() {
            return left.isEmpty() && right.isEmpty();
        }
    }
}
