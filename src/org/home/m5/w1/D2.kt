package org.home.m5.w1

/**
 * Created by lje on 5/2/2021.
 */
object D2 {
    fun scheduleCourse(courses: Array<IntArray>): Int {
        var dl = courses.sortBy { it[1] }



        return 0
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            scheduleCourse(
                arrayOf(
                    intArrayOf(100, 200),
                    intArrayOf(200, 1300),
                    intArrayOf(1000, 1250),
                    intArrayOf(2000, 3200)
                )
            )
        )

        println(
            scheduleCourse(
                arrayOf(
                    intArrayOf(100, 200)
                )
            )
        )

        println(
            scheduleCourse(
                arrayOf(
                    intArrayOf(3, 2),
                    intArrayOf(4, 3),
                )
            )
        )
    }
}
