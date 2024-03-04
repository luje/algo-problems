package org.home.m6.w4

import java.util.*

/**
 * Created by lje on 6/22/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3788/
 *
 */
object D1 {

    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        val d = Array<Queue<String>>('z' - 'a' + 1) { LinkedList() }
        var r = 0

        for (w in words) d['z' - w[0]].add(w)
        for (c in s) {
            val queue = d['z' - c]
            d['z' - c] = LinkedList()

            for (o in queue) {
                if (o.length == 1) r++
                else d['z' - o[1]].add(o.substring(1))
            }
        }

        return r
    }

    fun numMatchingSubseq2(s: String, words: Array<String>): Int {
        return words.count { w -> subseq(s, w) }
    }

    private fun subseq(s: String, w: String): Boolean {
        var i = 0
        var j = 0

        while (i < s.length && j < w.length) {
            if (s[i] == w[j]) {
                i++
                j++
            } else {
                i++
            }
        }

        return j == w.length
    }

    @JvmStatic
    fun main(args: Array<String>) {

        println(subseq("abcde", "bb"))

        println(
            "3 = " +
                    numMatchingSubseq(s = "abcde", words = arrayOf("a", "bb", "acd", "ace"))
        )

        println(
            "2 = " +
                    numMatchingSubseq(s = "dsahjpjauf", words = arrayOf("ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"))
        )
    }
}
