package algorithms

fun filledOrders(order: Array<Int>, k: Int): Int {
    // Write your code here
    var ordersFulfilled = 0;
    var widgetsAvailable = k

    order.sortedArray().forEach {
        widgetsAvailable -= it
        if (widgetsAvailable < 0) {
            return ordersFulfilled
        }
        ordersFulfilled++
    }
    return ordersFulfilled
}

fun main(args: Array<String>) {
//    val orderCount = readLine()!!.trim().toInt()

//    val order = Array<Int>(orderCount, { 0 })
//    for (i in 0 until orderCount) {
//        val orderItem = readLine()!!.trim().toInt()
//        order[i] = orderItem
//    }
//
//    val k = readLine()!!.trim().toInt()

    val k = 3
    val order = arrayOf(5, 4, 6)

    val result = filledOrders(order, k)

    println(result)
}
