package org.home.m6.w2

import java.util.*

/**
 * Created by lje on 6/13/2021.
 *
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/solution/
 *
 */
object D5 {
    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        var result = 0
        var prev = 0
        var tank = startFuel

        val pq = PriorityQueue<Int>(Collections.reverseOrder())

        for (s in stations) {
            val l = s[0]
            val f = s[1]

            tank -= (l - prev)

            while (!pq.isEmpty() && tank < 0) {
                tank += pq.poll()
                result++
            }

            if(tank < 0) return -1

            pq.offer(f)
            prev = l
        }

        tank -= (target - prev)

        while (!pq.isEmpty() && tank < 0) {
            tank += pq.poll()
            result++
        }

        return if(tank < 0) -1 else result
    }

    @JvmStatic
    fun main(args: Array<String>) {

        println(
            "4 = " + minRefuelStops(
                target = 1000,
                startFuel = 299,
                stations = arrayOf(
                    intArrayOf(42, 39),
                    intArrayOf(132, 236),
                    intArrayOf(166, 142),
                    intArrayOf(434, 7),
                    intArrayOf(462, 80),
                    intArrayOf(518, 103),
                    intArrayOf(545, 209),
                    intArrayOf(656, 104),
                    intArrayOf(769, 137),
                    intArrayOf(811, 67)
                )
            )
        )

        println(
            "1 = " + minRefuelStops(
                target = 100,
                startFuel = 50,
                stations = arrayOf(intArrayOf(25, 25), intArrayOf(50, 50))
            )
        )

        println(
            "3 = " + minRefuelStops(
                target = 100,
                startFuel = 25,
                stations = arrayOf(intArrayOf(25, 25), intArrayOf(50, 25), intArrayOf(75, 25))
            )
        )

        println("0 = " + minRefuelStops(target = 1, startFuel = 1, stations = emptyArray()))

        println(
            "-1 = " +
                    minRefuelStops(target = 100, startFuel = 1, stations = arrayOf(intArrayOf(10, 100)))
        )

        println(
            "2 = " +
                    minRefuelStops(
                        target = 100,
                        startFuel = 10,
                        stations = arrayOf(
                            intArrayOf(10, 60),
                            intArrayOf(20, 30),
                            intArrayOf(30, 30),
                            intArrayOf(60, 40)
                        )
                    )
        )
    }
}
