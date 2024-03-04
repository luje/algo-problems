package org.home.m6.w2

/**
 * Created by lje on 6/8/2021.
 *
 * https://leetcode.com/submissions/detail/505094520/?from=explore&item_id=3772
 *
 */
object D1 {

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        var rootIndexP = 0

        fun buildTree(preorder: IntArray,
                      inorder: IntArray, start: Int, end: Int, ci: Map<Int, Int>): TreeNode? {
            if(rootIndexP >= preorder.size || start >= end) return null

            val root = preorder[rootIndexP++]
            val rootIndex = ci[root] ?: -1

            return TreeNode(
                root,
                buildTree(preorder, inorder, start, rootIndex, ci),
                buildTree(preorder, inorder, rootIndex + 1, end, ci)
            )
        }

        return buildTree(preorder, inorder, 0, inorder.size, inorder.mapIndexed { i, v -> v to i }.toMap())
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(buildTree(preorder = intArrayOf(1, 2), inorder = intArrayOf(2, 1)))
        println(buildTree(preorder = intArrayOf(3, 9, 20, 15, 7), inorder = intArrayOf(9, 3, 15, 20, 7)))
        println(buildTree(preorder = intArrayOf(-1), inorder = intArrayOf(-1)))
    }

    data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)
}
