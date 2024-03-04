package org.home.m4

/**
 * Created by lje on 4/1/2021.
 */
object M4W1D1 {
    class ListNode(var `val`: Int, var next: ListNode?)

    fun isPalindrome(head: ListNode?): Boolean {
        var n = 0
        var first = head

        while (first != null) {
            first = first.next
            n++
        }

        var i = 0
        var mid = head

        while (i < n / 2 && mid != null) {
            mid = mid.next
            i++
        }

        var next: ListNode? = null
        var prev: ListNode? = null
        var current = mid

        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }

        var n1 = head
        var n2 = prev

        while(n1 != null && n2 != null) {
            if(n1.`val` != n2.`val`)
                return false

            n1 = n1.next
            n2 = n2.next
        }

        return true;
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            isPalindrome(
                ListNode(1, ListNode(2, ListNode(2, ListNode(1, null))))
            )
        )

        println(
            isPalindrome(
                ListNode(1, ListNode(2, ListNode(3, ListNode(2, ListNode(1, null)))))
            )
        )

        println(
            isPalindrome(
                ListNode(1, ListNode(3, ListNode(3, ListNode(2, ListNode(1, null)))))
            )
        )

        println(
            isPalindrome(
                ListNode(1, ListNode(2, null))
            )
        )
    }
}
