package org.home.kickstart.roundk

import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    val t = input.nextLine().toInt()

    for (i in 1..t) {
        val spec = input.nextLine()
        val (d, n, k) = spec.split(" ").map { it.toInt() }
        val r = mutableListOf<Triple<Int, Int, Int>>()

        for (j in 0 until n) {
            val ride = input.nextLine()
            val (h, s, e) = ride.split(" ").map { it.toInt() }

            r.add(Triple(h, s, e))
        }

        println("Case #$i: " + solve(k, r))
    }
}

private fun solve(k: Int, r: MutableList<Triple<Int, Int, Int>>): Int {
    val days = r.flatMap { listOf(it.second, it.third) }.distinct().sorted();
    var maxH = 0

    for (di in days) {
        r.removeIf { di > it.third }
        r.sortWith(compareBy { it.second })

        var max = r.takeWhile { di in it.second..it.third }
            .sortedByDescending { it.first }
            .take(k)
            .sumOf { it.first }

        maxH = maxOf(max, maxH)
    }

    return maxH
}

