package org.home.m6.w4

/**
 * Created by lje on 6/28/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3793/
 *
 */
object D6 {
    fun candy(ratings: IntArray): Int {

        val a = IntArray(ratings.size)

        for (i in 1 until ratings.size) {
            if (ratings[i] > ratings[i - 1]) a[i] = a[i - 1] + 1
        }

        for (i in ratings.size - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1]) a[i] = maxOf(a[i], a[i + 1] + 1)
        }

        return a.sum() + ratings.size
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(candy(intArrayOf(1, 3, 4, 5, 2)))
        println(candy(intArrayOf(1, 0, 2)))
        println(candy(intArrayOf(1, 0, 2, 3)))
        println(candy(intArrayOf(1, 2, 2)))
    }
}
