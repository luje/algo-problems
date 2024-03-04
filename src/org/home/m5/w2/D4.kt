package org.home.m5.w2

/**
 * Created by lje on 5/11/2021.
 *
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3739/
 *
 */
object D4 {

    fun maxScore(cardPoints: IntArray, k: Int): Int {
        val s = cardPoints.sum()
        val n = cardPoints.size

        var r = (0 until n - k).map { cardPoints[it] }.sum()
        var m = s - r

        for (i in n - k until n) {
            r -= cardPoints[i - (n - k)]
            r += cardPoints[i]

            m = maxOf(m, s - r)
        }

        return m
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("248=" + maxScore(intArrayOf(100, 40, 17, 9, 73, 75), 3))
        println("12=" + maxScore(intArrayOf(1, 2, 3, 4, 5, 6, 1), 3))
        println("4=" + maxScore(intArrayOf(2, 2, 2), 2))
        println("55=" + maxScore(intArrayOf(9, 7, 7, 9, 7, 7, 9), 7))
        println("1=" + maxScore(intArrayOf(1, 1000, 1), 1))
        println("202=" + maxScore(intArrayOf(1, 79, 80, 1, 1, 1, 200, 1), 3))
    }
}
