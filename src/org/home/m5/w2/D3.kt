package org.home.m5.w2

import kotlin.math.sqrt

/**
 * Created by lje on 5/10/2021.
 */
object D3 {

    fun countPrimes(n: Int): Int {
        if(n < 3) return 0

        val a = BooleanArray(n) { it % 2 != 0}

        a[0] = false
        a[1] = false
        a[2] = true

        for (i in 3 until sqrt(n.toDouble()).toInt() + 1) {
            if (a[i]) {
                (((i * i) until n) step i).forEach { a[it] = false }
            }
        }

        return a.indices.filter { a[it] }.count()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(countPrimes(100))
        println(countPrimes(10))
        println(countPrimes(4))
        println(countPrimes(1))
        println(countPrimes(2))
        println(countPrimes(0))
    }
}
