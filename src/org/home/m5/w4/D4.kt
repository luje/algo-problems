package org.home.m5.w4

import java.util.*

/**
 * Created by lje on 5/25/2021.
 */
object D4 {

    fun evalRPN(tokens: Array<String>): Int {
        val s = ArrayDeque<Int>(tokens.size)

        for (c in tokens) {
            when (c) {
                "*", "+", "-", "/" -> {
                    val a = s.pop()
                    val b = s.pop()

                    s.push(when (c) {
                        "+" -> a + b
                        "-" -> b - a
                        "*" -> a * b
                        else -> b / a
                    })
                }
                else -> s.push(c.toInt())
            }
        }

        return s.poll()!!
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(evalRPN(arrayOf("2", "1", "+", "3", "*")))
        println(evalRPN(arrayOf("4", "13", "5", "/", "+")))
        println(evalRPN(arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")))
    }
}
