package org.home.m7.w3

/**
 * Created by lje on 7/15/2021.
 *
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3815/
 *
 */
object D1 {

    fun triangleNumber(n: IntArray): Int {
        n.sort()

        var r = 0

        for (i in 0 until n.size - 2) {
            var k = i + 2

            for (j in i + 1 until n.size - 1) {
                if(n[i] == 0) break

                while (k < n.size && n[i] + n[j] > n[k]) k++

                r += k - (j + 1)
            }
        }

        return r
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(triangleNumber(intArrayOf(82, 15, 23, 82, 67, 0, 3, 92, 11)))
        println(triangleNumber(intArrayOf(0, 0, 0)))
        println(triangleNumber(intArrayOf(1, 1, 3, 4)))
        println(triangleNumber(intArrayOf(2, 2, 3, 4)))
        println(triangleNumber(intArrayOf(4, 2, 3, 4)))
    }
}
