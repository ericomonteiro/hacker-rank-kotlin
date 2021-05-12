package algorithms

fun countingValleys(steps: Int, path: String): Int {
    var valleys = 0
    var position = 0

    path.toCharArray().map { if (it == 'U') 1 else -1 }
        .forEach {
            if ((position >= 0) && (position + it < 0)) {
                valleys++
            }
            position += it
        }

    return valleys
}

fun main(args: Array<String>) {
//    val steps = readLine()!!.trim().toInt()
//    val path = readLine()!!

    val path = "UDDDUDUUUDDDUDUU"
    val steps = path.length
    val result = countingValleys(steps, path)

    println(result)
}