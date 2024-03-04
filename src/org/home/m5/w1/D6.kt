package org.home.m5.w1

/**
 * Created by lje on 5/6/2021.
 */
object D6 {
    data class ListNode(var `val`: Int, val next: ListNode? = null)

    data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

    var h: ListNode? = null

    fun sortedListToBST(head: ListNode?): TreeNode? {
        var n = 0
        var c = head

        while (c != null) {
            c = c.next
            n++
        }
        
        h = head

        return sortedListToBST(n)
    }

    private fun sortedListToBST(n: Int): TreeNode? {
        if (n <= 0) return null

        val left = sortedListToBST(n / 2)

        val result = TreeNode(h!!.`val`)

        h = h!!.next
        result.left = left
        result.right = sortedListToBST(n - n / 2 - 1)

        return result
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(sortedListToBST(ListNode(-10, ListNode(-3, ListNode(0, ListNode(5, ListNode(9)))))))
    }
}
