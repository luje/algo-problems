package org.home.m5.w3

/**
 * Created by lje on 5/19/2021.
 */
object D4 {
    fun findDuplicate(paths: Array<String>): List<List<String>> {
        return paths
            .flatMap { fromString(it) }
            .groupBy { it.content }
            .filter { it.value.size > 1 }
            .values.map { it.map(F::fullPath) }
    }

    fun fromString(s: String): List<F> {
        val split = s.split(" ")

        val folder = split[0]

        return (1 until split.size)
            .map { split[it] }
            .map { fname ->
                val i = fname.indexOf('(')
                val j = fname.indexOf(')')

                F(folder, fname.substring(0, i), fname.substring(i, j))
            }
    }

    data class F(val path: String, val name: String, val content: String) {
        fun fullPath() = "$path/$name"
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            findDuplicate(
                arrayOf(
                    "root/a 1.txt(abcd) 2.txt(efgh)",
                    "root/c 3.txt(abcd)",
                    "root/c/d 4.txt(efgh)",
                    "root 4.txt(efgh)"
                )
            )
        )

        println(
            findDuplicate(
                arrayOf(
                    "root/a 1.txt(abcd) 2.txt(efgh)",
                    "root/c 3.txt(abcd)",
                    "root/c/d 4.txt(efgh)"
                )
            )
        )
    }
}
