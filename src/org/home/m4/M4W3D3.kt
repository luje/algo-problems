package org.home.m4

/**
 * Created by lje on 4/17/2021.
 *
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3711/
 *
 */
object M4W3D3 {

    fun numSubmatrixSumTarget(matrix: Array<IntArray>, target: Int): Int {
        val ps = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }

        for (i in matrix.indices)
            for (j in matrix[i].indices)
                ps[i + 1][j + 1] = ps[i][j + 1] + ps[i + 1][j] + matrix[i][j] - ps[i][j]

        var count = 0
        for (x1 in matrix.indices)
            for (y1 in matrix[x1].indices)
                for (x2 in x1 until matrix.size)
                    for (y2 in y1 until matrix[x1].size) {
                        val sum = ps[x2 + 1][y2 + 1] - ps[x1][y2 + 1] - ps[x2 + 1][y1] + ps[x1][y1]

                        if (sum == target) {
                            count++
                        }
                    }

        return count
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            numSubmatrixSumTarget(
                arrayOf(
                    intArrayOf(0, 1, 0),
                    intArrayOf(1, 1, 1),
                    intArrayOf(0, 1, 0),
                ), 0
            )
        )

        println(
            numSubmatrixSumTarget(
                arrayOf(
                    intArrayOf(1, -1),
                    intArrayOf(-1, 1),
                ), 0
            )
        )

        println(
            numSubmatrixSumTarget(
                arrayOf(
                    intArrayOf(1),
                ), 0
            )
        )
    }
}
