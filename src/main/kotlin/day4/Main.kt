package day4

import java.io.File

fun solvePart1(sleepMinutesPerGuard: MutableMap<Int, List<Int>>): Int {
    return sleepMinutesPerGuard
        .maxBy { it.value.size }
        .run { key * value.groupBy { it }.maxBy { it.value.size }.key }
}

fun parse(input: List<String>): MutableMap<Int, List<Int>> {
    val sleeps = mutableMapOf<Int, List<Int>>()
    var guard = 0
    var sleepStart = 0

    input.sorted().forEach { row ->
        val minute = row.split("] ")[0].split(" ")[1].split(":")[1].toInt()
        when {
            row.contains("Guard") -> guard = row.split("#")[1].split(" begins")[0].toInt()
            row.contains("asleep") -> sleepStart = minute
            else -> {
                val sleepMinutes = (sleepStart until minute).toList()
                sleeps.merge(guard, sleepMinutes) { a, b -> a + b }
            }
        }
    }
    return sleeps
}

fun main() {
    val input = File("inputs/day4.txt").readText().split("\n")
    val sleeps = parse(input)
    println(solvePart1(sleeps))
}
