package org.home.m4

/**
 * Created by lje on 4/5/2021.
 */
object M4W1D5 {

    fun isIdealPermutation(a: IntArray): Boolean {
        if (a.size < 3)
            return true

        var m = -1

        return a.withIndex()
            .filter { (i, _) -> i + 2 < a.size }
            .firstOrNull { (i, v) ->
                m = kotlin.math.max(a[i], m)
                m > a[i + 2]
            } == null
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(isIdealPermutation(intArrayOf(1, 0, 2)))
        println(isIdealPermutation(intArrayOf(1, 2, 0)))
        println(isIdealPermutation(intArrayOf(0, 1, 2)))
    }
}
