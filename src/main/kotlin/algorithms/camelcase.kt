package algorithms

import java.util.Scanner

// Complete the camelcase function below.
fun camelcase(s: String) = s.toCharArray().filter { it.isUpperCase() }.count() + 1


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = camelcase(s)

    println(result)
}
