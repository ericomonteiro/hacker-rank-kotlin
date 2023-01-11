package algorithms

import kotlin.math.absoluteValue

fun bonAppetit(bill: Array<Int>, k: Int, b: Int): Unit {

    val didNotEat = bill[k]
    val total = bill.sum() - didNotEat
    val annaBill = total / 2

    if (annaBill == b) {
        println("Bon Appetit")
    } else {
        println((annaBill - b).absoluteValue)
    }
}

fun main() {

//    val bill = arrayOf(3, 10, 2, 9)
//    val k = 1
//    val b = 12

    val bill = arrayOf(3, 10, 2, 9)
    val k = 1
    val b = 12

    bonAppetit(bill, k, b)
}