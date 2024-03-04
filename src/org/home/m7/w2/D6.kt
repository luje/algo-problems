package org.home.m7.w2

/**
 * Created by lje on 7/13/2021.
 *
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3812/
 *
 */
object D6 {

    fun findPeakElement(nums: IntArray): Int {

        var i = 0
        var j = nums.size - 1
        var m = i + (j - i) / 2

        while (i != j) {
            if ((m == 0 || nums[m - 1] <= nums[m]) && (m == nums.size - 1 || nums[m] >= nums[m + 1])) return m
            else if (m > 0 && nums[m - 1] > nums[m]) j = m - 1
            else i = m + 1

            m = i + (j - i) / 2
        }

        return m
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(findPeakElement(intArrayOf(1, 2, 3, 1)))
        println("=============")
        println(findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 4)))
    }
}
