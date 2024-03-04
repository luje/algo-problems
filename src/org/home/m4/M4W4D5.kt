package org.home.m4

import java.util.*

/**
 * Created by lje on 4/26/2021.
 *
 * https://leetcode.com/explore/featured/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3721/
 *
 */
object M4W4D5 {

    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        var b = 0
        val l = PriorityQueue<Int>(heights.size - 1)

        for (i in 0 until heights.size - 1) {
            val v = heights[i + 1] - heights[i]

            if (v <= 0) continue

            l.add(v)

            if (l.size > ladders) b += l.poll()
            if (b > bricks) return i
        }

        return heights.size - 1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(furthestBuilding(intArrayOf(4, 2, 7, 6, 9, 14, 12), 5, 1))
        println(furthestBuilding(intArrayOf(4, 12, 2, 7, 3, 18, 20, 3, 19), 10, 2))
        println(furthestBuilding(intArrayOf(14, 3, 19, 3), 17, 0))
    }
}
