package org.home.m5.w5

import kotlin.math.abs

/**
 * Created by lje on 5/29/2021.
 *
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/602/week-5-may-29th-may-31st/3760/
 *
 */
object D1 {
    fun totalNQueens(n: Int): Int {
        return gen(n, 0, mutableSetOf())
    }

    private fun gen(n: Int, k: Int, solution: MutableSet<Pair<Int, Int>>): Int {
        if (k == n) return 1

        var count = 0

        for (j in 0 until n) {
            if (solution.all { q -> !attacks(k to j, q) }) {
                solution.add(k to j)
                count += gen(n, k + 1, solution)
                solution.remove(k to j)
            }
        }

        return count
    }

    private fun attacks(a: Pair<Int, Int>, b: Pair<Int, Int>) =
        a.first == b.first || a.second == b.second || abs(a.first - b.first) == abs(a.second - b.second)


    @JvmStatic
    fun main(args: Array<String>) {
        for (i in 1..9) {
            println("$i = ${totalNQueens(i)}")
        }
    }
}
