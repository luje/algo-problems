package org.home.m5.w1

/**
 * Created by lje on 5/4/2021.
 *
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3731/
 *
 */
object D4 {

    fun checkPossibility(nums: IntArray): Boolean {
        var c = 0
        for (i in 1 until nums.size) {
            if (nums[i - 1] > nums[i]) {
                if (c++ > 0 || (i > 1 && i < nums.size - 1 && nums[i - 2] > nums[i] && nums[i + 1] < nums[i - 1]))
                    return false
            }
        }

        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(checkPossibility(intArrayOf(1)))
        println(checkPossibility(intArrayOf(5, 7, 1, 8)))
        println(checkPossibility(intArrayOf(4, 2, 3)))
        println(checkPossibility(intArrayOf(4, 2, 1)))
        println(checkPossibility(intArrayOf(3, 4, 2, 3)))
    }
}
