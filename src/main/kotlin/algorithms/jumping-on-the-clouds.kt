package algorithms

import java.util.Scanner

//https://www.hackerrank.com/challenges/jumping-on-the-clouds/

/**
 * Input (stdin)
 * 7
 * 0 0 1 0 0 1 0
 *
 * Expected Output
 * 4
 */

// Complete the jumpingOnClouds function below.
fun jumpingOnClouds(c: Array<Int>): Int {
    var jumps = 0

    var i = 0
    while ( i < c.size-1) {
        if (c.size < i+3) {
            jumps++
            break
        }

        if (c[i+2] == 0) {
            i += 2
        } else {
            i ++
        }
        jumps++
    }

    return jumps
}

fun main() {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val c = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}


