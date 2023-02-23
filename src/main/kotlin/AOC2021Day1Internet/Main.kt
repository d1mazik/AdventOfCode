package AOC2021Day1Internet

//https://github.com/antonarhipov/advent-of-code-2021/blob/main/src/Day01.kt

/**
 * Koden läser in en lista av heltal från en fil, och definierar två funktioner: part1 som räknar antalet ökningar i listan,
 * och part2 som räknar antalet ökningar i summan av de tre senaste elementen
 * i listan. Funktionerna använder högre ordning funktioner såsom windowed, count och sum för att hantera iteration
 * och beräkningar på listan.
 */
import java.io.File

fun main() {
    fun part1(input: List<Int>): Int {
        return input.windowed(2).count { (a, b) -> a < b }
    }

    // A + B + C <=> B + C + D
    fun part2(input: List<Int>): Int {
        return input
            .windowed(4)
            .count {
                it[0] < it[3]
            }
    }

    val input = readInputAsInts("AOC2021_1")
    println(part1(input))
    println(part2(input))
}

fun readInputAsInts(name: String) = File("src/main/kotlin", "$name.txt").readLines().map { it.toInt() }