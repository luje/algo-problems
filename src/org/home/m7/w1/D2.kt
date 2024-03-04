package org.home.m7.w1

import kotlin.math.abs

/**
 * Created by lje on 7/2/2021.
 *
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3800/
 *
 */
object D2 {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val xi = arr.binarySearch(x)

        val r = mutableListOf<Int>()
        var j = if (xi < 0) -xi - 1 else xi
        var i = j - 1

        while (r.size < k) {

            if (i < 0) {
                r.add(arr[j++])

                continue
            }

            if (j >= arr.size) {
                r.add(0, arr[i--])

                continue
            }

            val c1 = arr[i]
            val c2 = arr[j]

            if (abs(x - c1) <= abs(x - c2)) {
                r.add(0, arr[i--])
            } else {
                r.add(arr[j++])
            }
        }

        return r
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            findClosestElements(
                intArrayOf(1, 1, 1, 10, 10, 10),
                1,
                9
            )
        )
        println(findClosestElements(intArrayOf(0, 0, 1, 2, 3, 3, 4, 7, 7, 8), 3, 5))
        println(findClosestElements(intArrayOf(1, 2, 3, 4, 5), 4, 3))
        println(findClosestElements(intArrayOf(1, 2, 3, 4, 5), 4, -1))
    }
}
