package AOC2022Day1

import java.io.File

/**
 * 2022. Dag 1.
   Fråga 1
 * Du behöver hitta vilken nisse(elfen) som har mest kalorier och hur många kalorier den nissen bär på.
   Fråga 2
 * Du behöver hitta de tre nissarna(elfarna) som bär på mest mat och summera deras totala antal kalorier.
 */


//min kod är mer objektorienterad

// Funktion för att läsa innehållet i en fil
fun readFile(path: String): String {
    val file = File(path)
    return file.readText()
}

// Funktion för att räkna ut den totala mängden kalorier en elf bär på
fun calculateElfCalories(elf: String): Int {
    val snacks = elf.split("\n").map { it.toInt() }
    return snacks.sum()
}

// Funktion för att hitta elfen med mest kalorier
fun findElfWithMostCalories(elves: List<String>): Pair<Int, Int> {
    var maxCalories = 0
    var elfIndex = 0
    for ((index, elf) in elves.withIndex()) {
        val calories = calculateElfCalories(elf)
        if (calories > maxCalories) {
            maxCalories = calories
            elfIndex = index
        }
    }
    return Pair(elfIndex, maxCalories)
}

// Funktion för att hitta de tre elfarna med mest kalorier och räkna ut den totala mängden kalorier
fun findTopThreeElvesWithMostCalories(elves: List<String>): Int {
    val elfCalories = elves.map { calculateElfCalories(it) }
    val topThreeCalories = elfCalories.sortedDescending().take(3).sum()
    return topThreeCalories
}

fun main() {
    // Läs indata från fil
    val input = readFile("src/main/kotlin/AOC2022_1.txt")

    // Dela upp indatan i en lista med elfarna
    val nissar = input.trim().split("\n\n")

    // Hitta elfen med mest kalorier
    val (mostCaloriesElfIndex, maxCalories) = findElfWithMostCalories(nissar)
    println("Part 1: Elf nr:${mostCaloriesElfIndex + 1} bär totalt $maxCalories kalorier.")

    // Hitta de tre elfarna med mest kalorier och räkna ut den totala mängden kalorier
    val topThreeCalories = findTopThreeElvesWithMostCalories(nissar)
    println("Part 2: De tre elfarna som bär mest kalorier tillsammans bär totalt $topThreeCalories kalorier.")
}