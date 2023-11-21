package day4

import java.io.File

fun main() {
    val input = File("inputs/day4.txt").readText().split("\n")
    var id = "None"
    val minutesAsleep = HashMap<Int, String>() // minutes, ids
    var shiftStart = 0
    var startHour = 0
    input.forEach {
        println(it)
        val text = it.split("] ")[1]
        val hour = it.split("] ")[0].split(" ")[1].split(":")[0].toInt()
        val minute = it.split("] ")[0].split(" ")[1].split(":")[1].toInt()

        if ("begins shift" in text) {
            id = text.split("#")[1].split(" begins")[0]
            if (hour == 0) {
                if (minute in minutesAsleep) {
                    minutesAsleep[minute] = minutesAsleep[minute] + " $id"
                } else {
                    minutesAsleep[minute] = id
                }
            }
            shiftStart = minute
            startHour = hour
        } else if ("wakes up" in text) {
            if (minute in minutesAsleep) {
                minutesAsleep[minute] = minutesAsleep[minute] + " $id"
            } else {
                minutesAsleep[minute] = id
            }
            shiftStart = minute
        } else if ("falls asleep" in text) {
            if (startHour != 0) {
                shiftStart = -1
            }
                for (i in shiftStart + 1..<minute) {
                    if (i in minutesAsleep) {
                        minutesAsleep[i] = minutesAsleep[i] + " $id"
                    } else {
                        minutesAsleep[i] = id
                    }
                }
        } else if ("wakes up" in text) {

        }
    }
    println("complete")
}
