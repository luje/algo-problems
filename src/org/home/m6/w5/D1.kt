package org.home.m6.w5

/**
 * Created by lje on 6/29/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/607/week-5-june-29th-june-30th/3796/
 *
 */
object D1 {
    fun longestOnes(nums: IntArray, k: Int): Int {

        var i = 0
        var j = 0
        var t = k
        var m = 0

        while (i < nums.size && j < nums.size) {
            if (t == 0) {
                if (nums[i++] == 0) {
                    t++
                }
            }

            while (j < nums.size && (t > 0 || nums[j] == 1)) {
                if (nums[j++] == 0) {
                    t--
                }
            }

            m = maxOf(m, j - i)
        }

        return m
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2))
        println(longestOnes(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3))
    }
}
