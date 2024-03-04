package org.home.m4

/**
 * Created by lje on 4/25/2021.
 *
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3720/
 *
 */
object M4W4D4 {

    fun rotate(m: Array<IntArray>): Array<IntArray> {
        val n = m.size - 1
        var a: Int

        for (i in 0 until n / 2) {
            for (j in i until n - i) {
                a = m[i][j]
                m[i][j] = m[n - j][i]
                m[n - j][i] = m[n - i][n - j]
                m[n - i][n - j] = m[j][n - i]
                m[j][n - i] = a
            }
        }

        return m
    }

    fun toString(a: Array<IntArray>): String = a.joinToString("\n") { it.joinToString(" ") }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            toString(
                rotate(
                    arrayOf(
                        intArrayOf(1, 2, 3),
                        intArrayOf(4, 5, 6),
                        intArrayOf(7, 8, 9)
                    )
                )
            )
        )

        println("-----------")

        println(
            toString(
                rotate(
                    arrayOf(
                        intArrayOf(5, 1, 9, 11),
                        intArrayOf(2, 4, 8, 10),
                        intArrayOf(13, 3, 6, 7),
                        intArrayOf(15, 14, 12, 16)
                    )
                )
            )
        )

        println("-----------")

        println(
            toString(
                rotate(
                    arrayOf(
                        intArrayOf(1)
                    )
                )
            )
        )

        println("-----------")

        println(
            toString(
                rotate(
                    arrayOf(
                        intArrayOf(1, 2),
                        intArrayOf(3, 4)
                    )
                )
            )
        )
    }
}
