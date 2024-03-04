package org.home.m6.w4

/**
 * Created by lje on 6/23/2021.
 *
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3789/
 *
 */
object D2 {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {

        var c = 1
        var start = head
        var prev: ListNode? = null
        var current = head

        while (c < left && current != null) {
            prev = current
            current = current.next
            c++
        }

        prev?.next = null
        var rev = current

        while (c < right && current != null) {
            current = current.next
            c++
        }

        var end = current!!.next
        current.next = null

        var revd = reverse(rev)
        if(prev == null) start = revd

        rev?.next = end
        prev?.next = revd

        return start
    }

    fun reverse(head: ListNode?): ListNode? {
        var prev: ListNode? = null
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

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            reverseBetween(
                ListNode(3, ListNode(5)), left = 1, right = 1
            ).toString() + "\n----\n"
        )

        println(
            reverseBetween(
                ListNode(3, ListNode(5)), left = 1, right = 2
            ).toString() + "\n----\n"
        )

        println(
            reverseBetween(
                ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))), left = 2, right = 4
            ).toString() + "\n----\n"
        )

        println(
            reverseBetween(
                ListNode(5), left = 1, right = 1
            ).toString() + "\n----\n"
        )
    }
}
