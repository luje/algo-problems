package org.home.m7.w1

/**
 * Created by lje on 7/5/2021.
 *
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3802/
 *
 */
object D4 {

    fun countVowelPermutation(n: Int): Int {
        var dp1 = LongArray(5) { 1 }
        var dp2 = LongArray(5) { 0 }

        for (i in n - 2 downTo 0) {
            /* a */ dp2[0] = dp1[1]
            /* e */ dp2[1] = dp1[0] + dp1[2]
            /* i */ dp2[2] = dp1[0] + dp1[1] + dp1[3] + dp1[4]
            /* o */ dp2[3] = dp1[2] + dp1[4]
            /* u */ dp2[4] = dp1[0]

            for (j in 0 until 5) {
                dp1[j] = dp2[j].rem(1_000_000_007)
            }
        }

        return dp1.sum().rem(1_000_000_007).toInt()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(countVowelPermutation(1))
        println(countVowelPermutation(2))
        println(countVowelPermutation(5))
    }
}
