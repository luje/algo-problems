package org.home.m7.w2

/**
 * Created by lje on 7/8/2021.
 */
object D1 {
    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        val dp = Array(nums1.size + 1) { IntArray(nums2.size + 1) }
        var m = 0

        for (i in nums1.size - 1 downTo 0) {
            for (j in nums2.size - 1 downTo 0) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1

                    m = maxOf(dp[i][j], m)
                }
            }
        }

        return m
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(findLength(intArrayOf(1, 2, 3, 2, 1), intArrayOf(3, 2, 1, 4, 7)))
        println(findLength(intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 0, 0, 0)))
    }
}
