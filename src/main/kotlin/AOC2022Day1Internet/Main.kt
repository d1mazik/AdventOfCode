package AOC2022Day1Internet

//https://github.com/tginsberg/advent-2022-kotlin/blob/main/src/main/kotlin/com/ginsberg/advent2022/Day01.kt

// här använder man Day01-klassen funktionella egenskaper som solvePart1() och solvePart2() f
// ör att räkna ut lösningarna på ett mer deklarativt sätt.
// smart lösning som gör koden mer strukturerad och lättläst

import java.io.File

class Day01(filePath: String) {

    private val calories: List<Int> = File(filePath).readText().trim()
        .split("\n\n")
        .map { it.lines().sumOf(String::toInt) }
        .sortedDescending()

    fun solvePart1(): Int = calories.first()

    fun solvePart2(): Int = calories.take(3).sum()
}

fun main() {
    val day01 = Day01("src/main/kotlin/AOC2022_1.txt")
    println("Part 1: The Elf carrying the most calories is carrying a total of ${day01.solvePart1()} calories.")
    println("Part 2: The top three Elves carrying the most calories are carrying a total of ${day01.solvePart2()} calories.")
}