package org.home.m8.w4

/**
 * Created by lje on 8/24/2021.
 *
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3917/
 *
 */
object D3 {

    fun complexNumberMultiply(num1: String, num2: String): String {
        return (CN(num1) * CN(num2)).toString()
    }

    class CN {
        val first: Int
        val second: Int

        constructor(num: String) {
            val find = Regex("(-?\\d*)\\+?(-?\\d*)i?").find(num)
            var (a, b) = find!!.destructured

            this.first = a.toInt()
            this.second = b.toInt()
        }

        constructor(first: Int, second: Int) {
            this.first = first
            this.second = second
        }

        operator fun times(other: CN): CN {
            return CN(first * other.first - second * other.second, first * other.second + second * other.first)
        }

        override fun toString(): String {
            return "${first}+${second}i"
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {

        println(CN("1+1i"))
        println(CN("1+-1i"))

        println(complexNumberMultiply("1+1i", "1+1i"))
        println(complexNumberMultiply("1+-1i", "1+-1i"))
    }
}
