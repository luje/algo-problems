package org.home.m5.w1

/**
 * Created by lje on 5/7/2021.
 *
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3734/
 * 
 */
object D7 {
    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word1.length) { IntArray(word2.length) }

        return minDistance(word1, word2, 0, 0, dp)
    }

    fun minDistance(word1: String, word2: String, i: Int, j: Int, cache: Array<IntArray>): Int {
        if (i == word1.length) return word2.length - j
        if (j == word2.length) return word1.length - i
        if (cache[i][j] != -1) return cache[i][j]

        cache[i][j] = minOf(
            if (word1[i] == word2[j]) minDistance(word1, word2, i + 1, j + 1, cache) else Int.MAX_VALUE,
            1 + minDistance(word1, word2, i + 1, j, cache),
            1 + minDistance(word1, word2, i, j + 1, cache)
        )

        return cache[i][j]
    }

    @JvmStatic
    fun main(args: Array<String>) {
//        println(minDistance("sea", "eat"))
        println(minDistance("leetcode", "etco"))
    }
}
