package algorithms

import java.util.Scanner


//https://www.hackerrank.com/challenges/strong-password/problem

// Complete the minimumNumber function below.
fun minimumNumber(n: Int, password: String): Int {
    // Return the minimum number of characters to make the password strong

    val requiredStrings = listOf(
        "0123456789",
        "abcdefghijklmnopqrstuvwxyz",
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
        "!@#$%^&*()-+"
    )

    var charsToAdd = 0
    requiredStrings.forEach {
        if (!password.existsAny(it.toCharArray()))
            charsToAdd++
    }

    (n + charsToAdd).let {
        return if (it > 6) charsToAdd else 6 - n
    }
}

fun String.existsAny(query: CharArray): Boolean {
    query.forEach {
        if (this.contains(it, false)) {
            return true
        }
    }
    return false
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

//    val n = scan.nextLine().trim().toInt()
//
//    val password = scan.nextLine()

    val password = "Ab1"
    val n = password.length

    val answer = minimumNumber(n, password)

    println(answer)
}
