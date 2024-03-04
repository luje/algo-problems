package org.home.m6.w1

/**
 * Created by lje on 6/6/2021.
 */
object D6 {
    fun longestConsecutive(nums: IntArray): Int {
        val m = mutableMapOf<Int, Node>()

        for (n in nums) {
            if (m.containsKey(n)) continue

            m[n] = Node(
                prev = m[n - 1],
                next = m[n + 1]
            )

            if (m.containsKey(n - 1)) m[n - 1]!!.next = m[n]
            if (m.containsKey(n + 1)) m[n + 1]!!.prev = m[n]
        }

        return m.values.filter { it.prev == null }.map { it.len() }.maxOrNull() ?: 0
    }

    data class Node(var prev: Node? = null, var next: Node? = null) {
        fun len(): Int = 1 + (next?.len() ?: 0)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("4 = " + longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
        println("9 = " + longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
        println("5 = " + longestConsecutive(intArrayOf(4, 5, 1, 3, 2)))
    }
}
