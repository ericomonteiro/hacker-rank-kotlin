package algorithms

import java.math.BigDecimal
import java.util.Scanner

//https://www.hackerrank.com/challenges/extra-long-factorials/problem

fun extraLongFactorials(n: Int): Unit {
    var result = n.toBigDecimal()
    for (i in n downTo 2) {
        result *= BigDecimal(i - 1)
    }

    println(result)
}

fun main() {
    val scan = Scanner(System.`in`)
//
//    val n = scan.nextLine().trim().toInt()

    val n = 25
    extraLongFactorials(n)
}
