package org.home.m3

/**
 * Created by lje on 3/30/2021.
 *
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/592/week-5-march-29th-march-31st/3690/
 *
 */
object M3W5D30 {

    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        envelopes.sortWith(
            compareByDescending<IntArray> { it[0] } .thenByDescending {it[1]}
        )

        val maxes = IntArray(envelopes.size)

        return (envelopes.indices)
            .map { max(envelopes, maxes, it) }
            .maxOrNull()?:0
    }

    private fun max(e: Array<IntArray>, maxes: IntArray, i: Int): Int {
        if(maxes[i] != 0)
            return maxes[i]

        var max = 1;

        for (j in i + 1 until e.size) {
            if(fits(e[i], e[j])) {
                val v = max(e, maxes, j) + 1

                if(max < v)
                    max = v
            }
        }

        maxes[i] = max

        return max;
    }

    private fun fits(a: IntArray, b: IntArray): Boolean {
        return a[0] > b[0] && a[1] > b[1];
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            maxEnvelopes(
                arrayOf(
                    intArrayOf(5, 4),
                    intArrayOf(6, 4),
                    intArrayOf(6, 7),
                    intArrayOf(2, 3),
                )
            )
        );

        println(
            maxEnvelopes(
                arrayOf(
                    intArrayOf(10, 8),
                    intArrayOf(1, 12),
                    intArrayOf(6, 15),
                    intArrayOf(2, 18),
                )
            )
        );

        println(
            maxEnvelopes(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 1),
                    intArrayOf(1, 1),
                )
            )
        );

        println(
            maxEnvelopes(
                arrayOf(
                    intArrayOf(2, 100),
                    intArrayOf(3, 200),
                    intArrayOf(4, 300),
                    intArrayOf(5, 500),
                    intArrayOf(5, 400),
                    intArrayOf(5, 250),
                    intArrayOf(6, 370),
                    intArrayOf(6, 360),
                    intArrayOf(7, 380),
                )
            )
        );
    }
}
