package org.home.m4

/**
 * Created by lje on 4/10/2021.
 *
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3703/
 *
 */
object M4W2D3 {

    val d = listOf(
        -1 to 0,
        1 to 0,
        0 to -1,
        0 to 1
    )

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val dp = Array(matrix.size) { IntArray(matrix[0].size) }

        for (i in matrix.indices)
            for (j in matrix[0].indices)
                dp[i][j] = maxFrom(i, j, matrix, dp)

        return dp.flatMap { it.asIterable() }.maxOrNull()?:0
    }

    private fun maxFrom(i: Int, j: Int, matrix: Array<IntArray>, dp: Array<IntArray>): Int {
        if (dp[i][j] > 0) return dp[i][j]

        dp[i][j] = d
            .filter { (p, q) ->
                0 <= i + p &&
                        i + p < matrix.size &&
                        0 <= j + q &&
                        j + q < matrix[0].size
            }
            .filter { (p, q) ->
                matrix[i + p][j + q] > matrix[i][j]
            }
            .map { (p, q) -> 1 + maxFrom(i + p, j + q, matrix, dp) }
            .maxOrNull() ?: 1

        return dp[i][j]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            longestIncreasingPath(
                arrayOf(
                    intArrayOf(0),
                    intArrayOf(1),
                    intArrayOf(5),
                    intArrayOf(5),
                )
            )
        )

        println(
            longestIncreasingPath(
                arrayOf(
                    intArrayOf(1, 2)
                )
            )
        )

        println(
            longestIncreasingPath(
                arrayOf(
                    intArrayOf(9, 9, 4),
                    intArrayOf(6, 6, 8),
                    intArrayOf(2, 1, 1)
                )
            )
        )

        println(
            longestIncreasingPath(
                arrayOf(
                    intArrayOf(3, 4, 5),
                    intArrayOf(3, 2, 6),
                    intArrayOf(2, 2, 1)
                )
            )
        )

        println(
            longestIncreasingPath(
                arrayOf(
                    intArrayOf(1)
                )
            )
        )
    }
}
