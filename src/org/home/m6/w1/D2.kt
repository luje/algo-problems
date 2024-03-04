package org.home.m6.w1

/**
 * Created by lje on 6/2/2021.
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3765/
 */
object D2 {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val cache = Array(s1.length + 1) { Array<Boolean?>(s2.length + 1) { null } }

        fun dp(i: Int, j: Int): Boolean {
            when {
                cache[i][j] != null -> cache[i][j]
                i == s1.length -> cache[i][j] = s2.substring(j) == s3.substring(i + j)
                j == s2.length -> cache[i][j] = s1.substring(i) == s3.substring(i + j)
                else -> cache[i][j] =
                    (if (s1[i] == s3[i + j]) dp(i + 1, j) else false) ||
                            (if (s2[j] == s3[i + j]) dp(i, j + 1) else false)
            }

            return cache[i][j] ?: false
        }

        return s1.length + s2.length == s3.length && dp(0, 0)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("false = " + isInterleave(s1 = "aaaa", s2 = "aa", s3 = "aaa"))
        println("true = " + isInterleave(s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"))
        println("false = " + isInterleave(s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"))
        println("true = " + isInterleave(s1 = "", s2 = "", s3 = ""))
    }
}
