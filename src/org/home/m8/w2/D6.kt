package org.home.m8.w2

/**
 * Created by lje on 8/13/2021.
 *
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3888/
 *
 */
object D6 {
    fun setZeroes(matrix: Array<IntArray>): Unit {
//        print(matrix)

        val r1 = matrix.any { it[0] == 0 }
        val l1 = matrix[0].any { it == 0 }

        for (i in 1 until matrix.size) {
            for (j in 1 until matrix[0].size) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0
                    matrix[i][0] = 0
                }
            }
        }

//        print(matrix)

        for (i in 1 until matrix.size) {
            if (matrix[i][0] == 0) {
                for (j in matrix[i].indices) matrix[i][j] = 0
            }
        }

//        print(matrix)

        for (j in 1 until matrix[0].size) {
            if (matrix[0][j] == 0) {
                for (i in matrix.indices) matrix[i][j] = 0
            }
        }

        if(r1) for (i in matrix.indices) matrix[i][0] = 0
        if(l1) for (j in matrix[0].indices) matrix[0][j] = 0

//        print(matrix)
    }

    @JvmStatic
    fun main(args: Array<String>) {
//        [[1,2,3,4],[5,0,7,8],[0,10,11,12],[13,14,15,0]]
        val m = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 0, 7, 8),
            intArrayOf(0, 10, 11, 12),
            intArrayOf(13, 14, 15, 0)
        )

        setZeroes(m)
    }

    private fun print(m: Array<IntArray>) {
        println(m.map { it.joinToString() }.joinToString("\n"))
        println()
    }
}
