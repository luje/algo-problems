package org.home.m6.w3

/**
 * Created by lje on 6/15/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3780/
 *
 */
object D1 {

    fun makesquare(matchsticks: IntArray): Boolean {
        val s = matchsticks.sum()

        if (s % 4 != 0) return false

        val l = matchsticks.sum() / 4

        val square = IntArray(4)

        fun back(k: Int): Boolean {
            if (k == matchsticks.size) return true

            for (i in 0 until 4) {
                if (square[i] + matchsticks[k] <= l) {
                    square[i] += matchsticks[k]

                    val r = back(k + 1)

                    if(r) return true

                    square[i] -= matchsticks[k]
                }
            }

            return false
        }

        return back(0)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("true = " + makesquare(intArrayOf(1, 1, 2, 2, 2)))
        println("false = " + makesquare(intArrayOf(3, 3, 3, 3, 4)))
    }
}
