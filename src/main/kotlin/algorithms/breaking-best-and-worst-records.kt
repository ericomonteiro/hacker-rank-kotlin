package algorithms

import java.util.Scanner

//https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem

// Complete the breakingRecords function below.
fun breakingRecords(scores: Array<Int>): Array<Int> {

    var max = scores.first()
    var min = max

    val result = arrayOf(0, 0)

    for (i in 1 until scores.size) {
        val actual = scores[i]
        if (actual > max) {
            result[0]++
            max = actual
        }

        if (actual < min) {
            result[1]++
            min = actual
        }

    }

    return result

}

fun main() {
//    val scan = Scanner(System.`in`)
//
//    val n = scan.nextLine().trim().toInt()
//
//    val scores = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val scores = "10 5 20 20 4 5 2 25 1".split(" ").map { it.trim().toInt() }.toTypedArray()


    val result = breakingRecords(scores)

    println(result.joinToString(" "))
}
