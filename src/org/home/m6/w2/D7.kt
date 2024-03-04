package org.home.m6.w2

/**
 * Created by lje on 6/14/2021.
 */
object D7 {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {

        boxTypes.sortWith(compareByDescending { it[1] })

        var r = 0
        var c = 0

        for (bt in boxTypes) {
            val bs = minOf(bt[0], truckSize - c)
            val bc = bt[1]

            if(bs == 0) break

            r += bs * bc
            c += bs
        }

        return r
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            "8 = " +
                    maximumUnits(
                        boxTypes = arrayOf(
                            intArrayOf(1, 3),
                            intArrayOf(5, 5),
                            intArrayOf(2, 5),
                            intArrayOf(4, 2),
                            intArrayOf(4, 1),
                            intArrayOf(3, 1),
                            intArrayOf(2, 2),
                            intArrayOf(1, 3),
                            intArrayOf(2, 5),
                            intArrayOf(3, 2)
                        ),
                        truckSize = 35
                    )
        )

        println(
            "8 = " +
                    maximumUnits(
                        boxTypes = arrayOf(intArrayOf(1, 3), intArrayOf(2, 2), intArrayOf(3, 1)),
                        truckSize = 4
                    )
        )

        println(
            "91 = " +
                    maximumUnits(
                        boxTypes = arrayOf(
                            intArrayOf(5, 10),
                            intArrayOf(2, 5),
                            intArrayOf(4, 7),
                            intArrayOf(3, 9)
                        ), truckSize = 10
                    )
        )
    }
}
