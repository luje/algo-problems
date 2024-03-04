package org.home.m6.w5

/**
 * Created by lje on 6/30/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/607/week-5-june-29th-june-30th/3797/
 *
 */
object D2 {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
        if (root.`val` == p?.`val` || root.`val` == q?.`val`) return root

        val l = lowestCommonAncestor(root.left, p, q)
        val r = lowestCommonAncestor(root.right, p, q)

        if(l != null && r == null) return l
        if(l == null && r != null) return r
        if(l != null && r != null) return root

        return null
    }

    data class TreeNode(var `val`: Int = 0, var left: TreeNode? = null, var right: TreeNode? = null)

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            lowestCommonAncestor(
                TreeNode(
                    3,
                    TreeNode(
                        5,
                        TreeNode(6),
                        TreeNode(
                            2,
                            TreeNode(7),
                            TreeNode(4)
                        )
                    ),
                    TreeNode(
                        1,
                        TreeNode(0),
                        TreeNode(8)
                    ),
                ),
                TreeNode(5),
                TreeNode(1)
            )?.`val`
        )
    }
}
