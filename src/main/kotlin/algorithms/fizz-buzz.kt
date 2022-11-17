package algorithms

fun Int.isMultipleOf(n: Int) = this % n == 0



fun fizzBuzz(n: Int): Unit {

    var byThree: Boolean = false
    var byFive: Boolean = false

    for (i in 1..n) {
        byThree = i.isMultipleOf(3)
        byFive = i.isMultipleOf(5)

        if (byThree) print("Fizz")
        if (byFive) print("Buzz")
        if (!byThree && !byFive) print(i)
        println()
    }

}

fun main() {
//    val n = readLine()!!.trim().toInt()

    fizzBuzz(15)
}
