package org.home.m4

/**
 * Created by lje on 4/18/2021.
 *
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3712/
 *
 */
object M4W3D4 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var s: ListNode? = head
        var p: ListNode? = head
        var i = 0

        while (p != null) {
            if (i++ > n) {
                s = s!!.next
            }

            p = p.next
        }

        if (i == n) return head!!.next

        s!!.next = s!!.next!!.next

        return head
    }

    @JvmStatic
    fun main(args: Array<String>) {
        print(removeNthFromEnd(ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))), 2))
        print(removeNthFromEnd(ListNode(1), 1))
        print(removeNthFromEnd(ListNode(1, ListNode(2)), 1))
        print(removeNthFromEnd(ListNode(1, ListNode(2)), 2))
    }

    fun print(head: ListNode?) {
        var p = head

        while (p != null) {
            print(p.`val`)
            print(" ")

            p = p.next
        }

        println()
    }

    data class ListNode(var `val`: Int, var next: ListNode? = null)
}
