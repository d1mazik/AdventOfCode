package AOC2019Day1

import java.io.File

/**
 * 2019. Dag 1. Part 1
 * Fråga 1
 * Här ska man hjälpa Santa att samla in mätningar från stjärnor för att rädda julen. Man behöver läsa in en lista av
 * modulmassor och beräkna den totala bränslemängden som krävs för att starta alla moduler.
 */

// Funktion för att beräkna bränslemängden som krävs för en modul
// Formeln är mass delat med 3, avrundat nedåt, minus 2
fun calculateFuel(mass: Int): Int {
    val fuel = mass / 3
    val roundedFuel = fuel - 2
    return roundedFuel
}

fun main() {
    // Skapa en tom lista för massorna
    // Öppna filen "AOC2019_1.txt" och läs varje rad en åt gången
    // Konvertera varje rad till ett heltal och lägg till det i listan(mass)
    val moduleMasses = mutableListOf<Int>()
    File("src/main/kotlin/AOC2019_1.txt").forEachLine {
        val mass = it.toInt()
        moduleMasses.add(mass)
    }

    // Skapa en variabel för den totala mängden bränsle som krävs
    var totalFuel = 0

    // foreach-loop används för att iterera över alla massor i listan moduleMasses. För varje massa i listan, beräknar vi
    // bränslemängden som behövs genom att anropa funktionen calculateFuel() med massan som argument, och vi lägger sedan till
    // denna bränslemängd till totalFuel.
    for (i in 0 until moduleMasses.size) {
        val fuelForModule = calculateFuel(moduleMasses[i])
        totalFuel += fuelForModule
    }

    println("Part1: $totalFuel")
}

