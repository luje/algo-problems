package org.home.m7.w3

/**
 * Created by lje on 7/16/2021.
 *
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3816/
 *
 */
object D2 {

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val r = mutableSetOf<List<Int>>()

        nums.sort()

        for (a in 0 until nums.size - 3) {
            for (b in a + 1 until nums.size - 2) {
                var d = nums.size - 1

                for (c in b + 1 until nums.size - 1) {
                    if (c > d) break

                    while (d > c && nums[a] + nums[b] + nums[c] + nums[d] > target) d--

                    if (d > c && nums[a] + nums[b] + nums[c] + nums[d] == target) {
                        r += listOf(nums[a], nums[b], nums[c], nums[d])
                    }
                }
            }
        }

        return r.toList()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(fourSum(intArrayOf(-3, -2, -1, 0, 0, 1, 2, 3), 0))
        println(fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0))
        println(fourSum(intArrayOf(2, 2, 2, 2, 2), 8))
    }
}
