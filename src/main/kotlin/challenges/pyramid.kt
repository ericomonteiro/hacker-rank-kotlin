package challenges

fun main() {
    printPyramid(5)
}

fun printPyramid(lines: Int, current: Int = 1) {
    val nDash = lines - (1 * current)
    val nBody = 1 + ((current - 1) * 2)

    if (current > lines) return

    println("-".repeat(nDash) + "#".repeat(nBody) + "-".repeat(nDash))
    printPyramid(lines, current + 1)
}
