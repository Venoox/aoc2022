import java.io.File

class Day4 {
    companion object {
        fun part1() {
            println("Day 4 Part 1: " +
                File("day4.txt")
                    .readLines()
                    .map {
                        it.trim().split(",").map { it.split("-").map { it.toInt() } }
                    }
                    .map {(a, b) ->
                        if (a[0] <= b[0] && a[1] >= b[1] || b[0] <= a[0] && b[1] >= a[1]) 1 else 0
                    }
                    .sum()
            )
        }

        fun part2() {
            println("Day 4 Part 2: " +
                File("day4.txt")
                    .readLines()
                    .map {
                        it.trim().split(",").map { it.split("-").map { it.toInt() } }
                    }
                    .map {(a, b) ->
                        if (a[1] >= b[0] && a[0] <= b[1] || a[0] >= b[1] && a[1] <= b[0]) 1 else 0
                    }
                    .sum()
            )
        }
    }
}