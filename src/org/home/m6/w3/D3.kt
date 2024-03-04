package org.home.m6.w3

/**
 * Created by lje on 6/17/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3782/
 *
 */
object D3 {

    fun numSubarrayBoundedMax(nums: IntArray, left: Int, right: Int): Int {
        return nums
            .mapIndexed { i:Int, v:Int -> if (v in left..right) count(nums, i, v) else emptySet() }
            .flatMap { it }
            .toSet().size
    }

    private fun count(nums: IntArray, k: Int, v: Int): Set<Pair<Int, Int>> {
        var l = 0

        for (i in k - 1 downTo 0) {
            if (nums[i] > v) break

            l++
        }

        var r = 0
        for (i in k + 1 until nums.size) {
            if (nums[i] > v) break

            r++
        }

        val result = mutableSetOf<Pair<Int, Int>>()

        for (i in k - l .. k) {
            for(j in k .. k + r) {
                result.add(i to j)
            }
        }

        return result
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            "22 = " +
                    numSubarrayBoundedMax(
                        nums = intArrayOf(73, 55, 36, 5, 55, 14, 9, 7, 72, 52),
                        left = 32,
                        right = 69
                    )
        )

        println(
            "3 = " +
                    numSubarrayBoundedMax(
                        nums = intArrayOf(2, 1, 4, 3),
                        left = 2,
                        right = 3
                    )
        )
    }
}
