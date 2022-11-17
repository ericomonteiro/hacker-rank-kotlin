package algorithms

import java.util.Scanner
import kotlin.math.absoluteValue

//https://www.hackerrank.com/challenges/kangaroo/problem

// Complete the kangaroo function below.
fun kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String {

    val distance = (x1 - x2).absoluteValue
    val approximation = (v1 - v2).absoluteValue

    //--- different position same velocity
    if (v1 == v2 && x1 != x2) return "NO"

    val first = if (x1 > x2) "x1" else "x2"
    val faster = if (v1 > v2) "x1" else "x2"

    //--- the second must be faster
    if (faster == first) return "NO"

    if (distance % approximation != 0) return "NO"

    return "YES"
}

fun main() {
    val scan = Scanner(System.`in`)

//    val x1V1X2V2 = scan.nextLine().split(" ")

    val x1V1X2V2 = "0 2 5 3".split(" ")

    val x1 = x1V1X2V2[0].trim().toInt()

    val v1 = x1V1X2V2[1].trim().toInt()

    val x2 = x1V1X2V2[2].trim().toInt()

    val v2 = x1V1X2V2[3].trim().toInt()

    val result = kangaroo(x1, v1, x2, v2)

    println(result)
}
