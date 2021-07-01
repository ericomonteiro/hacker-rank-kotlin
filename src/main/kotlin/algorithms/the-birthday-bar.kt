package algorithms

//https://www.hackerrank.com/challenges/the-birthday-bar/problem

/*
 * Complete the 'birthday' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY s
 *  2. INTEGER d
 *  3. INTEGER m
 */

fun birthday(s: Array<Int>, d: Int, m: Int): Int {
    var result = 0
    for (i in 0..(s.size - m)) {
        if (s.copyOfRange(i, i + m).sum() == d)  result++
    }
    return result
}

fun main(args: Array<String>) {
//    val n = readLine()!!.trim().toInt()
//
//    val s = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
//
//    val first_multiple_input = readLine()!!.trimEnd().split(" ")
//
//    val d = first_multiple_input[0].toInt()
//
//    val m = first_multiple_input[1].toInt()


    val s = arrayOf(1, 2, 1, 3, 2)
    val d = 3
    val m = 2

    val result = birthday(s, d, m)

    println(result)
}
