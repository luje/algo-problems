package org.home.m6.w4

import java.util.*

/**
 * Created by lje on 6/28/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3794/
 *
 */
object D7 {
    fun removeDuplicates(s: String): String {
        val r = StringBuilder()

        for (c in s) {
            if (r.isNotEmpty() && r.last() == c) {
                r.deleteCharAt(r.length - 1)
            } else {
                r.append(c)
            }
        }

        return r.toString()
    }

    fun removeDuplicates2(s: String): String {
        val stack = Stack<Char>()

        for (c in s) {
            when {
                stack.isNotEmpty() && stack.peek() == c -> stack.pop()
                else -> stack.add(c)
            }
        }

        return stack.joinToString("")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(removeDuplicates("abbaca"))
        println(removeDuplicates("azxxzy"))

        println(removeDuplicates2("abbaca"))
        println(removeDuplicates2("azxxzy"))
    }
}
