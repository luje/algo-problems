package org.home.m6.w4

/**
 * Created by lje on 6/28/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3792/
 *
 */
object D5 {
    fun countSmaller(nums: IntArray): List<Int> {
        val result = MutableList(nums.size) { 0 }
        var root: Node? = null

        for (i in nums.size - 1 downTo 0) {
            val (other, count) = add(nums[i], root, 0)

            result[i] = count
            root = other
        }

        return result
    }

    fun add(v: Int, root: Node?, countSmaller: Int): Pair<Node, Int> {
        if (root == null) {
            return Node(v) to countSmaller
        } else if (root.v < v) {
            val (other, count) = add(v, root.right, countSmaller + 1)

            root.right = other

            return root to root.c + count
        } else {
            root.c++

            val (other, count) = add(v, root.left, countSmaller)

            root.left = other

            return root to count
        }
    }

    data class Node(val v: Int, var c: Int = 0, var left: Node? = null, var right: Node? = null)

    @JvmStatic
    fun main(args: Array<String>) {
        println(countSmaller(intArrayOf(5, 2, 6, 1)))
        println(countSmaller(intArrayOf(-1)))
        println(countSmaller(intArrayOf(-1, -1)))
    }
}
