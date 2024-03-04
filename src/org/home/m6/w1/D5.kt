package org.home.m6.w1

import java.util.*

/**
 * Created by lje on 6/5/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3768/
 * 
 */
object D5 {

    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
        val w = speed.zip(efficiency).sortedByDescending { it.second }
        val pq = PriorityQueue<Int>()

        var t = 0L
        var b = 0L

        for (e in w) {
            val (sp, ef) = e

            pq.add(sp)

            t += if (pq.size <= k) sp
            else sp - pq.poll()

            b = maxOf(b, t * ef)
        }

        return b.rem(1_000_000_007).toInt()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            "60 = " +
                    maxPerformance(
                        n = 6,
                        speed = intArrayOf(2, 10, 3, 1, 5, 8),
                        efficiency = intArrayOf(5, 4, 3, 9, 7, 2),
                        k = 2
                    )
        )

        println(
            "68 = " +
                    maxPerformance(
                        n = 6,
                        speed = intArrayOf(2, 10, 3, 1, 5, 8),
                        efficiency = intArrayOf(5, 4, 3, 9, 7, 2),
                        k = 3
                    )
        )

        println(
            "72 = " +
                    maxPerformance(
                        n = 6,
                        speed = intArrayOf(2, 10, 3, 1, 5, 8),
                        efficiency = intArrayOf(5, 4, 3, 9, 7, 2), k = 4
                    )
        )
    }
}
