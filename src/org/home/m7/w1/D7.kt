package org.home.m7.w1

import java.util.*

/**
 * Created by lje on 7/7/2021.
 *
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3805/
 *
 */
object D7 {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val pq = PriorityQueue<Triple<Int, Int, Int>>(k, compareBy { it.first })
        val vs = Array(matrix.size) { BooleanArray(matrix[0].size) }

        pq.add(Triple(matrix[0][0], 0, 0))
        vs[0][0] = true

        for (i in 1 until k) {
            val (_, x, y) = pq.poll()

            if (x + 1 < matrix.size && !vs[x + 1][y]) {
                pq.add(Triple(matrix[x + 1][y], x + 1, y))
                vs[x + 1][y] = true
            }

            if (y + 1 < matrix[0].size && !vs[x][y + 1]) {
                pq.add(Triple(matrix[x][y + 1], x, y + 1))
                vs[x][y + 1] = true
            }
        }

        return pq.peek().first
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            kthSmallest(
                arrayOf(
                    intArrayOf(1, 3, 5),
                    intArrayOf(6, 7, 12),
                    intArrayOf(11, 14, 14)
                ), 6
            )
        )

        println(kthSmallest(arrayOf(intArrayOf(1, 2), intArrayOf(1, 3)), 2))
    }
}
