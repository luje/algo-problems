package org.home.m6.w4

/**
 * Created by lje on 6/25/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3791/
 *
 */
object D3 {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val c = mutableMapOf<Int, MutableSet<Int>>()

        for (e in edges) {
            val a = e[0]
            val b = e[1]

            val ac = c[a] ?: mutableSetOf(a)
            val bc = c[b] ?: mutableSetOf(b)

            if(b in ac) return e

            ac.addAll(bc)

            for (el in ac) {
                c[el] = ac
            }
        }

        return edges.last()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            findRedundantConnection(
                arrayOf(
                    intArrayOf(3, 7),
                    intArrayOf(1, 4),
                    intArrayOf(2, 8),
                    intArrayOf(1, 6),
                    intArrayOf(7, 9),
                    intArrayOf(6, 10),
                    intArrayOf(1, 7),
                    intArrayOf(2, 3),
                    intArrayOf(8, 9),
                    intArrayOf(5, 9)
                )
            ).joinToString(" ")
        )

        println(
            findRedundantConnection(
                arrayOf(
                    intArrayOf(3, 4),
                    intArrayOf(1, 2),
                    intArrayOf(2, 4),
                    intArrayOf(3, 5),
                    intArrayOf(2, 5)
                )
            ).joinToString(" ")
        )

        println(
            findRedundantConnection(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(1, 3),
                    intArrayOf(2, 3)
                )
            ).joinToString(" ")
        )

        println(
            findRedundantConnection(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 3),
                    intArrayOf(3, 4),
                    intArrayOf(1, 4),
                    intArrayOf(1, 5)
                )
            ).joinToString(" ")
        )
    }
}
