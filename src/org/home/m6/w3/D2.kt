package org.home.m6.w3

/**
 * Created by lje on 6/16/2021.
 */
object D2 {

    fun generateParenthesis(n: Int): List<String> {
        val cache = mutableMapOf(1 to mutableSetOf("()"))

        fun gen(l: Int): Set<String> {
            if (cache.containsKey(l)) return cache[l]!!

            cache[l] = mutableSetOf();
            cache[l]!!.addAll(gen(l - 1).map { "($it)" })

            for (i in 1..l / 2) {
                cache[l]!!.addAll(
                    gen(l - i)
                        .flatMap { s1 ->
                            gen(i)
                                .flatMap { s2 -> setOf(s1 + s2, s2 + s1) }
                        })
            }

            return cache[l]!!
        }

        return gen(n).toList()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(generateParenthesis(8).joinToString())
        println(generateParenthesis(4).joinToString())
        println(generateParenthesis(3).joinToString())
        println(generateParenthesis(1).joinToString())
    }
}
