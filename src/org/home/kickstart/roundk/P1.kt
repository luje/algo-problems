package org.home.kickstart.roundk

import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)

    val t = input.nextLine().toInt();

    for (i in 1..t) {
        val n = input.nextLine().toInt()
        val b = input.nextLine()!!.map { it == '1' }.toBooleanArray()

        println("Case #$i: " + solve(n, b))
    }
}

private fun solve(n: Int, b: BooleanArray): Long {

    val l = LongArray(b.size)
    var r = LongArray(b.size)

    var k = -1L
    for (i in 0 until b.size) {
        if (b[i]) k = i.toLong()

        if (k < 0) l[i] = n.toLong()
        else l[i] = i - k
    }

    k = -1L
    for (i in b.size - 1 downTo 0) {
        if (b[i]) k = i.toLong()

        if (k < 0) r[i] = n.toLong()
        else r[i] = k - i
    }

    return l.zip(r).map { minOf(it.first, it.second) }.sum()
}
