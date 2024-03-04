package org.home.m7.w4

import java.util.*

/**
 * Created by lje on 7/22/2021.
 */
object D1 {
    fun partitionDisjoint(nums: IntArray): Int {
        val pq = PriorityQueue<Int>()

        for(i in nums) pq.add(i)

        var r = 0
        var max = nums[r]

        while (r < nums.size) {

        }

        return 0
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(partitionDisjoint(intArrayOf(5,0,3,8,6)))
        println(partitionDisjoint(intArrayOf(1,1,1,0,6,12)))
    }
}
