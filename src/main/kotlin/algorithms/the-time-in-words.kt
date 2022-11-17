package algorithms

import java.util.Scanner

//https://www.hackerrank.com/challenges/the-time-in-words/problem

val englishNumber = mapOf(
    1  to "one",
    2  to "two",
    3  to "three",
    4  to "four",
    5  to "five",
    6  to "six",
    7  to "seven",
    8  to "eight",
    9  to "nine",
    10 to "ten",
    11 to "eleven",
    12 to "twelve",
    13 to "thirteen",
    14 to "fourteen",
    15 to "fifteen",
    16 to "sixteen",
    17 to "seventeen",
    18 to "eighteen",
    19 to "nineteen",
    20 to "twenty",
    21 to "twenty one",
    22 to "twenty two",
    23 to "twenty three",
    24 to "twenty four",
    25 to "twenty five",
    26 to "twenty six",
    27 to "twenty seven",
    28 to "twenty eight",
    29 to "twenty nine"
)

// Complete the timeInWords function below.
fun timeInWords(h: Int, m: Int): String {

    val mWord = if (m <= 30) m else 60 - m
    val hWord = if (m <= 30) h else h + 1

    return when {
        m == 0 -> "${englishNumber[hWord]} o' clock"
        m == 1 -> "${englishNumber[mWord]} minute past ${englishNumber[hWord]}"
        m == 15 -> "quarter past ${englishNumber[hWord]}"
        m < 30 -> "${englishNumber[mWord]} minutes past ${englishNumber[hWord]}"
        m == 30 -> "half past ${englishNumber[hWord]}"
        m == 45 -> "quarter to ${englishNumber[hWord]}"
        else -> "${englishNumber[mWord]} minutes to ${englishNumber[hWord]}"
    }
}

fun main() {
    val scan = Scanner(System.`in`)

//    val h = scan.nextLine().trim().toInt()
//
//    val m = scan.nextLine().trim().toInt()
//    val result = timeInWords(h, m)

    println(timeInWords(5, 0))
    println(timeInWords(5, 1))
    println(timeInWords(5, 10))
    println(timeInWords(5, 15))
    println(timeInWords(5, 30))
    println(timeInWords(5, 40))
    println(timeInWords(5, 45))
    println(timeInWords(5, 47))
    println(timeInWords(5, 28))
}
