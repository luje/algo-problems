package org.home.m3

/**
 * Created by lje on 3/31/2021.
 *
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/592/week-5-march-29th-march-31st/3691/
 *
 */
object M3W5D31 {

    fun movesToStamp(stamp: String, target: String): IntArray {
        if (finished(target)) {
            return IntArray(0)
        }

        val i = find(stamp, target)

        if (i == -1) return IntArray(0)

        return movesToStamp(
            stamp,
            target.substring(0, i) +
                    "?".repeat(stamp.length) +
                    target.substring(i + stamp.length)
        ) + IntArray(1) { i }
    }


    private fun finished(target: String): Boolean {
        return target.all { it == '?' }
    }

    private fun find(stamp: String, target: String): Int {
        var i = 0

        while (i != -1 && i < target.length) {
            i = target.indexOf(stamp.first(), i)

            if (matches(stamp, target, i))
                return i
            else if (i != -1) i++
        }

        i = 0

        while (i != -1 && i < target.length) {
            i = target.indexOf(stamp.last(), i)

            if (matches(stamp, target, i - stamp.length + 1))
                return i - stamp.length + 1
            else if (i != -1) i++
        }

        return -1;
    }

    private fun matches(stamp: String, target: String, i: Int): Boolean {
        if (i < 0)
            return false

        if (i + stamp.length > target.length)
            return false

        var valid = false
        var matches = true

        for (j in stamp.indices) {
            if (target[i + j] != '?')
                valid = true

            if (target[i + j] !in setOf(stamp[j], '?')) {
                matches = false

                break
            }
        }

        return matches && valid
    }

    @JvmStatic
    fun main(args: Array<String>) {
//        println(matches("abc", "ababc", 2))
//        println(matches("abc", "ababc", 0))
//        println(matches("abc", "ab?bc", 0))
//        println(matches("abca", "?????ca", 3))
//
//
//        movesToStamp("abc", "ababc").forEach(::println)
//
//
//        println("-------------")
//
//        movesToStamp("abca", "aabcaca").forEach(::println)
//
//        println("-------------")
//
//        movesToStamp("oz", "ooozz").forEach(::println)

//        println("-------------")
//
//        movesToStamp("aye", "eyeye").forEach(::println)

        println("-------------")

        movesToStamp("mda", "mdadddaaaaa").forEach(::println)
    }
}
