package AOC2021Day1

/***
Min lösning använder två loopar för att lösa problemet. En loop räknar antalet ökningar i djupmätningen (part1),
och den andra loopen räknar antalet ökningar i summan av de senaste tre djupmätningarna (part2).
 */

/**
 * Fråga 1
 * Du behöver räkna antalet mätningar som är större än den föregående mätningen.
 */

import java.io.File

fun main() {
    //Koden läser in en fil som innehåller en lista av strängar som representerar heltal. Därefter konverteras varje
    //sträng i listan till heltal med hjälp av map-metoden, vilket resulterar i en lista av heltal.
    val data = File("src/main/kotlin/AOC2021_1.txt").readLines().map { it.toInt() }

    // Räknar antalet ökningar i djupmätningen
    // Loopar igenom alla djupmätningar från den andra till den sista (första djupmätningen kan inte öka)
    // Om det här djupet är större än det förra, räknas det som en ökning
    var part1 = 0
    var lastDepth = data[0]
    for (depth in data.subList(1, data.size)) {
        if (depth > lastDepth) {
            part1++
        }
        lastDepth = depth
    }

    /**
     * Fråga 2
     * Antalet ökingar av de 3 senaste djupmätningar.
     */

    // Räknar antalet ökningar i summan av de senaste tre djupmätningarna
    // Beräknar summan av de första tre djupmätningarna
    // Loopar igenom alla djupmätningar från den fjärde till den sista
    // Beräknar summan av de tre senaste djupmätningarna
    // Om den nya summan är större än den förra, räknas det som en ökning
    var part2 = 0
    var sum = data.slice(0..2).sum()
    for (i in 3 until data.size) {
        val newSum = sum + data[i] - data[i - 3]
        if (newSum > sum) {
            part2++
        }
        sum = newSum
    }

    println("Part 1: $part1")
    println("Part 2: $part2")
}
