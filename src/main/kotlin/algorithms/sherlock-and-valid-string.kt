package algorithms

import java.util.Scanner

//https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem

/**
 * Input (stdin)
 * aabbccddeefghi
 *
 * Expected Output
 * NO
 * */

// Complete the isValid function below.
fun isValid(s: String): String {
    val map = s.toList().groupingBy { it }.eachCount()
    val counter = map.values.groupingBy { it }.eachCount()

    if (counter.keys.size == 2 && counter.values.toIntArray()[1] == 1)
        return "YES"
    if (counter.keys.size > 1)
        return "NO"
    return "YES"
}

fun main() {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = isValid(s)

    println(result)
}
