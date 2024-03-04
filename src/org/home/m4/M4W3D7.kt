package org.home.m4

/**
 * Created by lje on 4/21/2021.
 *
 * https://leetcode.com/submissions/detail/483366913/?from=explore&item_id=3715
 *
 */
object M4W3D7 {

    fun minimumTotal(triangle: List<List<Int>>): Int {
        val cache = IntArray(triangle.size) { triangle[triangle.size - 1][it] }

        for (i in triangle.size - 1 downTo 1) {
            for (j in triangle[i - 1].indices)
                cache[j] = triangle[i - 1][j] + minOf(cache[j], cache[j + 1])
        }

        return cache[0]
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            minimumTotal(
                listOf(
                    listOf(2),
                    listOf(3, 4),
                    listOf(6, 5, 7),
                    listOf(4, 1, 8, 3)
                )
            )
        )
    }
}
