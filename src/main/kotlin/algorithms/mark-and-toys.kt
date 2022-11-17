package algorithms

import java.util.Scanner

//https://www.hackerrank.com/challenges/mark-and-toys/problem

fun maximumToys(prices: Array<Int>, k: Int): Int {
    var count = 0
    var money = k
    prices.sortedArray()
        .forEach {
            money -= it
            if (money < 0) {
                return count
            } else {
                count++
            }
        }
    return 0
}

fun main() {
    val scan = Scanner(System.`in`)

//    val nk = scan.nextLine().split(" ")
//
//    val n = nk[0].trim().toInt()
//
//    val k = nk[1].trim().toInt()
//
//    val prices = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = maximumToys(arrayOf(1, 12, 5, 111, 200, 1000, 10), 50)

    println(result)
}
