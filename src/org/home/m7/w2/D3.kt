package org.home.m7.w2

/**
 * Created by lje on 7/10/2021.
 *
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/609/week-2-july-8th-july-14th/3809/
 *
 */
object D3 {
    fun numDecodings(s: String): Int {
        var dp2 = comb(s.last())
        var dp1 = dp2
        var dp3 = 1L

        for (i in s.length - 2 downTo 0) {
            val one = dp2 * comb(s[i])
            val two = dp3 * comb("${s[i]}${s[i + 1]}")

            dp1 = (one + two).rem(1_000_000_007)

            dp3 = dp2
            dp2 = dp1
        }

        return dp1.rem(1_000_000_007).toInt()
    }

    fun comb(c: Char): Long = when (c) {
        '*' -> 9
        '0' -> 0
        else -> 1
    }

    fun comb(s: String): Long = when {
        s == "**" -> 15
        s == "1*" -> 9
        s == "2*" -> 6
        s[1] == '*' -> 0
        s == "*0" -> 2
        s == "*1" -> 2
        s == "*2" -> 2
        s[0] == '*' && s[1] < '7' -> 2
        s[0] == '*' && s[1] >= '7' -> 1
        s[0] == '0' -> 0
        s.toInt() > 26 -> 0
        else -> 1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(numDecodings("*"))
        println(numDecodings("*3"))
        println(numDecodings("*1*1*0"))
        println(numDecodings("*1"))
        println(numDecodings("**"))
        println(numDecodings("*"))
        println(numDecodings("1*"))
        println(numDecodings("2*"))
    }
}
