package algorithms

//https://www.hackerrank.com/challenges/between-two-sets/problem


/*
 * Complete the 'getTotalX' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER_ARRAY b
 */

fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
    val min = a.max() ?: 0
    val max = b.min() ?: 0

    val multiples = arrayListOf<Int>()
    var result = arrayListOf<Int>()

    for (i in min..max step min) {
        var isMultiple = true

        a.forEach {
            if (i % it != 0) {
                isMultiple = false
                return@forEach
            }
        }

        if (isMultiple) {
            multiples.add(i)
        }
    }

    if (multiples.isEmpty()) return 0

    for (i in multiples) {
        var isFactor = true

        b.forEach {
            if (it % i != 0) {
                isFactor = false
                return@forEach
            }
        }

        if (isFactor) {
            result.add(i)
        }
    }

    // Write your code here
    return result.size
}

fun main() {
//    val first_multiple_input = readLine()!!.trimEnd().split(" ")
//
//    val n = first_multiple_input[0].toInt()
//
//    val m = first_multiple_input[1].toInt()
//
//    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
//
//    val brr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val arr = arrayOf(1)

    val brr = arrayOf(100)

    val total = getTotalX(arr, brr)

    println(total)
}
