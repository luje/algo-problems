package org.home.m4

/**
 * Created by lje on 4/15/2021.
 *
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3709/
 *
 */
object M4W3D1 {

    fun fib(n: Int): Int =
        when {
            n < 2 -> n
            else ->
                (0 until n - 1)
                    .fold(0 to 1, { acc, _ -> acc.second to acc.first + acc.second })
                    .second
        }


    fun fib1(n: Int): Int {
        if(n < 2) return n

        var a = 0
        var b = 1
        var i = n

        while(--i > 0) {
            val r = a + b
            a = b
            b = r
        }

        return b
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(fib(0))
        println(fib(1))
        println(fib(2))
        println(fib(3))
        println(fib(4))
        println(fib(5))
        println(fib(6))
    }
}
