package org.home.m4

/**
 * Created by lje on 4/6/2021.
 */
object M4W1D6 {

    fun minOperations(n: Int): Int {
        return (0 until n / 2)
            .map { n - 2 * it - 1 }
            .sum()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(minOperations(3))
        println("-------")
        println(minOperations(6))
    }
}
