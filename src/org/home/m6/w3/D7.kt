package org.home.m6.w3

/**
 * Created by lje on 6/21/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3786/
 *
 */
object D7 {
    fun generate(numRows: Int): List<List<Int>> {
        val r = List(numRows) { i -> MutableList(i + 1) { 1 } }

        for (i in 1 until numRows) {
            for (j in 1 until i) {
                r[i][j] = r[i - 1][j - 1] + r[i - 1][j]
            }
        }

        return r
    }

    fun generate2(numRows: Int): List<List<Int>> =
        (1 until numRows).fold(listOf(listOf(1)))
        { r, i ->
            r + listOf((0 until i + 1)
                .map { j ->
                    when (j) {
                        0 -> 1
                        i -> 1
                        else -> r[i - 1][j - 1] + r[i - 1][j]
                    }
                })
        }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            generate(30).joinToString("\n") { it.joinToString(" ") }
        )
    }
}
