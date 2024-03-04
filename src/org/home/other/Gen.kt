package org.home.other

import javax.script.ScriptEngineManager

/**
 * Created by lje on 4/2/2021.
 */
object Gen {

    val engine = ScriptEngineManager().getEngineByExtension("js")!!

    val ops = arrayOf("", " + ", " - ", " * ", " / ")
    val c = intArrayOf(1, 2, 3, 4, 5)
    val result = mutableSetOf<Pair<Number, String>>()

    fun back(i: Int, j: Int, a: IntArray, op: Boolean) {
        if (i == c.size) {
            result.add(evaluate(a))

            return;
        }

        if (op) {
            for (p in ops.indices) {
                a[i + j] = p

                back(i, j + 1, a, false)
            }
        } else {
            val selected = a.filterIndexed { idx, _ -> idx < i + j && idx % 2 == 0 }.toSet()

            for (p in c.indices) {
                if (selected.contains(p)) {
                    continue
                }

                a[i + j] = p

                back(i + 1, j, a, true)
            }
        }
    }

    private fun evaluate(a: IntArray): Pair<Number, String> {
        val ex = a.mapIndexed { idx, v -> if (idx % 2 == 0) c[v] else ops[v] }
            .joinToString(separator = "")
        val v = engine.eval(ex)!! as Number

        return Pair(v, ex)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        back(0, 0, IntArray(2 * c.size - 1), false)

        result.sortedWith(compareBy { it.first.toDouble() })
            .forEach { (r, e) -> println("$r = $e") }
    }

}
