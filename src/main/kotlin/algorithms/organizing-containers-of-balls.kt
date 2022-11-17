package algorithms

import java.util.Scanner

//https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem

// Complete the organizingContainers function below.
fun organizingContainers(container: Array<Array<Int>>): String {
    val containerSize = container.map { it.sum() }.sorted()


    val quantityByType = mutableListOf<Int>()
    for (i in container[0].indices) {
        quantityByType.add(container.sumBy { it[i] })
    }
    quantityByType.sort()

    return if (quantityByType == containerSize) "Possible" else "Impossible"
}

fun main() {
//    val scan = Scanner(System.`in`)
//
//    val q = scan.nextLine().trim().toInt()
//
//    for (qItr in 1..q) {
//        val n = scan.nextLine().trim().toInt()
//
//        val container = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })
//
//        for (i in 0 until n) {
//            container[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//        }
//
//        val result = organizingContainers(container)
//
//        println(result)
//    }

//    val container = arrayOf(
//        arrayOf(1, 1),
//        arrayOf(1, 1)
//    )

//    val container = arrayOf(
//        arrayOf(1, 3, 1),
//        arrayOf(2, 1, 2),
//        arrayOf(3, 3, 3)
//    )

//    val container = arrayOf(
//        arrayOf(0, 2),
//        arrayOf(1, 1)
//    )

    val container = arrayOf(
        arrayOf(0, 2, 1),
        arrayOf(2, 0, 0),
        arrayOf(1, 1, 1)
    )

    val result = organizingContainers(container)

    println(result)
}
