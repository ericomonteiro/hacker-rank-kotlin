package algorithms

import kotlin.math.absoluteValue

//https://www.hackerrank.com/challenges/cats-and-a-mouse/problem?isFullScreen=false

fun catAndMouse(catA: Int, catB: Int, mouse: Int): String {

    val distanceA = (catA - mouse).absoluteValue
    val distanceB = (catB - mouse).absoluteValue

    return if (distanceA == distanceB) "Mouse C" else
            if (distanceA < distanceB) "Cat A" else
                "Cat B"
}

fun main(args: Array<String>) {

    val x = xyz[0].trim().toInt()
    val y = xyz[1].trim().toInt()
    val z = xyz[2].trim().toInt()

    val result = catAndMouse(x, y, z)

}
