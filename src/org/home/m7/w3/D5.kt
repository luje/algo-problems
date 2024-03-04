package org.home.m7.w3

import java.util.*

/**
 * Created by lje on 7/20/2021.
 *
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3820/
 *
 */
object D5 {


    class Solution(nums: IntArray) {

        val nums = nums

        /** Resets the array to its original configuration and return it. */
        fun reset(): IntArray {
            return nums
        }

        /** Returns a random shuffling of the array. */
        fun shuffle(): IntArray {
            val b = BooleanArray(nums.size)
            val r = IntArray(nums.size)
            val random = Random()

            for(i in nums.indices) {
                var ii = random.nextInt(nums.size - i)
                var j = 0

                while(ii >= 0 && j < b.size) {
                    if(b[j]) {
                        ii--
                    }

                    j++
                }

                r[i] = nums[j]
                b[j] = true
            }

            return r
        }

    }

    @JvmStatic
    fun main(args: Array<String>) {
        val s = Solution(intArrayOf(1, 2, 3))

        println(s.shuffle().joinToString())
        println(s.reset().joinToString())
        println(s.shuffle().joinToString())
    }

}
