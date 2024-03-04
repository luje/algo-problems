package org.home.m4

/**
 * Created by lje on 4/29/2021.
 *
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/597/week-5-april-29th-april-30th/3725/
 *
 */
object M4W5D1 {

    private val NOT_FOUND = intArrayOf(-1, -1)

    fun searchRange(nums: IntArray, target: Int): IntArray {
        return searchRange(nums, target, 0, nums.size - 1)
    }

    fun searchRange(nums: IntArray, target: Int, i: Int, j: Int): IntArray {
        if (i >= nums.size || j >= nums.size) return NOT_FOUND
        if (nums[i] == target && nums[j] == target) return intArrayOf(i, j)
        if (i == j) return NOT_FOUND

        return merge(
            if (nums[(i + j) / 2] < target) NOT_FOUND else searchRange(nums, target, i, (i + j) / 2),
            if (nums[(i + j) / 2 + 1] > target) NOT_FOUND else searchRange(nums, target, (i + j) / 2 + 1, j)
        )
    }

    fun merge(a: IntArray, b: IntArray): IntArray {
        return when {
            a[1] == -1 -> return b
            b[0] == -1 -> return a
            a[1] == b[0] -> return intArrayOf(a[0], b[1])
            a[1] + 1 == b[0] -> return intArrayOf(a[0], b[1])
            else -> NOT_FOUND
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(searchRange(intArrayOf(1, 2, 2), 2).joinToString())
        println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).joinToString())
        println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).joinToString())
        println(searchRange(intArrayOf(), 0).joinToString())
    }
}
