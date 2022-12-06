import java.io.File

class Day5 {
    companion object {
        fun parseFile(): Pair<MutableList<ArrayDeque<Char>>, List<List<Int>>> {
            val fileContent = File("day5.txt").readText()
            val (stacksArrangement, moveInstructions) = fileContent.split("\n\n", limit = 2)

            val stackCount = stacksArrangement.lines().last().trim().split(Regex(" +")).size
            val stacks = MutableList(stackCount) { ArrayDeque<Char>() }
            stacksArrangement.lines().reversed().drop(1).forEach { line ->
                for ((stackIndex, linePos) in (1 until line.length step 4).withIndex()) {
                    if (line[linePos] != ' ') {
                        stacks[stackIndex].add(line[linePos])
                    }
                }
            }

            val instructions = moveInstructions.trim().lines()
                .map {
                    it.split(" ")
                }
                .map {
                    it.slice(1 until it.size step 2).map(String::toInt)
                }
            return Pair(stacks, instructions)
        }

        fun part1() {
            val (stacks, instructions) = parseFile()
            instructions.forEach { (amount, from, to) ->
                repeat(amount) { stacks[to-1].add(stacks[from-1].removeLast()) }
            }
            print("Day 5 Part 1: ")
            stacks.forEach { print(it.last()) }
            println()
        }

        fun part2() {
            val (stacks, instructions) = parseFile()
            instructions.forEach { (amount, from, to) ->
                val temp = mutableListOf<Char>()
                repeat(amount) { temp.add(0, stacks[from-1].removeLast()) }
                stacks[to-1].addAll(temp)
            }
            print("Day 5 Part 2: ")
            stacks.forEach { print(it.last()) }
            println()
        }
    }
}