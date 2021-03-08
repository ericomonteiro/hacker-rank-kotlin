package algorithms

import java.util.Scanner

//https://www.hackerrank.com/challenges/repeated-string/problem

fun repeatedString(s: String, n: Long): Long {
    val countFullStr = n / s.length
    val sizeCutMessage = n - (countFullStr * s.length)
    val cutMessage = if (sizeCutMessage > 0) s.substring(0, sizeCutMessage.toInt()) else ""
    return (countFullStr * s.countA()) + cutMessage.countA()
}
fun String.countA() = this.filter { it == 'a' }.length

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

//    val s = scan.nextLine()
//
//    val n = scan.nextLine().trim().toLong()

    val result = repeatedString("aba", 10)

    println(result)
}
