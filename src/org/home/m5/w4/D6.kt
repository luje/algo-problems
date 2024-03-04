package org.home.m5.w4

/**
 * Created by lje on 5/27/2021.
 */
object D6 {

    fun maxProduct(words: Array<String>): Int {
        val p = words.map { w -> w.length to toBitmap(w) }

        return p.indices
            .flatMap { i ->
                (i + 1 until p.size)
                    .map { j -> p[i] to p[j] }
            }
            .filter { (a, b) -> independent(a, b) }
            .map { (a, b) -> a.first * b.first }
            .maxOrNull() ?: 0
    }

    private fun toBitmap(w: String): Int {
        return w.fold(0, { t, c -> (1 shl (c - 'a')) or t })
    }

    private fun independent(a: Pair<Int, Int>, b: Pair<Int, Int>): Boolean {
        return a.second xor b.second == a.second + b.second
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(maxProduct(arrayOf("abcw", "baz", "foo", "bar", "xtfn", "abcdef")))
        println(maxProduct(arrayOf("a", "ab", "abc", "d", "cd", "bcd", "abcd")))
        println(maxProduct(arrayOf("a", "aa", "aaa", "aaaa")))
    }
}
