package AOC2022Day1

// denna version av koden används högre ordningens funktioner
// som withIndex(), map(), maxByOrNull(), sortedDescending(), take() och sum()
// för att göra operationerna mer funktionella. Notera att dessa funktioner skapar
// nya listor och objekt, så om datamängden är mycket stor kan det påverka prestandan
// den har en mer funktionell stil än din ursprungliga kod eftersom den använder
// högre ordningens funktioner för att manipulera data. Löser problem på ett effektivt sätt

import java.io.File

fun main() {
    // Läs indata från fil
    val input = File("src/main/kotlin/AOC2022_1.txt").readText()

    // Dela upp indatan i en lista med nissar
    val nissar = input.trim().split("\n\n")

    // Hitta elfen med mest kalorier
    val (mostCaloriesElfIndex, maxCalories) = nissar.withIndex()
        .map { (index, elf) -> Pair(index, elf.split("\n").map { it.toInt() }.sum()) }
        .maxByOrNull { it.second }!!

    println("Part 1: Elf nr:${mostCaloriesElfIndex + 1} bär totalt $maxCalories kalorier.")

    // Hitta de tre elfarna med mest kalorier och räkna ut den totala mängden kalorier
    val topThreeCalories = nissar.map { it.split("\n").map { it.toInt() }.sum() }
        .sortedDescending()
        .take(3)
        .sum()

    println("Part 2: De tre elfarna som bär mest kalorier tillsammans bär totalt $topThreeCalories kalorier.")
}