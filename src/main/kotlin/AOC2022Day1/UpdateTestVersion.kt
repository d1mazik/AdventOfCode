package AOC2022Day1

/**
Förbättringar jag gjorde inkluderar:
Läste in filen med File istället för att använda en separat readFile-funktion.
Använde Pair för att spara både varje alvs namn och deras kaloriintag tillsammans i en lista.
Använde maxByOrNull istället för att manuellt iterera över alverna för att hitta den som bar mest kalorier.
Använde sortedByDescending för att sortera alverna efter deras kaloriintag i fallande ordning, istället för att använda en
manuell take för att hitta de tre alverna med högst kaloriintag.
Använde sumOf istället för sum tillsammans med take för att räkna ut den totala mängden kalorier som de tre elfarna bar på.
 */

import java.io.File

fun main() {
    val input = File("src/main/kotlin/AOC2022_1.txt").readText().trim()

    val elves = input.split("\n\n")
    val elfsWithCalories = elves.map { elf -> Pair(elf, elf.split("\n").map { it.toInt() }.sum()) }

    val mostCaloriesElf = elfsWithCalories.maxByOrNull { it.second }!!
    val topThreeCalories = elfsWithCalories.sortedByDescending { it.second }.take(3).sumOf { it.second }

    println("Part 1: Elf nr: ${elves.indexOf(mostCaloriesElf.first) + 1} bär totalt ${mostCaloriesElf.second} kalorier.")
    println("Part 2: TPart 2: De tre elfarna som bär mest kalorier tillsammans bär totalt $topThreeCalories kalorier.")
}