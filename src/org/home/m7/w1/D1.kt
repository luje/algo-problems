package org.home.m7.w1

/**
 * Created by lje on 7/1/2021.
 */
object D1 {

    fun grayCode(n: Int): List<Int> {
        var r = mutableListOf(0, 1)
        var i = 1

        while (i < n) {
            r.addAll(r.reversed().map { it or (1 shl i) })
            i++
        }

        return r
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(grayCode(1))
        println(grayCode(2))
        println(grayCode(3))
        println(grayCode(4))
        println(grayCode(16))
    }
}
