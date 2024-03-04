package org.home.m6.w3

import java.util.*

/**
 * Created by lje on 6/21/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3785/
 *
 */
object D6 {
    fun swimInWater(grid: Array<IntArray>): Int {
        val n = grid.size
        val d = IntArray(n * n) { Int.MAX_VALUE }

        d[0] = grid[0][0]

        val pq = PriorityQueue<Int>(compareBy { d[it] })

        pq.add(0)

        while (!pq.isEmpty()) {
            val u = pq.poll()

            if(u == n * n - 1)
                return d[n * n - 1]

            neighbors(u, n).forEach { v ->
                val alt = maxOf(d[u], grid[v / n][v % n])

                if (alt < d[v]) {
                    d[v] = alt

                    pq.remove(v)
                    pq.add(v)
                }
            }
        }

        return d[n * n - 1]
    }

    val directions = setOf((-1 to 0), (1 to 0), (0 to -1), (0 to 1))

    private fun neighbors(u: Int, n: Int): List<Int> =
        directions
            .map { (i, j) -> u / n + i to u % n + j }
            .filter { (i, j) -> i in 0 until n && j in 0 until n }
            .map { (i, j) -> i * n + j }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            swimInWater(
                arrayOf(
                    intArrayOf(10, 12, 4, 6),
                    intArrayOf(9, 11, 3, 5),
                    intArrayOf(1, 7, 13, 8),
                    intArrayOf(2, 0, 15, 14)
                )
            )
        )

        println("------------")

        println(
            swimInWater(
                arrayOf(
                    intArrayOf(3, 2),
                    intArrayOf(0, 1),
                )
            )
        )

        println("------------")

        println(
            swimInWater(
                arrayOf(
                    intArrayOf(3, 2),
                    intArrayOf(1, 0),
                )
            )
        )

        println("------------")

        println(
            swimInWater(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(2, 3)
                )
            )
        )

        println("------------")

        println(
            swimInWater(
                arrayOf(
                    intArrayOf(0, 1, 2, 3, 4),
                    intArrayOf(24, 23, 22, 21, 5),
                    intArrayOf(12, 13, 14, 15, 16),
                    intArrayOf(11, 17, 18, 19, 20),
                    intArrayOf(10, 9, 8, 7, 6),
                )
            )
        )
    }
}
