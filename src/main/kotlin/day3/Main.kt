package day3

import java.io.File

fun countSharedFabric(fabric: HashMap<String, Int>): Int {
    var sharedFabric = 0
    for ((key, value) in fabric) {
        if (value > 1) {
            sharedFabric += 1
        }
    }
    return sharedFabric
}

fun setCoordinates(input: List<String>): HashMap<String, Int> {
    val fabric = HashMap<String, Int>()
    input.forEach {
        val c = Claim(it)

        for (x in c.leftEdge..<c.leftEdge + c.width) for (y in c.topEdge..<c.topEdge + c.height) {
            val coordinates = "$x,$y"
            if (coordinates !in fabric) {
                fabric[coordinates] = 1
            } else {
                fabric[coordinates] = fabric[coordinates]!! + 1
            }
        }
    }
    return fabric
}

fun getOverlappingClaim(input: List<String>, fabric: HashMap<String, Int>): String {
    var nonOverlappingClaim = ""
    input.forEach {
        val c = Claim(it)

        var overlappingClaim = false
        for (x in c.leftEdge..<c.leftEdge + c.width) {
            for (y in c.topEdge..<c.topEdge + c.height) {
                val coordinates = "$x,$y"
                if ((fabric[coordinates] ?: 0) > 1) {
                    overlappingClaim = true
                }
            }
        }
        if (!overlappingClaim) {
            nonOverlappingClaim = c.id
        }
    }
    return nonOverlappingClaim
}

fun main() {
    val input = File("inputs/day3.txt").readText().replace("\r", "").split("\n")

    val fabric = setCoordinates(input)
    val nonOverlappingClaim = getOverlappingClaim(input, fabric)
    val sharedFabric = countSharedFabric(fabric)

    println(sharedFabric)
    println(nonOverlappingClaim)
}
