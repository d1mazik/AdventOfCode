package AOC2021Day1

/**
Uppdaterade lösningen använder två högre ordningsfunktioner zipWithNext() och windowed().
Funktionen zipWithNext() skapar en sekvens av par av närliggande element från listan,
vilket gör det möjligt att jämföra varje element med sitt nästa element och därigenom
räkna antalet ökningar i djupmätningen (part1). Funktionen windowed() skapar en rullande
sekvens av delmängder från listan, var och en med fem element, och därigenom möjliggör
att räkna antalet ökningar i summan av de senaste tre djupmätningarna (part2).
 */

import java.io.File

fun main() {
    val data = File("src/main/kotlin/AOC2021_1.txt").readLines().map { it.toInt() }

    val part1 = data.zipWithNext().count { (a, b) -> a < b }

    val part2 = data.windowed(5).count { it.take(3).sum() < it.takeLast(3).sum() }

    println("Part 1: $part1")
    println("Part 2: $part2")
}