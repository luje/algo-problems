package org.home.m6.w1

/**
 * Created by lje on 6/7/2021.
 */
object D7 {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size

        var a = cost[0]
        var b = cost[1]

        for (i in 2 until n) {
            val c = cost[i] + minOf(a, b)

            a = b
            b = c
        }

        return minOf(a, b)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("15 = " + minCostClimbingStairs(intArrayOf(10, 15, 20)))
        println("6 = " + minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
    }
}
