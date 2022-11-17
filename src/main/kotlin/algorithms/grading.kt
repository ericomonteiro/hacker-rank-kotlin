package algorithms

//https://www.hackerrank.com/challenges/grading/problem

fun gradingStudents(grades: Array<Int>): Array<Int> {

    return grades.map {
        val multiple = (it / 5) + 1
        val newGrade = 5 * multiple
        if (newGrade < 40 || newGrade - it >= 3) it else newGrade
    }.toTypedArray()
}

fun main() {
//    val gradesCount = readLine()!!.trim().toInt()
//
//    val grades = Array<Int>(gradesCount, { 0 })
//    for (i in 0 until gradesCount) {
//        val gradesItem = readLine()!!.trim().toInt()
//        grades[i] = gradesItem
//    }

    val grades = arrayOf(73,67,38,33)

    val result = gradingStudents(grades)

    println(result.joinToString("\n"))
}