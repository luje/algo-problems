package org.home.m4

/**
 * Created by lje on 4/8/2021.
 */
object M4W2D1 {

    private val opts = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    fun letterCombinations(digits: String): List<String> {
        var result = emptyList<String>()

        for (d in digits) {
            var r1 = mutableListOf<String>()

            for (c in opts[d]!!) {
                r1.addAll(expand(result, c))
            }

            result = r1
        }

        return result
    }

    private fun expand(result: List<String>, c: Char) =
        if (result.isEmpty()) listOf(c.toString()) else result.map { it + c }

    @JvmStatic
    fun main(args: Array<String>) {
        println(letterCombinations(""))
        println(letterCombinations("2"))
        println(letterCombinations("23"))
    }
}
