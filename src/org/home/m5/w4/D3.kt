package org.home.m5.w4

/**
 * Created by lje on 5/24/2021.
 */
object D3 {

    fun toLowerCase(s: String): String {
        val c = ('a' - 'A')
        val sb = StringBuilder()

        for (e in s)
            sb.append(
                if (e in 'A'..'Z') e + c
                else e
            )

        return sb.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println('A'.toInt())
        println('a'.toInt())

        println(toLowerCase("Hello"))
        println(toLowerCase("here"))
        println(toLowerCase("LOVELY"))
    }
}
