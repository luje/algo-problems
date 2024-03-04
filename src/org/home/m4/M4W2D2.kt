package org.home.m4

/**
 * Created by lje on 4/9/2021.
 */
object M4W2D2 {


    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        return isAlienSorted(words, indexOf(order))
    }

    private fun indexOf(order: String): (Char) -> Int {
        val result = IntArray(order.length) { -1 }

        return { c: Char ->
            val v = c - 'a'

            if (result[v] == -1)
                result[v] = order.indexOf(c)

            result[v]
        }
    }

    fun isAlienSorted(words: Array<String>, order: (Char) -> Int): Boolean {
        return (0 until words.size - 1).all { compare(order, words[it], words[it + 1]) <= 0 }
    }

    fun compare(order: (Char) -> Int, a: String, b: String): Int {
        for (i in (0 until a.length.coerceAtMost(b.length))) {
            if (a[i] == b[i]) continue
            else return order.invoke(a[i]) - order.invoke(b[i])
        }

        return a.length - b.length
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(isAlienSorted(arrayOf("hello", "hello"), "abcdefghijklmnopqrstuvwxyz"))
        println(isAlienSorted(arrayOf("hello", "leetcode"), "hlabcdefgijkmnopqrstuvwxyz"))
        println(isAlienSorted(arrayOf("word", "world", "row"), "worldabcefghijkmnpqstuvxyz"))
        println(isAlienSorted(arrayOf("apple", "app"), "abcdefghijklmnopqrstuvwxyz"))
        println(isAlienSorted(arrayOf("kuvp", "q"), "ngxlkthsjuoqcpavbfdermiywz"))
    }
}
