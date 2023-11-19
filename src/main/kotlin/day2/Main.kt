package day2

import java.io.File

fun main() {
    val input = File("inputs/day2.txt").readLines()
    var twos = 0
    var threes = 0

    for (id in input) {
        var twoPresent = false
        var threePresent = false
        val seen = HashMap<Char, Int>()

        for (char in id) {
            if (char !in seen) {
                seen[char] = 1
            } else {
                seen[char] = seen[char]!! + 1
            }
        }
        seen.forEach { (key, value) ->
            if (!twoPresent && value == 2) {
                twos += 1
                twoPresent = true
            } else if (!threePresent && value == 3) {
                threes += 1
                threePresent = true
            }
        }
    }
    println(twos * threes)
}
