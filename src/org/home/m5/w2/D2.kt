package org.home.m5.w2

import java.io.InputStreamReader

/**
 * Created by lje on 5/9/2021.
 */
object D2 {

    fun isPossible(target: IntArray): Boolean {
        if (target[0] != 1 && target.size == 1) return false

        val a = target.map { it.toLong() }.sortedDescending().toLongArray()
        var s: Long = a.sum()

        while (a[0] > 1) {

            if (s - a[0] == 1L) return true
            if (a[0] <= s - a[0]) return false

            val v = a[0]
            a[0] = a[0] % (s - a[0])
            s -= v - a[0]

            if (a[0] < 1) return false

            reorder(a)

            if (a[0] == 1L) return true
        }

        return true
    }

    private fun reorder(target: LongArray) {
        var i = 0
        while (i + 1 < target.size && target[i] < target[i + 1]) {
            val a = target[i]
            target[i] = target[i + 1]
            target[i + 1] = a
            i++
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            isPossible(
                InputStreamReader(D2.javaClass.getResourceAsStream("/org/home/m5/w2/d2.large.in")).readText().split(",")
                    .map { it.trim().toInt() }.toIntArray()
            )
        )

        println(isPossible(intArrayOf(1, 49, 11, 1, 25, 1, 7))) //false
//        println(isPossible(intArrayOf(2)))
//        println(isPossible(intArrayOf(1, 1000000000)))
//        println(isPossible(intArrayOf(8, 5)))
//        println(isPossible(intArrayOf(1, 13, 4, 7)))
//        println(isPossible(intArrayOf(9, 3, 5)))
//        println(isPossible(intArrayOf(13, 4, 7, 26)))
//        println(isPossible(intArrayOf(1, 1, 1, 2)))
    }
}
