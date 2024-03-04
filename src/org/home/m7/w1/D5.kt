package org.home.m7.w1

/**
 * Created by lje on 7/5/2021.
 */
object D5 {

    fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        val m = mat.size
        val n = mat.first().size

        if (m * n != r * c) return mat

        return Array(r) { i ->
            IntArray(c) { j ->
                mat[(i * c + j) / n][(i * c + j) % n]
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            matrixReshape(arrayOf(intArrayOf(1, 2, 3, 4)), 2, 2)
                .map { it.joinToString() }
                .joinToString("\n")
        )

        println()

        println(
            matrixReshape(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 4, 1)
                .map { it.joinToString() }
                .joinToString("\n")
        )

        println()

        println(
            matrixReshape(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 1, 4)
                .map { it.joinToString() }
                .joinToString("\n")
        )

        println()

        println(
            matrixReshape(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 2, 4)
                .map { it.joinToString() }
                .joinToString("\n")
        )
    }
}
