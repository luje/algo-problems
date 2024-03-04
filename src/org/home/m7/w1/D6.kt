package org.home.m7.w1

/**
 * Created by lje on 7/6/2021.
 */
object D6 {
    fun minSetSize(arr: IntArray): Int {
        val fr = mutableMapOf<Int, Int>()

        for (i in arr) {
            fr.putIfAbsent(i, 0)
            fr[i] = fr[i]!! + 1
        }

        val f = fr.values.sortedDescending()

        var r = 0
        var s = 0

        while (s < arr.size / 2) {
            s += f[r++]
        }

        return r
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(minSetSize(intArrayOf(3, 3, 3, 3, 5, 5, 5, 2, 2, 7)))
        println(minSetSize(intArrayOf(7, 7, 7, 7, 7, 7)))
        println(minSetSize(intArrayOf(1, 9)))
        println(minSetSize(intArrayOf(1000, 1000, 3, 7)))
        println(minSetSize(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    }
}
