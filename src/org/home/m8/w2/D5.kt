package org.home.m8.w2

/**
 * Created by lje on 8/12/2021.
 *
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3887/
 *
 */
object D5 {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val r = mutableMapOf<String, MutableList<String>>()
        val a = IntArray(26)

        for(s in strs) {
            for (i in a.indices) a[i] = 0
            for (c in s) a[c - 'a']++

            val kb = StringBuilder()

            for(i in a) kb.append("$i#")

            val k = kb.toString()

            r.putIfAbsent(k, mutableListOf())
            r[k]!! += s
        }

        return r.values.toList()
    }

}
