package org.home.kickstart.roundk

import java.util.*
import kotlin.math.atan2
import kotlin.math.sign
import kotlin.math.sqrt

fun main() {
    val input = Scanner(System.`in`)

    val t = input.nextLine().toInt();

    for (i in 1..t) {
        val n = input.nextLine().toInt()
        val p = mutableListOf<Pair<Long, Long>>()

        for (j in 1..n) {
            val (x, y) = input.nextLine().split(" ").map { it.toLong() }

            p.add(x to y)
        }

        val (x, y) = input.nextLine().split(" ").map { it.toLong() }

        println("Case #$i: " + solve(p, x to y))
    }
}

fun solve(p: MutableList<Pair<Long, Long>>, b: Pair<Long, Long>): String {
    val c = p.map { it.first - b.first to it.second - b.second }
        .sortedBy { it.first * it.first + it.second * it.second }
        .sortedBy { atan2(it.first.toDouble(), it.second.toDouble()) }



    if (c.size < 3) {
        return "IMPOSSIBLE"
    }

    var m = Double.MAX_VALUE

    val quadrants = c.groupBy { sign(it.first.toDouble()) to sign(it.second.toDouble()) }
        .map { it.key to it.value.minByOrNull { point -> d(point, 0L to 0L) } }

    if (quadrants.count { it.second == null } > 1)
        return "IMPOSSIBLE"

    val c1 = quadrants.mapNotNull { it.second }

    for (i in 0 until c1.size - 2) {
        for (j in i + 1 until c1.size - 1) {
            for (k in j + 1 until c1.size) {
                m = minOf(d(c1[i], c1[j]) + d(c1[j], c1[k]) + d(c1[k], c1[i]), m)
            }
        }
    }

    return m.toString()
}

fun d(p1: Pair<Long, Long>, p2: Pair<Long, Long>): Double {
    return sqrt(((p1.first - p2.first) * (p1.first - p2.first) + (p1.second - p2.second) * (p1.second - p2.second)).toDouble())
}
