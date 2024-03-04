package org.home.m5.w1

/**
 * Created by lje on 5/5/2021.
 *
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3732/
 *
 */
object D5 {

    fun jump(nums: IntArray): Int {
        val dp = IntArray(nums.size) { if (it == nums.size - 1) 0 else -1 }

        for (i in nums.size - 2 downTo 0) {
            dp[i] = (1..nums[i])
                .map { i + it }
                .filter { it < nums.size }
                .map { dp[it] }
                .filter { it >= 0 }
                .map { it + 1 }
                .minOrNull() ?: -1
        }

        return dp[0]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(jump(intArrayOf(2, 3, 1, 1, 4)))
        println(jump(intArrayOf(2, 3, 0, 1, 4)))
    }
}
