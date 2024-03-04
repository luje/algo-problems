package org.home.contest1

/**
 * Created by lje on 6/28/2021.
 *
 * https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
 *
 */
object P1 {

    fun maxProductDifference(nums: IntArray): Int {
        var i1 = 0
        var j1 = 2

        for (i in nums.indices) {
            if (nums[i] > nums[i1]) {
                i1 = i
            }

            if (nums[i] < nums[j1]) {
                j1 = i
            }
        }

        var i2 = j1
        var j2 = i1

        for (i in nums.indices) {
            if (i != i1 && nums[i] > nums[i2]) {
                i2 = i
            }

            if (i != j1 && nums[i] < nums[j2]) {
                j2 = i
            }
        }

        return nums[i1] * nums[i2] - nums[j1] * nums[j2]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(maxProductDifference(intArrayOf(5, 9, 4, 6)))
        println(maxProductDifference(intArrayOf(5, 6, 2, 7, 4)))
        println(maxProductDifference(intArrayOf(4, 2, 5, 9, 7, 4, 8)))
    }
}
