package org.home.m5.w3

/**
 * Created by lje on 5/19/2021.
 *
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3748/
 *
 */
object D5 {

    fun minMoves2(nums: IntArray): Int {
        nums.sort()

        return nums.map { Math.abs(it - nums[nums.size / 2]) }.sum()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(minMoves2(intArrayOf(1, 2, 3)))
        println(minMoves2(intArrayOf(1, 10, 2, 9)))
        println(minMoves2(intArrayOf(1, 0, 0, 8, 6)))
    }
}
