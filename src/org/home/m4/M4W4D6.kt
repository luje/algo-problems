package org.home.m4

import kotlin.math.pow
import kotlin.math.roundToInt

/**
 * Created by lje on 4/27/2021.
 */
object M4W4D6 {

    fun isPowerOfThree(n: Int): Boolean {
        return n > 0 && 3.toDouble().pow(20).toLong() % n.toLong() == 0L
    }

    fun isPowerOfThree1(n: Int): Boolean {
        if(n <= 0) return false
        if(n == 1) return true

        val v = kotlin.math.log(n.toDouble(), 3.0)
        val floor = v.roundToInt()

        return n.toLong() == 3.toDouble().pow(floor).toLong()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(isPowerOfThree(2147483647))
        println(isPowerOfThree(-3))
        println(isPowerOfThree(243))
        println(isPowerOfThree(27))
        println(isPowerOfThree(0))
        println(isPowerOfThree(9))
        println(isPowerOfThree(45))
    }
}
