package org.home.m5.w3

import java.util.*

/**
 * Created by lje on 5/20/2021.
 */
object D6 {

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val q = LinkedList<TreeNode?>()
        val levels = LinkedList<List<Int>>()

        q.add(root)

        while (!q.isEmpty()) {
            val level = LinkedList<Int>()

            for (i in 0 until q.size) {
                val c = q.poll()!!

                level.add(c.`val`)

                c.left?.let(q::add)
                c.right?.let(q::add)
            }

            levels.add(level)
        }

        return levels
    }

    data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    @JvmStatic
    fun main(args: Array<String>) {
//        println(levelOrder(null))

//        println(
//            levelOrder(TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7))))
//                .map { "[" + it.joinToString() + "]" }
//                .joinToString()
//        )

        println(
            levelOrder(
                TreeNode(
                    0,
                    TreeNode(
                        2,
                        TreeNode(
                            1,
                            TreeNode(5),
                            TreeNode(1)
                        )
                    ),
                    TreeNode(
                        4,
                        TreeNode(
                            3,
                            TreeNode(6)
                        ),
                        TreeNode(
                            -1,
                            TreeNode(8)
                        )
                    )
                )
            )
                .map { "[" + it.joinToString() + "]" }
                .joinToString()
        )
    }
}
