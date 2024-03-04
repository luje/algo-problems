package org.home.m7.w2

/**
 * Created by lje on 7/12/2021.
 */
object D5 {
    fun isIsomorphic(s: String, t: String): Boolean {
        s.mapIndexed {i, s -> t[i]}
        val d = mutableMapOf<Char, Char>()
        val v = mutableSetOf<Char>()

        for (i in s.indices) {
            val a = s[i]
            val b = t[i]

            if (b !in v) {
                v.add(b)
                d.putIfAbsent(a, b)
            }

            if (d[a] != b)
                return false
        }

        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(isIsomorphic("bacd", "baba"))
        println(isIsomorphic("egg", "add"))
        println(isIsomorphic("foo", "bar"))
        println(isIsomorphic("paper", "title"))
    }
}
