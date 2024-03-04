package org.home.m4

import java.util.*

/**
 * Created by lje on 4/20/2021.
 */
object M4W3D6 {

    fun preorder(root: Node?): List<Int> {
        if (root == null)
            return emptyList()

        val result = mutableListOf<Int>()
        val stack = Stack<Node?>()

        stack.push(root)

        while (!stack.isEmpty()) {
            val current = stack.pop() ?: continue

            result.add(current.`val`)

            if(current.children == null) continue

            for (node in current.children.reversed()) {
                stack.push(node)
            }
        }

        return result
    }


    @JvmStatic
    fun main(args: Array<String>) {

    }

    data class Node(var `val`: Int, var children: List<Node?> = listOf())
}
