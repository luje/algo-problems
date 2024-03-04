package org.home.m5.w2

/**
 * Created by lje on 5/12/2021.
 *
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3740/
 *
 */
object D5 {

    class NumMatrix(val matrix: Array<IntArray>) {

        private val ps = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }

        init {
            for (i in matrix.indices)
                for (j in matrix[i].indices)
                    ps[i + 1][j + 1] = ps[i][j + 1] + ps[i + 1][j] + matrix[i][j] - ps[i][j]
        }

        fun sumRegion(x1: Int, y1: Int, x2: Int, y2: Int): Int {
//            return (x1 .. x2).flatMap { i -> (y1 .. y2).map { j -> matrix[i][j] } }.sum()
            return ps[x2 + 1][y2 + 1] - ps[x1][y2 + 1] - ps[x2 + 1][y1] + ps[x1][y1]
        }

    }

    @JvmStatic
    fun main(args: Array<String>) {
        var obj = NumMatrix(
            arrayOf(
                intArrayOf(3, 0, 1, 4, 2),
                intArrayOf(5, 6, 3, 2, 1),
                intArrayOf(1, 2, 0, 1, 5),
                intArrayOf(4, 1, 0, 1, 7),
                intArrayOf(1, 0, 3, 0, 5)
            )
        )

        println(obj.sumRegion(2, 1, 4, 3))
        println(obj.sumRegion(1, 1, 2, 2))
        println(obj.sumRegion(1, 2, 2, 4))
    }
}
