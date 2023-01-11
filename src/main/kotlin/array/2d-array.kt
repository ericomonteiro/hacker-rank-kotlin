package array

//https://www.hackerrank.com/challenges/2d-array


import java.util.InputMismatchException
import javax.swing.table.TableColumn
import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

/*
 * Complete the 'hourglassSum' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */

fun hourglassSum(arr: Array<Array<Int>>): Int {

    var biggest: Int? = null

    //--- 0 to 3 because are only these possibilities can to start an hourglass
    for (line in 0..3) {
        for (column in 0..3) {
            val hourglass = valueHourglass(arr, line, column)
            if (biggest == null || hourglass > biggest) {
                biggest = hourglass
            }
        }
    }


    return biggest!!
}

fun valueHourglass(arr: Array<Array<Int>>, line: Int, column: Int) =
    arr[line][column] + arr[line][column + 1] + arr[line][column + 2] + // line 1
            arr[line + 1][column + 1] + // line 2
            arr[line + 2][column] + arr[line + 2][column + 1] + arr[line + 2][column + 2] // line 3

val example = """
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
""".trimIndent()

fun main(args: Array<String>) {

    val lines = example.split("\n")

    val arr = Array<Array<Int>>(6) { Array<Int>(6) { 0 } }

    for (i in 0 until 6) {
        arr[i] = lines[i].split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}


