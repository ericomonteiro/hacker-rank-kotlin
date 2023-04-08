package algorithms

//https://www.hackerrank.com/challenges/electronics-shop

fun getMoneySpent(keyboards: Array<Int>, drives: Array<Int>, b: Int): Int {
    var spent = -1

    keyboards.forEach { keyBoard ->
        drives.forEach { drive ->
            val proposal = keyBoard + drive
            if (proposal == b) return proposal

            if (proposal in (spent + 1)..b) {
                spent = proposal
            }
        }
    }

    return spent
}

fun main(args: Array<String>) {

    val keyboards = arrayOf(3, 1)
    val drives = arrayOf(5, 2, 8)
    val b = 10

    val moneySpent = getMoneySpent(keyboards, drives, b)

    println(moneySpent)
}