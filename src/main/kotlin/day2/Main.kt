package day2

import java.io.File

fun getPrototypeFabricBoxIds(input: List<String>) {
    for (id in input) {
        for (secondId in input) {
            var counter = 0
            id.forEachIndexed { i, it -> if (i < secondId.length && it == secondId[i]) counter++ }
            if (counter == secondId.length - 1) {
                println("$id, $secondId")
            }
        }
    }
}

fun main() {
    val input = File("inputs/day2.txt").readText().split("\n")
    var twoCount = 0
    var threeCount = 0

    for (id in input) {
        var twoPresent = false
        var threePresent = false
        val seen = id.groupingBy { it }.eachCount()

        seen.forEach {
            if (!twoPresent && it.value == 2) {
                twoCount += 1
                twoPresent = true
            } else if (!threePresent && it.value == 3) {
                threeCount += 1
                threePresent = true
            }
        }
    }
    println(twoCount * threeCount)
    getPrototypeFabricBoxIds(input)
}
