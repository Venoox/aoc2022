import java.io.File

class Day3 {
    companion object {
        fun part1() {
            println(File("day3.txt")
                .readLines()
                .sumOf {
                    (it.toList().subList(0, it.length/2).toSet() intersect it.toList().subList(it.length/2, it.length).toSet())
                        .sumOf { if (it in 'A'..'Z') it.code - 'A'.code + 27 else it.code - 'a'.code + 1 }
                })
        }

        fun part2() {
            println(File("day3.txt")
                .readLines()
                .chunked(3)
                .sumOf {
                    (it[0].toSet() intersect it[1].toSet() intersect it[2].toSet())
                        .sumOf { if (it in 'A'..'Z') it.code - 'A'.code + 27 else it.code - 'a'.code + 1 }
                }
            )
        }
    }
}