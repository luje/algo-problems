package org.home.m5.w1

/**
 * Created by lje on 5/1/2021.
 */
object D1 {

    class WordFilter(words: Array<String>) {

        private val root: Node = Node()

        init {
            words.forEachIndexed { i, w ->
                expand(w).forEach { index(i, it) }
            }
        }

        private fun expand(w: String): List<String> =
            (0..w.length)
                .reversed()
                .map { w.substring(it, w.length) + "#" + w }

        private fun index(index: Int, word: String) {
            var r = root

            for (c in word) {
                r = r.add(c, index)
            }
        }

        fun f(prefix: String, suffix: String): Int {
            val v = "$suffix#$prefix"
            var r: Node? = root
            var c = 0

            while (r != null && c < v.length) {
                r = r.children[v[c++]]
            }

            return r?.indexes?.last() ?: -1
        }

        data class Node(
            val children: MutableMap<Char, Node> = mutableMapOf(),
            val indexes: MutableList<Int> = mutableListOf()
        ) {
            fun add(c: Char, index: Int): Node {
                children.putIfAbsent(c, Node())
                val node = children[c]!!

                node.indexes.add(index)

                return node
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val wordFilter = WordFilter(
            arrayOf(
                "cabaabaaaa",
                "ccbcababac",
                "bacaabccba",
                "bcbbcbacaa",
                "abcaccbcaa",
                "accabaccaa",
                "cabcbbbcca",
                "ababccabcb",
                "caccbbcbab",
                "bccbacbcba"
            )
        )

        println(wordFilter.f("bccbacbcba","a"))
        println(wordFilter.f("ab","abcaccbcaa"))
        println(wordFilter.f("a","aa"))
        println(wordFilter.f("cabaaba","abaaaa"))
        println(wordFilter.f("cacc","accbbcbab"))
        println(wordFilter.f("ccbcab","bac"))
        println(wordFilter.f("bac","cba"))
        println(wordFilter.f("ac","accabaccaa"))
        println(wordFilter.f("bcbb","aa"))
        println(wordFilter.f("ccbca","cbcababac"))
    }

}
