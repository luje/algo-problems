package org.home.m4

/**
 * Created by lje on 4/19/2021.
 *
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3713/
 *
 */
object M4W3D5 {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        val cache = IntArray(target + 1) { -1 }

        return combinationSum4(nums.filter { it <= target }.toIntArray(), target, cache)
    }

    fun combinationSum4(nums: IntArray, target: Int, cache: IntArray): Int {
        if (cache[target] != -1) return cache[target]

        cache[target] = nums.filter { it <= target }
            .map { if(target - it == 0) 1 else combinationSum4(nums, target - it, cache) }
            .sum()

        return cache[target]!!
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(combinationSum4(intArrayOf(1, 2, 3), 4))
        println(combinationSum4(intArrayOf(4, 2, 1), 4))
        println(combinationSum4(intArrayOf(9), 3))
        println(
            combinationSum4(
                intArrayOf(
                    3,
                    4,
                    5,
                    6,
                    7,
                    8,
                    9,
                    10,
                    11,
                    12,
                    13,
                    14,
                    15,
                    16,
                    17,
                    18,
                    19,
                    20,
                    21,
                    22,
                    23,
                    24,
                    25
                ), 10
            )
        )
    }
}
