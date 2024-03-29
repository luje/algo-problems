package org.home.m5.w2

import java.util.stream.LongStream
import java.util.stream.Stream
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Created by lje on 5/8/2021.
 *
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3736/
 *
 */
object D1 {

    fun superpalindromesInRange(left: String, right: String): Long =
        pal(
            sqrt(left.toDouble()),
            sqrt(right.toDouble())
        ).count()

    fun pal(a: Double, b: Double): Stream<Long> {
        return LongStream.range(lim(a) / 10, lim(b)*10)
            .mapToObj { it.toString() }
            .flatMap {
                val el1 = it + it.reversed()
                val el2r = it.substring(0, it.length - 1)
                val el2 = el2r + it.last() + el2r.reversed()

                Stream.of(el1, el2)
            }
            .map { it.toLong() }
            .map { it * it }
            .filter { (a * a) <= it && it <= b * b }
            .filter { isPal(it.toString()) }
    }

    private fun lim(a: Double): Long {
        return (a / 10.toDouble().pow(a.toInt().toString().length / 2)).toLong()
    }

    private fun isPal(n: String): Boolean {
        return n == n.reversed()
    }

    @JvmStatic
    fun main(args: Array<String>) {
//        println(superpalindromesInRange("4", "1000"))
//        println(superpalindromesInRange("1", "12"))
//        println(superpalindromesInRange("111", "231"))
//        println(superpalindromesInRange("1", "2"))

        pal(
            sqrt(1.toDouble()),
            sqrt( 10.toDouble().pow(18))
        ).sorted().forEach(::println)

        println(l.size)
    }

    val l = listOf(
        1,
        4,
        9,
        121,
        484,
        10201,
        12321,
        14641,
        40804,
        44944,
        1002001,
        1234321,
        4008004,
        100020001,
        102030201,
        104060401,
        121242121,
        123454321,
        125686521,
        400080004,
        404090404,
        10000200001,
        10221412201,
        12102420121,
        12345654321,
        40000800004,
        1000002000001,
        1002003002001,
        1004006004001,
        1020304030201,
        1022325232201,
        1024348434201,
        1210024200121,
        1212225222121,
        1214428244121,
        1232346432321,
        1234567654321,
        4000008000004,
        4004009004004,
        100000020000001,
        100220141022001,
        102012040210201,
        102234363432201,
        121000242000121,
        121242363242121,
        123212464212321,
        123456787654321,
        400000080000004,
        10000000200000001,
        10002000300020001,
        10004000600040001,
        10020210401202001,
        10022212521222001,
        10024214841242001,
        10201020402010201,
        10203040504030201,
        10205060806050201,
        10221432623412201,
        10223454745432201,
        12100002420000121,
        12102202520220121,
        12104402820440121,
        12122232623222121,
        12124434743442121,
        12321024642012321,
        12323244744232321,
        12343456865434321,
        12345678987654321,
        40000000800000004,
        40004000900040004,
        1000000002000000001,
        1000220014100220001,
        1002003004003002001,
        1002223236323222001,
        1020100204020010201,
        1020322416142230201,
        1022123226223212201,
        1022345658565432201,
        1210000024200000121,
        1210242036302420121,
        1212203226223022121,
        1212445458545442121,
        1232100246420012321,
        1232344458544432321,
        1234323468643234321,
        4000000008000000004
    )
}
