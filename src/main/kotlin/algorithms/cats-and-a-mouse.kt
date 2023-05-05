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

    val x = 1
    val y = 3
    val z = 2

    val result = catAndMouse(x, y, z)

}
