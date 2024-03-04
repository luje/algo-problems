package org.home.m5.w4

/**
 * Created by lje on 5/27/2021.
 *
 * https://leetcode.com/submissions/detail/499004555/?from=explore&item_id=3756
 *
 */
object D5 {

    fun minPartitions(n: String): Int {
        var max = '0'

        for (c in n) {
            if (c > max) max = c
            if (max == '9') return 9
        }

        return max - '0'
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("3=" + minPartitions("32"))
        println("8=" + minPartitions("82734"))
        println("9=" + minPartitions("27346209830709182346"))
    }
}
