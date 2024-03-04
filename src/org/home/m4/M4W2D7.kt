package org.home.m4

/**
 * Created by lje on 4/14/2021.
 *
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3707/
 *
 */
object M4W2D7 {

    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * */
    data class ListNode(var `val`: Int, var next: ListNode? = null)

    fun partition(head: ListNode?, x: Int): ListNode? {

        var first: ListNode? = null
        var second: ListNode? = head

        while (second != null && second!!.`val` < x) {
            first = second
            second = second.next
        }

        var insertionPoint = first
        var insertionPointNext = if (insertionPoint == null) head else insertionPoint.next
        var result = head

        while (second != null) {
            if (second.`val` < x) {
                first!!.next = second.next

                if (insertionPoint != null)
                    insertionPoint!!.next = second
                else
                    result = second

                second.next = insertionPointNext
                insertionPoint = second
            }

            first = second
            second = second.next
        }

        return result
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var head: ListNode? = ListNode(1, ListNode(4, ListNode(3, ListNode(2, ListNode(5, ListNode(2))))))
//        var head: ListNode? = ListNode(2, ListNode(1))

        head = partition(head, 3)

        while (head != null) {
            println(head.`val`)

            head = head.next
        }
    }

}
