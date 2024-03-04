package org.home.m7.w2

/**
 * Created by lje on 7/14/2021.
 *
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3813/
 *
 */
object D7 {
    fun customSortString(order: String, str: String): String {

        val f = IntArray(26)

        for (c in str) {
            f['z' - c]++
        }

        val r = StringBuilder()

        for (c in order) {
            while (f['z' - c]-- > 0) {
                r.append(c)
            }
        }

        for (x in 0 until 26) {
            while (f[x]-- > 0) {
                r.append(('z' - x))
            }
        }

        return r.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(customSortString("cba", "abcd"))
    }
}
