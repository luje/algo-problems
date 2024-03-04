package org.home.m4

import java.util.stream.Stream

/**
 * Created by lje on 4/13/2021.
 */
object M4W2D6 {
    class NestedIterator(nestedList: List<NestedInteger>) {

        val i: Iterator<NestedInteger>

        init {
            i = nestedList.stream().flatMap { expand(it) }.iterator()
        }

        private fun expand(e: NestedInteger): Stream<NestedInteger> {
            return if (e.isInteger())
                Stream.of(e)
            else
                e.getList()!!.stream().flatMap { expand(it) }
        }


        fun next(): Int {
            return i.next().getInteger()!!
        }

        fun hasNext(): Boolean {
            return i.hasNext()
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
//        val t = NestedIterator(listOf(NestedInteger(listOf(1, 1)), NestedInteger(2), NestedInteger(listOf(1, 1))))
        val t = NestedIterator(listOf(NestedInteger(emptyList())))

        while (t.hasNext()) {
            println(t.next())
        }
    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    class NestedInteger {
        // Constructor initializes an empty nested list.
        var value: Int? = null
        var values: List<NestedInteger>? = null

        constructor() {
            value = null
            values = null
        }

        // Constructor initializes a single integer.
        constructor(value: Int) {
            this.value = value
        }

        constructor(values: List<Int>) {
            this.values = values.map { NestedInteger(it) }
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        fun isInteger(): Boolean = value != null

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        fun getInteger(): Int? = value

        // Set this NestedInteger to hold a single integer.
        fun setInteger(value: Int): Unit {
            this.value = value
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        fun add(ni: NestedInteger): Unit {
            this.values = values!! + listOf(ni)
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        fun getList(): List<NestedInteger>? = values
    }

}
