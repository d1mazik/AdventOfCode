package AOC2019Day1Internet

import java.nio.file.Files
import java.nio.file.Paths
import kotlin.math.max

/**
Den här lösningen använder en separat funktion totalFuelNeeded för att beräkna den totala bränslemängden som krävs
för både modulen och allt bränsle som krävs för bränslet, medan min lösning har det i samma loop som
beräknar bränslemängden för varje modul.
 */

// https://dev.to/jbristow/advent-of-code-2019-solution-megathread-day-1-the-tyranny-of-the-rocket-equation-3kj9

private const val FILENAME = "src/main/kotlin/AOC2019_1.txt"

fun fuelNeeded(mass: Int) = max((mass / 3) - 2, 0)


fun totalFuelNeeded(mass: Int): Int {
    var fuel = fuelNeeded(mass)
    var totalFuel = fuel
    while (fuel != 0) {
        fuel = fuelNeeded(fuel)
        totalFuel += fuel
    }
    return totalFuel
}

fun part1() = Files.readAllLines(Paths.get(FILENAME))
    .sumBy { fuelNeeded(it.toInt()) }
    .toString()

fun part2() = Files.readAllLines(Paths.get(FILENAME))
    .sumBy { totalFuelNeeded(it.toInt()) }
    .toString()

fun main() {
    println("Part 1: ${part1()}")
    println("Part 2: ${part2()}")
}