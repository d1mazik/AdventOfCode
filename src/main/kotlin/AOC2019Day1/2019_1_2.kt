package AOC2019Day1

import java.io.File

/**
 * 2019. Dag 1. Part 2
 * Fråga 2
 * Totala bränslemängden som krävs för att starta alla moduler beräknas genom att summera bränslemängden för varje modul.
 */

fun main() {
    // läser in modulmassorna från filen och konverterar varje rad till en Integer (Int)
    // här beräknar den totala bränslemängden som krävs genom att kalla på funktionen calculateTotalFuel och summera resultaten
    val moduleMasses = File("src/main/kotlin/AOC2019_1.txt").readLines().map { it.toInt() }
    val totalFuel = moduleMasses.map { calculateTotalFuel(it) }.sum()
    println("Part2: $totalFuel")
}

     // funktion som beräknar den totala bränslemängden som krävs för en modul med en viss massa
     // beräknar bränslemängden som krävs för att flytta modulen och sparar resultatet i variabeln fuel
     // sätt totalFuel till bränslemängden som krävs för att flytta modulen (fuel) eftersom detta är den minsta bränslemängden som krävs
     // beräknar bränslemängden som krävs för att flytta allt tidigare beräknat bränsle och lägg till detta i totalFuel
     // om bränslemängden som krävs för att flytta det tidigare beräknade bränslet är större än 0, lägg till detta i totalFuel
fun calculateTotalFuel(mass: Int): Int {
         var fuel = calculateFuel(mass)
    var totalFuel = fuel
    while (fuel > 0) {
        fuel = calculateFuel(fuel)
        if (fuel > 0) {
            totalFuel += fuel
        }
    }
    return totalFuel
}
