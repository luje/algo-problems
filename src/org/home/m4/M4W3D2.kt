package org.home.m4

import java.util.*

/**
 * Created by lje on 4/16/2021.
 */
object M4W3D2 {
    fun removeDuplicates(s: String, k: Int): String {
        val rest = LinkedList<Pair<Char, Int>>()

        for (c in s) {
            if (rest.isEmpty() || rest.peek().first != c) {
                rest.push(c to 1)

                continue
            }

            val (lc, lk) = rest.pop()
            if (lc == c) {
                if (lk + 1 < k)
                    rest.push(c to lk + 1)

                continue
            }
        }

        val result = StringBuilder()
        while (!rest.isEmpty()) {
            val (c, s) = rest.removeLast()

            result.append(c.toString().repeat(s))
        }

        return result.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(removeDuplicates("abcd", 2))
        println(removeDuplicates("deeedbbcccbdaa", 3))
        println(removeDuplicates("pbbcggttciiippooaais", 2))
    }
}
