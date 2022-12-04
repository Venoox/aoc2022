import java.io.File

class Day1 {
    companion object {
        fun part1() {
            val maxCalories = File("day1.txt")
                .readText()
                .trim()
                .split("\n\n")
                .maxOfOrNull { elfCalories ->
                    elfCalories.split("\n").sumOf { calories -> calories.toInt() }
                }
            println(maxCalories)
        }

        fun part2() {
            val maxCalories = File("day1.txt")
                .readText()
                .trim()
                .split("\n\n")
                .map { elfCalories ->
                    elfCalories.split("\n").sumOf { calories -> calories.toInt() }
                }
                .sortedDescending()
                .take(3)
                .sum()
            println(maxCalories)
        }
    }
}