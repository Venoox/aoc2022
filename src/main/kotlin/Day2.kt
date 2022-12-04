import java.io.File

class Day2 {
    companion object {
        const val LOSE = 0;
        const val DRAW = 3;
        const val WIN = 6;

        const val ROCK = 1; // ROCK
        const val PAPER = 2; // PAPER
        const val SCISSORS = 3; // SCISSORS

        fun getMove(move: Char): Int {
            return when (move) {
                'A', 'X' -> ROCK
                'B', 'Y' -> PAPER
                'C', 'Z' -> SCISSORS
                else -> 0
            }
        }

        fun calculateOutcome(otherMove: Int, yourMove: Int): Int {
            if (otherMove == yourMove) return DRAW
            if (otherMove == SCISSORS) {
                when (yourMove) {
                    ROCK -> return WIN
                    PAPER -> return LOSE
                }
            } else if (otherMove == ROCK) {
                when (yourMove) {
                    SCISSORS -> return LOSE
                    PAPER -> return WIN
                }
            } else if (otherMove == PAPER) {
                when (yourMove) {
                    SCISSORS -> return WIN
                    ROCK -> return LOSE
                }
            }
            return 0;
        }
        fun getScore(otherMove: Char, yourMove: Char): Int {
            val otherMove = getMove(otherMove)
            val yourMove = getMove(yourMove)
            return yourMove + calculateOutcome(otherMove, yourMove)
        }

        fun part1() {
            val totalScore = File("day2.txt")
                .readLines().sumOf {
                    getScore(it[0], it[2])
                }
            println(totalScore)
        }

        fun getOutcome(outcome: Char): Int {
            return when (outcome) {
                'X' -> LOSE
                'Y' -> DRAW
                'Z' -> WIN
                else -> 0
            }
        }

        fun calculateScore(otherMove: Int, outcome: Int): Int {
            if (outcome == DRAW) return outcome + otherMove
            return outcome + when (otherMove) {
                ROCK -> when (outcome) {
                    WIN -> PAPER
                    LOSE -> SCISSORS
                    else -> 0
                }
                SCISSORS -> when (outcome) {
                    WIN -> ROCK
                    LOSE -> PAPER
                    else -> 0
                }
                PAPER -> when (outcome) {
                    WIN -> SCISSORS
                    LOSE -> ROCK
                    else -> 0
                }
                else -> 0
            }
        }

        fun part2() {
            val totalScore = File("day2.txt")
                .readLines().sumOf {
                    calculateScore(getMove(it[0]), getOutcome(it[2]))
                }
            println(totalScore)
        }
    }
}