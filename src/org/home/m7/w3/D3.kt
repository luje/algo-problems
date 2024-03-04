package org.home.m7.w3

/**
 * Created by lje on 7/17/2021.
 *
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3817/
 *
 */
object D3 {

    fun threeEqualParts(arr: IntArray): IntArray {
        val S = arr.count { it == 1 }

        if (S % 3 != 0) return intArrayOf(-1, -1)
        val t = S / 3
        if (t == 0) return intArrayOf(0, arr.size - 1)

        var s = 0
        var i1 = -1
        var j1 = -1
        var i2 = -1
        var j2 = -1
        var i3 = -1
        var j3 = -1

        for (i in arr.indices) {
            if (arr[i] == 1) {
                s++

                if (s == 1) i1 = i
                if (s == t) j1 = i
                if (s == t + 1) i2 = i
                if (s == 2 * t) j2 = i
                if (s == 2 * t + 1) i3 = i
                if (s == 3 * t) j3 = i
            }
        }

        for (i in i3 until arr.size) {
            val q = i - i3

            if(arr[i1 + q] != arr[i2 + q] ||
                arr[i2 + q] != arr[i3 + q] ||
                arr[i1 + q] != arr[i3 + q]) {
                return intArrayOf(-1, -1)
            }
        }

        val x = i2 - j1 - 1
        val y = i3 - j2 - 1
        val z = arr.size - j3 - 1

        return if (x < z || y < z) intArrayOf(-1, -1) else intArrayOf(j1 + z, j2 + z + 1)
    }


    fun threeEqualParts2(arr: IntArray): IntArray {

        var i = 0
        while (i + 1 < arr.size - 2 && arr[i] == 0) i++

        for (s in 1 until arr.size / 3 + 1) {

            var j = i + s
            while (j + s < arr.size - 1 && arr[j] == 0) j++

            var k = j + s
            while (k + s < arr.size && arr[k] == 0) k++

            if (k + s < arr.size) continue
            if (k + s > arr.size) break

            var found = true
            for (q in 0 until s) {
                if (arr[i + q] != arr[j + q] ||
                    arr[j + q] != arr[k + q] ||
                    arr[i + q] != arr[k + q]
                ) {
                    found = false

                    break
                }
            }

            if (found)
                return intArrayOf(i + s - 1, j + s)
        }

        return intArrayOf(-1, -1)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(threeEqualParts(intArrayOf(0, 1, 1, 0, 0, 0, 1, 1, 0, 1)).joinToString())
        println(threeEqualParts(intArrayOf(0, 0, 0, 0, 0)).joinToString())
        println(threeEqualParts(intArrayOf(1, 0, 1, 0, 1)).joinToString())
        println(threeEqualParts(intArrayOf(1, 1, 0, 1, 1)).joinToString())
        println(threeEqualParts(intArrayOf(1, 1, 0, 0, 1)).joinToString())

        println("-------------")

        println(threeEqualParts2(intArrayOf(0, 1, 1, 0, 0, 0, 1, 1, 0, 1)).joinToString())
        println(threeEqualParts2(intArrayOf(0, 0, 0, 0, 0)).joinToString())
        println(threeEqualParts2(intArrayOf(1, 0, 1, 0, 1)).joinToString())
        println(threeEqualParts2(intArrayOf(1, 1, 0, 1, 1)).joinToString())
        println(threeEqualParts2(intArrayOf(1, 1, 0, 0, 1)).joinToString())
    }
}
