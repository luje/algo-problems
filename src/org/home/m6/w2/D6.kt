package org.home.m6.w2

/**
 * Created by lje on 6/13/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3777/
 *
 */
object D6 {

    fun palindromePairs(words: Array<String>): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        for (i in words.indices) {
            for (j in words.indices) {
                if (i == j) continue

                if (palindromePair(words[i], words[j])) {
                    result.add(listOf(i, j))
                }
            }
        }

        return result
    }

    private fun palindromePair(s1: String, s2: String): Boolean {
        val n = minOf(s1.length, s2.length)

        for (i in 0 until n) {
            if (s1[i] != s2[s2.length - 1 - i]) return false
        }

        return if (n == s1.length)
            palindome(s2.substring(0, s2.length - n))
        else
            palindome(s1.substring(n))
    }

    private fun palindome(s: String): Boolean {
        for (i in 0 until s.length / 2) {
            if (s[i] != s[s.length - 1 - i]) return false
        }

        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(palindromePairs(arrayOf("abcd", "dcba", "lls", "s", "sssll")))
        println(palindromePairs(arrayOf("bat", "tab", "cat")))
        println(palindromePairs(arrayOf("a", "")))
    }
}
