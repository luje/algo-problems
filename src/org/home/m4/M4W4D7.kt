package org.home.m4

/**
 * Created by lje on 4/28/2021.
 *
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3723/
 *
 */
object M4W4D7 {

    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val dp = Array(obstacleGrid.size) { IntArray(obstacleGrid[0].size) }

        if (obstacleGrid[0][0] == 0) dp[0][0] = 1

        for (i in 1 until dp.size) if (obstacleGrid[i][0] == 1) break else dp[i][0] = dp[i - 1][0]
        for (j in 1 until dp[0].size) if (obstacleGrid[0][j] == 1) break else  dp[0][j] = dp[0][j - 1]

        for (i in 1 until dp.size)
            for (j in 1 until dp[i].size)
                dp[i][j] = if (obstacleGrid[i][j] == 1) 0 else (dp[i - 1][j] + dp[i][j - 1])

        return dp.last().last()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            uniquePathsWithObstacles(
                arrayOf(
                    intArrayOf(0, 1)
                )
            )
        )

        println(
            uniquePathsWithObstacles(
                arrayOf(
                    intArrayOf(0),
                    intArrayOf(1)
                )
            )
        )

        println(
            uniquePathsWithObstacles(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(0, 1, 0),
                    intArrayOf(0, 0, 0)
                )
            )
        )

        println(
            uniquePathsWithObstacles(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 0)
                )
            )
        )
    }
}
