package algorithms

import kotlin.math.sqrt

//https://www.hackerrank.com/challenges/encryption

/*
 * Complete the 'encryption' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun encryption(s: String): String {

    val clear = s.filter { it != ' ' }
    val lines = sqrt(clear.length.toDouble()).let {
        if (it > it.toInt())
            it.toInt() + 1
        else it.toInt()
    }

    val grid = arrayListOf<String>()
    val encrypted = arrayListOf<String>()

    for (i in 0..clear.length step lines) {
        val lineChars =
            if (i + lines > clear.length)
                clear.length - i
            else
                lines

        grid.add(clear.substring(i, i + lineChars))
    }

    grid.forEachIndexed { i, s ->
        if (i == 0) {
            encrypted.addAll(s.toCharArray().map { it.toString() })
        } else {
            s.toCharArray().forEachIndexed { index, c -> encrypted[index] += c.toString() }
        }
    }

    return encrypted.joinToString(" ")

}

fun main(args: Array<String>) {
    val s = "if man was meant to stay on the ground god would have given us roots"

    val result = encryption(s)

    println(result)
}
