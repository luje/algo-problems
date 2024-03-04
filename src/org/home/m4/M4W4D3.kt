package org.home.m4

import java.util.*

/**
 * Created by lje on 4/24/2021.
 */
object M4W4D3 {

    fun criticalConnections(n: Int, connections: List<List<Int>>): List<List<Int>> {
        var adj = List(n) { LinkedList<Int>() }

        connections.forEach { l ->
            adj[l[0]].add(l[1])
            adj[l[1]].add(l[0])
        }

        var visited = BooleanArray(n) { false }
        var disc = IntArray(n)
        var low = IntArray(n)
        var parent = IntArray(n) { -1 }

        return dfs(0, visited, disc, low, parent, adj, 1)
    }

    private fun dfs(
        u: Int,
        visited: BooleanArray,
        disc: IntArray,
        low: IntArray,
        parent: IntArray,
        adj: List<LinkedList<Int>>,
        time: Int
    ): List<List<Int>> {
        visited[u] = true
        low[u] = time
        disc[u] = time

        val result = mutableListOf<List<Int>>()

        adj[u].forEach { v ->
            if (!visited[v]) {
                parent[v] = u

                result.addAll(dfs(v, visited, disc, low, parent, adj, time + 1))

                low[u] = minOf(low[v], low[u])

                if (low[v] > disc[u]) {
                    result.add(listOf(v, u))
                }
            } else if (v != parent[u]) {
                low[u] = minOf(low[u], disc[v])
            }
        }

        return result
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(
            criticalConnections(
                4, listOf(
                    listOf(0, 1),
                    listOf(1, 2),
                    listOf(2, 0),
                    listOf(1, 3),
                )
            )
        )

        println(
            criticalConnections(
                5, listOf(
                    listOf(1, 0),
                    listOf(0, 2),
                    listOf(2, 1),
                    listOf(0, 3),
                    listOf(3, 4),
                )
            )
        )

        println(
            criticalConnections(
                4, listOf(
                    listOf(0, 1),
                    listOf(1, 2),
                    listOf(2, 3),
                )
            )
        )

        println(
            criticalConnections(
                7, listOf(
                    listOf(0, 1),
                    listOf(1, 2),
                    listOf(2, 0),
                    listOf(1, 3),
                    listOf(1, 4),
                    listOf(1, 6),
                    listOf(3, 5),
                    listOf(4, 5),
                )
            )
        )
    }
}
