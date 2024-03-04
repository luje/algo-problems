package org.home.m5.w4

/**
 * Created by lje on 5/28/2021.
 */
object D7 {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        var i = 0
        var j = 0

        var ms = 0
        var s = 0
        val set = mutableSetOf<Int>()

        while (j < nums.size) {
            val c = nums[j++]

            if (c in set) {

                while (nums[i] != c) {
                    s -= nums[i]
                    set.remove(nums[i])
                    i++
                }
                i++
            } else {
                set.add(c)

                s += c
                ms = maxOf(ms, s)
            }
        }

        return ms
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            maximumUniqueSubarray(
                intArrayOf(
                    187,
                    470,
                    25,
                    436,
                    538,
                    809,
                    441,
                    167,
                    477,
                    110,
                    275,
                    133,
                    666,
                    345,
                    411,
                    459,
                    490,
                    266,
                    987,
                    965,
                    429,
                    166,
                    809,
                    340,
                    467,
                    318,
                    125,
                    165,
                    809,
                    610,
                    31,
                    585,
                    970,
                    306,
                    42,
                    189,
                    169,
                    743,
                    78,
                    810,
                    70,
                    382,
                    367,
                    490,
                    787,
                    670,
                    476,
                    278,
                    775,
                    673,
                    299,
                    19,
                    893,
                    817,
                    971,
                    458,
                    409,
                    886,
                    434
                )
            )
        )
        println()
        println(maximumUniqueSubarray(intArrayOf(2, 4, 5, 6)))
        println()
        println(maximumUniqueSubarray(intArrayOf(4, 2, 4, 5, 6)))
        println()
        println(maximumUniqueSubarray(intArrayOf(5, 2, 1, 2, 5, 2, 1, 2, 5)))
    }
}
