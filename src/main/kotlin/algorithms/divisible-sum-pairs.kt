package algorithms

/*
 * Complete the 'divisibleSumPairs' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. INTEGER k
 *  3. INTEGER_ARRAY ar
 */

fun divisibleSumPairs(n: Int, k: Int, ar: Array<Int>): Int {
    var result = 0
    for (i  in 0..ar.size - 2) {
        for (j in i + 1 until ar.size) {
            if ((ar[i] + ar[j]) % k == 0) result++
        }
    }
    return result
}

fun main(args: Array<String>) {
//    val first_multiple_input = readLine()!!.trimEnd().split(" ")
//
//    val n = first_multiple_input[0].toInt()
//
//    val k = first_multiple_input[1].toInt()
//
//    val ar = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val n = 6
    val k = 3
    val ar = arrayOf(1, 3, 2, 6, 1, 2)

    val result = divisibleSumPairs(n, k, ar)

    println(result)
}
