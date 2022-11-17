package algorithms

//https://www.hackerrank.com/challenges/matrix-rotation-algo/problem

// Complete the matrixRotation function below.
fun matrixRotation(matrix: Array<Array<Int>>, r: Int): Unit {
    val matrixAsLines = mutableListOf<MutableList<Int>>()
    var endRow: Int
    var endColumn: Int
    val quantitySubMatrix = Integer.min(matrix.size, matrix[0].size) / 2

    for (i in 0 until quantitySubMatrix) {
        endRow = (matrix.size - 1) - i
        endColumn = (matrix[0].size - 1) - i

        val subMatrix = mutableListOf<Int>()
        //--- TOP
        for (column in i..endColumn) {
            subMatrix.add(matrix[i][column])
        }

        //--- Right
        for (row in i+1..endRow) {
            subMatrix.add(matrix[row][endColumn])
        }

        //--- Bottom
        for (column in endColumn-1 downTo i) {
            subMatrix.add(matrix[endRow][column])
        }

        //--- Left
        for (row in endRow-1 downTo i+1) {
            subMatrix.add(matrix[row][i])
        }
        matrixAsLines.add(subMatrix)
    }

    matrixAsLines.forEach {
        val realRotates = r % it.size
        for (i in 0 until realRotates) {
            val savedNumber = it[0]
            it.removeAt(0)
            it.add(savedNumber)
        }
    }

    val rotatedFlat = matrixAsLines.flatten()
    var countReplaces = 0

    for (i in 0 until quantitySubMatrix) {
        endRow = (matrix.size - 1) - i
        endColumn = (matrix[0].size - 1) - i

        //--- TOP
        for (column in i..endColumn) {
            matrix[i][column] = rotatedFlat[countReplaces++]
        }

        //--- Right
        for (row in i+1..endRow) {
            matrix[row][endColumn] = rotatedFlat[countReplaces++]
        }

        //--- Bottom
        for (column in endColumn-1 downTo i) {
            matrix[endRow][column] = rotatedFlat[countReplaces++]
        }

        //--- Left
        for (row in endRow-1 downTo i+1) {
            matrix[row][i] = rotatedFlat[countReplaces++]
        }
    }

    matrix.forEach { println(it.joinToString(" ")) }
}

fun main() {
//    val mnr = readLine()!!.trimEnd().split(" ")
//
//    val m = mnr[0].toInt()
//
//    val n = mnr[1].toInt()
//
//    val r = mnr[2].toInt()
//
//    val matrix = Array<Array<Int>>(m, { Array<Int>(n, { 0 }) })
//
//    for (i in 0 until m) {
//        matrix[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
//    }

    val matrix = arrayOf(
        arrayOf(1, 2, 3, 4),
        arrayOf(12, 1, 2, 5),
        arrayOf(11, 4, 3, 6),
        arrayOf(10, 9, 8, 7)
    )

//    val matrix = arrayOf(
//        arrayOf(1, 2, 3, 4, 5),
//        arrayOf(14, 1, 2, 3, 6),
//        arrayOf(13, 6, 5, 4, 7),
//        arrayOf(12, 11, 10, 9, 8)
//    )

    matrixRotation(matrix, 2)
}
