package org.home.m6.w2

/**
 * Created by lje on 6/10/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3774/
 *
 */
object D3 {

    class MyCalendar() {
        private val e = mutableListOf<Pair<Int, Int>>()

        fun book(start: Int, end: Int): Boolean {

            var ip = e.binarySearch(
                element = start to end,
                comparator = compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second }
            )

            if (ip >= 0)
                return false

            ip = -(ip + 1)

            if (ip - 1 >= 0 && start in e[ip - 1].first until e[ip - 1].second) return false
            if (ip < e.size && e[ip].first in start until end) return false

            e.add(ip, start to end)

            return true
        }

    }

    @JvmStatic
    fun main(args: Array<String>) {
        val c = MyCalendar()

        println(c.book(10, 20))
        println(c.book(15, 25))
        println(c.book(20, 30))
    }
}
