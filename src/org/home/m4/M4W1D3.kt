package org.home.m4

import java.util.*

/**
 * Created by lje on 4/3/2021.
 *
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3695/
 *
 */
object M4W1D3 {

    fun longestValidParentheses(s: String): Int {

        val stack = LinkedList<Char>()
        val m = LinkedList<Int>()

        for(c in s) {
            if(stack.isEmpty()) {
                stack.push(c)
                m.push(0)

                continue;
            }

            if(c == ')' && stack.peek() == '(') {
                stack.pop()

                var sum = 2
                var x = 1
                while ( x != 0) {
                    x = m.pop()
                    sum += x
                }

                m.push(sum)

                continue;
            }

            m.push(0)
            stack.push(c)
        }

        var max = 0;
        var current = 0;

        for(c in m) {
            current += c

            if(c == 0) {
                max = if (max < current) current else max
                current = 0;
            }
        }

        return if (max < current) current else max;
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("6 = " + longestValidParentheses("()(())"))
        println("2 = " + longestValidParentheses("()(()"))
        println("2 = " + longestValidParentheses("()"))
        println("4 = " + longestValidParentheses("()((())"))
        println("4 = " + longestValidParentheses("()((())("))
        println("4 = " + longestValidParentheses("())(())"))
        println("4 = " + longestValidParentheses("())(())"))
        println("4 = " + longestValidParentheses(")()())"))
        println("0 = " + longestValidParentheses(""))
        println("2 = " + longestValidParentheses("(()"))
    }
}
