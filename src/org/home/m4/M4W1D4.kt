package org.home.m4

/**
 * Created by lje on 4/4/2021.
 *
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/593/week-1-april-1st-april-7th/3696/
 *
 */
object M4W1D4 {
    class MyCircularQueue(val k: Int) {

        private val b = IntArray(k)
        private var f = 0
        private var r = 0
        private var size = 0

        fun enQueue(value: Int): Boolean {

            if (isFull())
                return false

            size++
            b[r] = value
            r = (r + 1) % k

            return true
        }

        fun deQueue(): Boolean {
            if (isEmpty())
                return false

            size--
            f = (f + 1) % k

            return true
        }

        fun Front(): Int {
            return if (isEmpty()) -1 else b[f]
        }

        fun Rear(): Int {
            return if (isEmpty()) -1 else b[(k + r - 1) % k]
        }

        fun isEmpty(): Boolean {
            return size == 0
        }

        fun isFull(): Boolean {
            return size == k
        }

    }

    @JvmStatic
    fun main(args: Array<String>) {
        val queue = MyCircularQueue(3)

        println(queue.enQueue(1))
        println(queue.enQueue(2))
        println(queue.enQueue(3))
        println(queue.enQueue(4))
        println(queue.Rear())
        println(queue.isFull())
        println(queue.deQueue())
        println(queue.enQueue(4))
        println(queue.Rear())

    }
}
