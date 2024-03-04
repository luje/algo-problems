package org.home.m6.w2

import java.util.*

/**
 * Created by lje on 6/9/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3773/
 *
 */
object D2 {

    fun maxResult(nums: IntArray, k: Int): Int {
        val dp = IntArray(nums.size)
        val pq = PriorityQueue<Int>(Collections.reverseOrder())

        for (i in nums.indices) {
            val minOrNull = pq.peek() ?: 0

            dp[i] = nums[i] + minOrNull

            pq.add(dp[i])

            if(i - k >= 0) pq.remove(dp[i - k])
        }

        return dp.last()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("4 = " + maxResult(nums = intArrayOf(-1, -2, -2, 4, -7, 3), k = 2))
        println("7 = " + maxResult(nums = intArrayOf(1, -1, -2, 4, -7, 3), k = 2))
        println("17 = " + maxResult(nums = intArrayOf(10, -5, -2, 4, 0, 3), k = 3))
        println("0 = " + maxResult(nums = intArrayOf(1, -5, -20, 4, -1, 3, -6, -3), k = 2))
    }

}
