package org.home.m5.w3

/**
 * Created by lje on 5/17/2021.
 *
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3746/
 *
 */
object D3 {
    fun longestStrChain(words: Array<String>): Int {

        val grouped = words.mapIndexed { index, s -> index to s }.groupBy { it.second.length }.toSortedMap()

        val flattened = grouped.values.flatten().reversed()
        val dp = IntArray(words.size)

        for (f in flattened) {
            val potentials = grouped[f.second.length + 1]

            if (potentials == null) {
                dp[f.first] = 1
                continue
            }

            dp[f.first] =
                1 + (potentials.filter { isPredecessor(f.second, it.second) }.map { dp[it.first] }.maxOrNull() ?: 0)
        }

        return dp.maxOrNull() ?: 1
    }

    private fun isPredecessor(a: String, b: String): Boolean {
        if (a.length + 1 != b.length) return false

        var i = 0
        var j = 0
        while (i < a.length && j < b.length) {
            if (a[i] != b[j]) break
            i++
            j++
        }
        j++
        while (i < a.length && j < b.length) if (a[i++] != b[j++]) return false

        return true
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(isPredecessor("x", "pu"))
        println(isPredecessor("ab", "bac"))
        println(isPredecessor("a", "ba"))
        println(isPredecessor("xb", "xbc"))
        println(isPredecessor("pcxbcf", "pcxbc"))
        println(isPredecessor("pcxbc", "pcxbcf"))
        println(isPredecessor("pcabc", "pcxbcf"))
        println(isPredecessor("pcabc", "pcxbcf"))

//        println(longestStrChain(arrayOf("a", "b", "ba", "bca", "bda", "bdca")))
//        println(longestStrChain(arrayOf("xbc", "pcxbcf", "xb", "cxbc", "pcxbc")))
//        println(longestStrChain(arrayOf("a", "b", "ab", "bac")))
        println(
            longestStrChain(
                arrayOf(
                    "qyssedya",
                    "pabouk",
                    "mjwdrbqwp",
                    "vylodpmwp",
                    "nfyqeowa",
                    "pu",
                    "paboukc",
                    "qssedya",
                    "lopmw",
                    "nfyqowa",
                    "vlodpmw",
                    "mwdrqwp",
                    "opmw",
                    "qsda",
                    "neo",
                    "qyssedhyac",
                    "pmw",
                    "lodpmw",
                    "mjwdrqwp",
                    "eo",
                    "nfqwa",
                    "pabuk",
                    "nfyqwa",
                    "qssdya",
                    "qsdya",
                    "qyssedhya",
                    "pabu",
                    "nqwa",
                    "pabqoukc",
                    "pbu",
                    "mw",
                    "vlodpmwp",
                    "x",
                    "xr"
                )
            )
        )
    }
}
