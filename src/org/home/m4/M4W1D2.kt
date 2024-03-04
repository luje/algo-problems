package org.home.m4

/**
 * Created by lje on 4/2/2021.
 */
object M4W1D2 {

    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val mapped = strs.map { count(it) }.toTypedArray()

        mapped.sortWith(compareBy<Pair<Int, Int>> { it.first + it.second }.thenBy { it.first }.thenBy { it.second })

        val cache = Array(m + 1) { IntArray(n + 1) { -2 } }

        return max(mapped, m, n, 0, cache);
    }

    private fun max(mapped: Array<Pair<Int, Int>>, m: Int, n: Int, start: Int, cache: Array<IntArray>): Int {
        if (m < 0 || n < 0)
            return -1

        if (start == mapped.size)
            return 0

        if (cache[m][n] != -2) {
            return cache[m][n]
        }

        cache[m][n] = kotlin.math.max(
            1 + max(mapped, m - mapped[start].first, n - mapped[start].second, start + 1, cache),
            max(mapped, m, n, start + 1, cache)
        )

        return cache[m][n]
    }


    fun count(s: String): Pair<Int, Int> {
        return s.fold(Pair(0, 0), { sum, c ->
            if (c == '0')
                Pair(sum.first + 1, sum.second)
            else
                Pair(sum.first, sum.second + 1)
        })
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(findMaxForm(arrayOf("10", "0001", "111001", "1", "0"), 5, 3))

        println(findMaxForm(arrayOf("10", "0", "1"), 1, 1))

        println(
            findMaxForm(
                arrayOf("0", "00", "1"),
                1,
                0
            )
        )

        println(
            findMaxForm(
                arrayOf("111", "1000", "1000", "1000"),
                9,
                3
            )
        )
    }
}
