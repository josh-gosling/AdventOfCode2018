package day3

class Claim(input: String) {
    private val splitInput = input.split("@ ", ",", ": ")
    private val fabricSize = splitInput[3]
    val id = splitInput[0]
    val leftEdge = splitInput[1].toInt()
    val topEdge = splitInput[2].toInt()
    val width = fabricSize.split("x")[0].toInt()
    val height = fabricSize.split("x")[1].toInt()
}