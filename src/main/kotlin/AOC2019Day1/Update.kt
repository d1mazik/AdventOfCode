package AOC2019Day1

import java.io.File

/**
Genom att använda en konstant variabel för att lagra sökvägen till filen blir koden mer lättläst
och mindre benägen för stavfel eller andra felaktigheter. Den andra koden använder private const val
FILE_PATH = "src/main/kotlin/AOC2019_1.txt" för att deklarera variabeln och sedan kan han använda
den variabeln överallt i koden där sökvägen behövs. Detta är bättre än att ange sökvägen direkt i
koden flera gånger, vilket kan göra koden mer rörig och svårare att läsa,
särskilt om filen behöver öppnas på flera ställen i koden.
 */

private const val FILE_PATH = "src/main/kotlin/AOC2019_1.txt"

fun calculateFuel1(mass: Int): Int {
    return mass / 3 - 2
}

fun calculateTotalFuel1(mass: Int): Int {
    var fuel = calculateFuel1(mass)
    var totalFuel = fuel
    while (fuel > 0) {
        fuel = calculateFuel(fuel)
        if (fuel > 0) {
            totalFuel += fuel
        }
    }
    return totalFuel
}

fun main() {
    val moduleMasses = mutableListOf<Int>()
    File(FILE_PATH).forEachLine {
        moduleMasses.add(it.toInt())
    }

    var totalFuel = 0
    for (mass in moduleMasses) {
        totalFuel += calculateFuel(mass)
    }
    println("Part1: $totalFuel")

    val totalFuel2 = moduleMasses.map { calculateTotalFuel1(it) }.sum()
    println("Part2: $totalFuel2")
}
