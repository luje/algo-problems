package org.home.m6.w1

/**
 * Created by lje on 6/3/2021.
 */
object D3 {

    private val MOD = 1_000_000_007

    fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
        horizontalCuts.sort()
        verticalCuts.sort()

        val a = maxd(h, horizontalCuts)
        val b = maxd(w, verticalCuts)

        return (a.toLong() * b.toLong()).rem(MOD).toInt()
    }

    private fun maxd(h: Int, cuts: IntArray): Int {
        var m = maxOf(cuts[0], h - cuts.last())

        for(i in 1 until cuts.size) {
            m = maxOf(m, cuts[i] - cuts[i - 1])
        }

        return m
    }


    @JvmStatic
    fun main(args: Array<String>) {
//        println("4 = " + maxArea(h = 5, w = 4, horizontalCuts = intArrayOf(1, 2, 4), verticalCuts = intArrayOf(1, 3)))
//        println("6 = " + maxArea(h = 5, w = 4, horizontalCuts = intArrayOf(3, 1), verticalCuts = intArrayOf(1)))
//        println("9 = " + maxArea(h = 5, w = 4, horizontalCuts = intArrayOf(3), verticalCuts = intArrayOf(3)))
        println(
            "9 = " + maxArea(
                h = MOD,
                w = MOD,
                horizontalCuts = intArrayOf(MOD / 3),
                verticalCuts = intArrayOf(MOD / 3)
            )
        )
    }
}
