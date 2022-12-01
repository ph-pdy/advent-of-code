fun main() {
    fun part1(input: List<String>): Int =
        input.sumCalories().max()

    fun part2(input: List<String>): Int =
        input.sumCalories().apply { sortDescending() }.take(3).sum()

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

fun List<String>.sumCalories() =
    fold(mutableListOf(0)) { acc, s ->
        if (s.isEmpty()) acc.add(0)
        else acc[acc.lastIndex] = acc.last() + s.toInt()
        acc
    }
