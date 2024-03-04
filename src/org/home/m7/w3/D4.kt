package org.home.m7.w3

import org.home.m6.w4.D2

/**
 * Created by lje on 7/18/2021.
 */
object D4 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var i = 0
        var first = head
        var next = head

        var lists = mutableListOf<ListNode>()

        while (i < k && next != null) {
            i++

            if(i == k && next != null) {
                lists.add(first!!)

                first = next.next
                next = next.next

            }

            next = next!!.next
        }

        return head
    }

    fun reverse(head: D2.ListNode?): D2.ListNode? {
        var prev: D2.ListNode? = null
        var current = head

        while (current != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }

        return prev
    }

    data class ListNode(var `val`: Int, var next: ListNode? = null)

    fun toLL(a: List<Int>): ListNode? {
        return if (a.isEmpty()) null else ListNode(a.first(), toLL(a.takeLast(a.size - 1)))
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(reverseKGroup(toLL(listOf(1, 2, 3, 4, 5)), 2))
        println(reverseKGroup(toLL(listOf(1, 2, 3, 4, 5)), 3))
        println(reverseKGroup(toLL(listOf(1, 2, 3, 4, 5)), 1))
        println(reverseKGroup(toLL(listOf(1)), 1))
    }
}
