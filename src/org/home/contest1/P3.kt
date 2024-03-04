package org.home.contest1

/**
 * Created by lje on 6/28/2021.
 */
object P3 {
    fun wonderfulSubstrings(word: String): Long {
        val count = mutableMapOf(0 to 1)
        var r = 0L
        var current = 0

        for (c in word.map { it - 'a' }) {
            current = current xor (1 shl c)
            r += count[current] ?: 0

            count[current] = count[current]?.plus(1) ?: 1

            for (j in 0 until 10) {
                val delta = current xor (1 shl j)
                r += count[delta] ?: 0
            }
        }

        return r
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(wonderfulSubstrings("aba"))
        println(wonderfulSubstrings("aabb"))
        println(wonderfulSubstrings("he"))
    }
}
