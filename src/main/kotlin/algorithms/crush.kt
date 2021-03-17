package algorithms

import java.util.Scanner

//https://www.hackerrank.com/challenges/crush/problem

// Complete the arrayManipulation function below.
fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    val arrayResult = mutableListOf<Long>()

    var max = 0L
    queries.forEach {
        for (i in it[0] - 1 until minOf(it[1], arrayResult.size)) {
            arrayResult[i] += it[2].toLong()
            max = maxOf(arrayResult[i], max)
        }

        for (i in arrayResult.size until it[1]) {
            if (i >= it[0] - 1) {
                arrayResult.add(it[2].toLong())
                max = maxOf(arrayResult[i], it[2].toLong())
            } else {
                arrayResult.add(0)
            }
        }
    }

    return max
}

fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val nm = scan.nextLine().split(" ")
//
//    val n = nm[0].trim().toInt()
//
//    val m = nm[1].trim().toInt()
//
//    val queries = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })
//
//    for (i in 0 until m) {
//        queries[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//    }

//    val queries = arrayOf(
//        arrayOf(1,5,3),
//        arrayOf(4,8,7),
//        arrayOf(6,9,1)
//    )

    val queries = arrayOf(
        arrayOf(2,3,603),
        arrayOf(1,1,286),
        arrayOf(4,4,882)
    )

    val n = 3

    val result = arrayManipulation(n, queries)

    println(result)
}
