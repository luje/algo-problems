package org.home.m6.w1

import java.util.*
import java.util.stream.IntStream
import java.util.stream.Stream

/**
 * Created by lje on 6/4/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3767/
 * 
 */
object D4 {
    fun openLock(deadends: Array<String>, target: String): Int {
        if ("0000" in deadends || target in deadends) return -1

        val d = deadends.toMutableSet()
        val stack = LinkedList<Pair<Int, String>>()

        stack.push(0 to "0000")

        while (!stack.isEmpty()) {
            val (l, combination) = stack.pollLast()

            if (combination == target) return l

            expand(combination)
                .filter { it !in d }
                .forEach {
                    d.add(it)
                    stack.push(l + 1 to it)
                }
        }

        return -1
    }

    private fun expand(c: String): Stream<String> =
        IntStream.range(0, c.length)
            .mapToObj { i -> i }
            .flatMap { i ->
                v(c[i]).stream().map {
                    val r = c.toCharArray()
                    r[i] = it
                    return@map String(r)
                }
            }

    private fun v(c: Char): List<Char> = listOf(
        '0' + ((c - '0' + 10 - 1) % 10),
        '0' + ((c - '0' + 10 + 1) % 10)
    )

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            "6 = " + openLock(
                deadends = arrayOf("0201", "0101", "0102", "1212", "2002"), target = "0202"
            )
        )

        println(
            "1 = " + openLock(
                deadends = arrayOf("8888"), target = "0009"
            )
        )

        println(
            "-1 = " + openLock(
                deadends = arrayOf("8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"), target = "8888"
            )
        )

        println(
            "-1 = " + openLock(
                deadends = arrayOf("0000"), target = "8888"
            )
        )
    }
}
