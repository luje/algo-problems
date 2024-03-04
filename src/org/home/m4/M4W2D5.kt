package org.home.m4

import java.util.*

/**
 * Created by lje on 4/12/2021.
 *
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3705/
 *
 */
object M4W2D5 {
    fun constructArray(n: Int, k: Int): IntArray {
        val l = mutableListOf<Int>()
        val queue = LinkedList<Int>()

        queue.addAll((0 until n).map { it + 1 })

        for (i in 1 until k) {
            l.add(
                if (i % 2 == 1)
                    queue.pollLast()
                else
                    queue.pollFirst()
            )
        }


        if (k % 2 == 1)
            queue.reverse()

        l.addAll(queue)

        return l.toIntArray()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(constructArray(3, 1).joinToString())
        println(constructArray(3, 2).joinToString())
        println(constructArray(10, 9).joinToString())
        println(constructArray(10, 8).joinToString())
    }
}
