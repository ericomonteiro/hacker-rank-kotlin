package algorithms

/*
 * Complete the 'minTime' function below.
 *
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY files
 *  2. INTEGER numCores
 *  3. INTEGER limit
 */

fun minTime(files: Array<Int>, numCores: Int, limit: Int): Long {
    var filesParallelized = 0
    var time = 0L

    files.sortedArrayDescending().forEach {
        if (it % numCores == 0 && filesParallelized < limit) {
            time += it / numCores
            filesParallelized ++
        } else {
            time += it
        }
    }

    return time
}

fun main() {
//    val filesCount = readLine()!!.trim().toInt()
//
//    val files = Array<Int>(filesCount, { 0 })
//    for (i in 0 until filesCount) {
//        val filesItem = readLine()!!.trim().toInt()
//        files[i] = filesItem
//    }
//
//    val numCores = readLine()!!.trim().toInt()
//
//    val limit = readLine()!!.trim().toInt()

//    val files = arrayOf(5, 3, 1)
//    val numCores = 5
//    val limit = 5

    val files = arrayOf(3, 1, 5)
    val numCores = 1
    val limit = 5

    val result = minTime(files, numCores, limit)

    println(result)
}