package org.home.m4

/**
 * Created by lje on 4/23/2021.
 */
object M4W4D2 {
    fun countBinarySubstrings(s: String): Int {
        val c1 = s[0]
        var cc1 = 1

        while (cc1 < s.length && s[cc1] == c1) cc1++

        return countBinarySubstrings(s, cc1, 0)
    }

    fun countBinarySubstrings(s: String, cc1: Int, offset: Int): Int {
        if (cc1 >= s.length) return 0

        var c2 = s[cc1]
        var cc2 = cc1
        while (cc2 < s.length && s[cc2] == c2) cc2++

        return minOf(cc1 - offset, cc2 - cc1) + countBinarySubstrings(s, cc2, cc1)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(countBinarySubstrings("01"))
        println(countBinarySubstrings("00100"))
        println(countBinarySubstrings("00110011"))
        println(countBinarySubstrings("10101"))
    }
}
