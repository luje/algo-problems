package org.home.m4

/**
 * Created by lje on 4/22/2021.
 *
 * https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3717/
 *
 */
object M4W4D1 {

    fun leastBricks(wall: List<List<Int>>): Int {
        val freq = hashMapOf<Int, Int>()

        for (line in wall) {
            var s = 0

            for (e in 0 until line.size - 1) {
                s += line[e]

                freq[s] = (freq[s] ?: 0) + 1
            }
        }

        val maxEntry = freq.entries
            .maxByOrNull { (k, v) -> v }

        return wall.size - (maxEntry?.value ?: 0)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            leastBricks(
                listOf(
                    listOf(1, 1, 1),
                    listOf(1, 1, 1),
                    listOf(1, 1, 1),
                )
            )
        )

        println(
            leastBricks(
                listOf(
                    listOf(1, 1),
                    listOf(2),
                    listOf(1, 1),
                )
            )
        )

        println(
            leastBricks(
                listOf(
                    listOf(1),
                    listOf(1),
                    listOf(1),
                )
            )
        )

        println(
            leastBricks(
                listOf(
                    listOf(1, 2, 2, 1),
                    listOf(3, 1, 2),
                    listOf(1, 3, 2),
                    listOf(2, 4),
                    listOf(3, 1, 2),
                    listOf(1, 3, 1, 1)
                )
            )
        )
    }
}
