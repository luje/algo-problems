package org.home.m4

/**
 * Created by lje on 4/7/2021.
 */
object M4W1D7 {

    fun halvesAreAlike(s: String): Boolean {
        var c = 0

        for (i in 0 until s.length / 2) {
            if (s[i] in "aeiouAEIOU") c++
            if (s[s.length - i - 1] in "aeiouAEIOU") c--
        }

        return c == 0
    }


    @JvmStatic
    fun main(args: Array<String>) {
        println(halvesAreAlike("book"))
        println(halvesAreAlike("textbook"))
        println(halvesAreAlike("MerryChristmas"))
        println(halvesAreAlike("AbCdEfGh"))
        println(halvesAreAlike("book"))
    }
}
