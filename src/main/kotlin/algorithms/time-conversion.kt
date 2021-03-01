package algorithms

import java.text.SimpleDateFormat
import java.util.Scanner

//https://www.hackerrank.com/challenges/time-conversion/problem

fun timeConversion(s: String): String {
    val fromFormat = SimpleDateFormat("hh:mm:ssa")
    val toFormat = SimpleDateFormat("HH:mm:ss")

    val date = fromFormat.parse(s)
    return toFormat.format(date)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = "01:01:00PM" //scan.nextLine()

    val result = timeConversion(s)

    println(result)
}
