package org.home.m6.w1

import java.util.*

/**
 * Created by lje on 6/1/2021.
 */
object D1 {

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        return grid.indices
            .flatMap { i ->
                grid[i].indices
                    .filter { j -> grid[i][j] == 1 }
                    .map { j -> cover(grid, i, j) }
            }
            .maxOrNull() ?: 0
    }

    val directions = setOf((-1 to 0), (1 to 0), (0 to -1), (0 to 1))

    private fun cover(grid: Array<IntArray>, p: Int, q: Int): Int {
        val stack = ArrayDeque<Pair<Int, Int>>()
        var result = 0

        grid[p][q] = 0

        stack.push(p to q)

        while (!stack.isEmpty()) {
            val (i, j) = stack.pop()

            result++

            for ((x, y) in directions) {
                val x1 = i + x
                if (x1 < 0 || x1 >= grid.size) continue

                val x2 = j + y
                if (x2 < 0 || x2 >= grid[i].size) continue

                if (grid[x1][x2] == 0) continue

                grid[x1][x2] = 0

                stack.push(x1 to x2)
            }
        }

        return result
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            maxAreaOfIsland(
                arrayOf(
                    intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
                    intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
                    intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
                    intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
                )
            )
        )

        println(
            maxAreaOfIsland(
                arrayOf(
                    intArrayOf(0, 0, 0, 0, 0, 0, 0, 0)
                )
            )
        )
    }
}
