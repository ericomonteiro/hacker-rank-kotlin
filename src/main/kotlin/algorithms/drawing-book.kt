package algorithms

import kotlin.math.min

//https://www.hackerrank.com/challenges/drawing-book/problem?isFullScreen=false


/*
 * Complete the 'pageCount' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER p
 */

fun pageCount(bookSize: Int, pageGoal: Int): Int {
    val distance =  min(bookSize - pageGoal, pageGoal)

    if (distance == 1 &&
            bookSize % 2 == 0 &&
            pageGoal > 1
        ) return distance

    return distance / 2
}

fun main(args: Array<String>) {
//    val n = readLine()!!.trim().toInt()
//
//    val p = readLine()!!.trim().toInt()

    val result = pageCount(5, 4)

    println(result)
}
