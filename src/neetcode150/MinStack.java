package neetcode150;

import java.util.Stack;

public class MinStack {

    Stack<Integer> minStack;
    Stack<Integer> stack;

    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        final int value = stack.pop();

        if(minStack.peek() == value) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println("-1024 = " + minStack.getMin());
        minStack.pop();
        System.out.println("-1024 = " + minStack.getMin());
        minStack.pop();
        System.out.println("512 = " + minStack.getMin());
    }
}
