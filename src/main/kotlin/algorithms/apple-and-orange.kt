package algorithms

import java.util.Scanner

//https://www.hackerrank.com/challenges/apple-and-orange/problem

// Complete the countApplesAndOranges function below.
fun countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array<Int>, oranges: Array<Int>): Unit {
    val applesInHouse = apples.map { it + a }.filter { it in s..t }.count()
    val orangesInHouse = oranges.map { it + b }.filter { it in s..t }.count()

    println(applesInHouse)
    println(orangesInHouse)
}


/*
*  s = start house range
*  t = end house range
*  a = orange tree point
*  b = apple tree point
* */

fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val st = scan.nextLine().split(" ")
//
//    val s = st[0].trim().toInt()
//
//    val t = st[1].trim().toInt()
//
//    val ab = scan.nextLine().split(" ")
//
//    val a = ab[0].trim().toInt()
//
//    val b = ab[1].trim().toInt()
//
//    val mn = scan.nextLine().split(" ")
//
//    val m = mn[0].trim().toInt()
//
//    val n = mn[1].trim().toInt()
//
//    val apples = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//
//    val oranges = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val s = 7
    val t = 10
    val a = 4
    val b = 12
    val apples = arrayOf(2, 3, -4)
    val oranges = arrayOf(3, -2, -4)

    countApplesAndOranges(s, t, a, b, apples, oranges)
}
