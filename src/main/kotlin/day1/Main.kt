package day1

import java.io.File

fun runFrequencies(input: List<String>): Int {
    var total = 0
    var repeatFound = false
    val seen = mutableSetOf<Int>()

    while (!repeatFound) {
        for (operation in input) {
            when (operation[0]) {
                '-' -> total -= operation.drop(1).toInt()
                '+' -> total += operation.drop(1).toInt()
            }
            if (seen.contains(total)) {
                repeatFound = true
                break
            }
            seen.add(total)
        }
    }
    return total
}

fun main() {
    val input = File("inputs/day1.txt").readLines()
    println(runFrequencies(input))
}
