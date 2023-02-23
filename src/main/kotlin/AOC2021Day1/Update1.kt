package AOC2021Day1

import java.io.File

// Istället för loop använder jag windowed metoden för att generera en lista av listor med två och fyra
// efterföljande element, och sedan räknar man antalet ökningar
// i dessa listor med hjälp av högre ordning funktioner som count
// och sum. Detta gör koden kortare och mer lättläst, eftersom man
// slipper skriva en loop och istället låter högre ordning funktioner hantera iterationen
// och man använder mer Kotlin syntax, t.ex lambda funktion och variabel it

fun main() {

    val data = File("src/main/kotlin/AOC2021_1.txt").readLines().map { it.toInt() }

    // windowed(2) genererar en lista av listor med två efterföljande element
    // count räknar antalet listor där det första elementet är mindre än det andra
    val part1 = data.windowed(2).count { it[0] < it[1] }


    // Räkna antalet ökningar i summan av de tre senaste djupmätningarna
    // windowed(4) genererar en lista av listor med fyra efterföljande element
    // take(3) returnerar de första tre elementen i listan
    // drop(1) tar bort det första elementet i listan
    // take(3) returnerar de tre sista elementen i den återstående listan
    // sum() summerar elementen i listan
    // count räknar antalet listor där summan av de tre första elementen är mindre än summan av de tre sista
    val part2 = data.windowed(4).count { it.take(3).sum() < it.drop(1).take(3).sum() }

    println("Part 1: $part1")
    println("Part 2: $part2")
}