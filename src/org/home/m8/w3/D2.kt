package org.home.m8.w3

/**
 * Created by lje on 8/16/2021.
 */
object D2 {

    class NumArray(val nums: IntArray) {

        var ps = IntArray(nums.size + 1);

        init {
            for (i in nums.indices) {
                ps[i + 1] = ps[i] + nums[i]
            }

        }

        fun sumRange(left: Int, right: Int): Int = ps[right + 1] - ps[left]

    }

    @JvmStatic
    fun main(args: Array<String>) {
        val n = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))

        println(n.sumRange(0, 2))
        println(n.sumRange(2, 5))
        println(n.sumRange(0, 5))
    }

}
