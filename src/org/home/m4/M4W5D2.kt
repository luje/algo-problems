package org.home.m4

/**
 * Created by lje on 5/1/2021.
 *
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/597/week-5-april-29th-april-30th/3726/
 *
 */
object M4W5D2 {

    fun powerfulIntegers(x: Int, y: Int, bound: Int): List<Int> {
        val result = mutableSetOf<Int>()

        val v1 = fill(x, bound)
        val v2 = fill(y, bound)

        for (p in v1) {
            for (q in v2) {
                val s = p + q
                if (s > bound) break
                result.add(s)
            }
        }

        return result.toList()
    }

    private fun fill(x: Int, bound: Int): List<Int> {
        val l = mutableListOf(1)
        var p = 1

        while (p < bound) {
            if (p * x == p) break
            p *= x
            l.add(p)
        }

        return l
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(powerfulIntegers(1, 1, 0).joinToString())
        println(powerfulIntegers(1, 1, 10).joinToString())
        println(powerfulIntegers(2, 3, 10).joinToString())
        println(powerfulIntegers(3, 5, 15).joinToString())
    }
}
