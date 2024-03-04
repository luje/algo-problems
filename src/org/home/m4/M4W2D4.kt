package org.home.m4

import java.util.*

/**
 * Created by lje on 4/11/2021.
 *
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3704/
 *
 */
object M4W2D4 {

    fun deepestLeavesSum(root: TreeNode?): Int {
        if (root == null) return 0

        var deepest = 0
        var sum = 0

        val stack = Stack<Pair<TreeNode?, Int>>()

        stack.push(root to 0)

        while (!stack.isEmpty()) {
            val currentPair = stack.pop()
            val current = currentPair.first ?: continue
            val currentLevel = currentPair.second

            if (currentLevel == deepest) {
                sum += current.`val`
            }

            if (currentLevel > deepest) {
                sum = current.`val`
                deepest = currentLevel
            }

            stack.push(current.left to (currentLevel + 1))
            stack.push(current.right to (currentLevel + 1))
        }

        return sum
    }

    data class TreeNode(
        var `val`: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            deepestLeavesSum(
                TreeNode(
                    1,
                    left = TreeNode(
                        2,
                        left = TreeNode(
                            4,
                            left = TreeNode(7)
                        ),
                        right = TreeNode(5)
                    ),
                    right = TreeNode(
                        3,
                        right = TreeNode(
                            6,
                            right = TreeNode(8)
                        )
                    )
                )
            )
        )
    }
}
