package algorithms

import java.util.Scanner

/*
 * Complete the runningMedian function below.
 */
fun runningMedian(a: Array<Int>): Array<Double> {

    val resultList = Array(a.size) { Double.NaN }
    for (i in a.indices) {
        val sortedPartialArray = a.copyOfRange(0, i + 1).sorted()

        val middle = sortedPartialArray.size / 2
        if (sortedPartialArray.size % 2 == 0) {
            resultList[i] = (sortedPartialArray[middle - 1] + sortedPartialArray[middle].toDouble()) / 2
        } else {
            resultList[i] = (sortedPartialArray[middle].toDouble())
        }
    }

    return resultList
}

fun main() {
//    val scan = Scanner(System.`in`)
//
//    val aCount = scan.nextLine().trim().toInt()
//
//    val a = Array<Int>(aCount, { 0 })
//    for (aItr in 0 until aCount) {
//        val aItem = scan.nextLine().trim().toInt()
//        a[aItr] = aItem
//    }

    val x = generateSequence (1) {it + 1}.toList()
    println(x)
//
//    val a = arrayOf(12,4,5,3,8,7)
//
//    val result = runningMedian(a)
//
//    println(result.joinToString("\n"))
}
