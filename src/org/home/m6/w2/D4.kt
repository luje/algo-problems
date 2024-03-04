package org.home.m6.w2

/**
 * Created by lje on 6/12/2021.
 */
object D4 {
    fun stoneGameVII(stones: IntArray): Int {
        var s = stones.sum()
        val dp = Array(stones.size) { IntArray(stones.size) }

        fun m(i: Int, j: Int, stones: IntArray): Int {
            if(j < i) return 0
            if (i >= stones.size) return 0
            if (j < 0) return 0
            if (dp[i][j] > 0) return dp[i][j]

            dp[i][j] = maxOf(m(i + 1, j, stones) + stones[i], m(i, j - 1, stones) + stones[j])

            return dp[i][j]
        }

        m(0, stones.size - 1, stones)

        println(
            dp.map { it.joinToString(" ") }
                .joinToString("\n")
        )

        return s
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("6 = " + stoneGameVII(intArrayOf(5, 3, 1, 4, 2)))
        println("122 = " + stoneGameVII(intArrayOf(7, 90, 5, 1, 100, 10, 10, 2)))
    }
}
