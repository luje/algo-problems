package org.home.m8.w2

/**
 * Created by lje on 8/9/2021.
 *
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3875/
 *
 */
object D2 {
    fun addStrings(num1: String, num2: String): String {
        var aux = 0

        var result = StringBuilder()

        var i = num1.length - 1
        var j = num2.length - 1

        while(i >= 0 || j >= 0) {

            val ac = if (i >= 0) num1[i--] - '0' else 0
            val bc = if (j >= 0) num2[j--] - '0' else 0

            val cc = (ac + bc + aux)

            result.append(cc % 10)
            aux = cc / 10
        }

        if (aux != 0) result.append(aux)

        return result.reverse().toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(addStrings("0", "0"))
        println(addStrings("0", "1"))
        println(addStrings("0", "11"))
        println(addStrings("11", "11"))
        println(addStrings("11", "123"))
        println(addStrings("123", "11"))
        println(addStrings("456", "456"))
        println(addStrings("2", "999"))
        println(addStrings("999", "2"))
    }
}
