import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

object Day2Test {

    @JvmStatic
    @Suppress("unused")
    fun input() = setOf(
        listOf(1, 0, 0, 0, 99) to listOf(2, 0, 0, 0, 99),
        listOf(2, 3, 0, 3, 99) to listOf(2, 3, 0, 6, 99),
        listOf(2, 4, 4, 5, 99, 0) to listOf(2, 4, 4, 5, 99, 9801),
        listOf(1, 1, 1, 4, 99, 5, 6, 0, 99) to listOf(30, 1, 1, 4, 2, 5, 6, 0, 99),
        listOf(1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50)
                to listOf(3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50)
    )

    @ParameterizedTest
    @MethodSource("input")
    fun basic(pair: Pair<List<Int>, List<Int>>) {
        assertEquals(pair.second, Day2.compute(pair.first))
    }

    @Test
    fun exercise() {
        val inputStream = this::class.java.getResourceAsStream("day2.txt")
        val row = Scanner(inputStream).nextLine()
        val input = row.split(",").map { it.toInt() }.toList()

        assertEquals(4714701, Day2.execute(12, 2, input))

        val nounAndVerb = findSolution2(19690720, input)
        assertEquals(51 to 21, nounAndVerb)
    }

    private fun findSolution2(solution: Int, source: List<Int>): Pair<Int, Int>? {
        for (nounIdx in 1..99) {
            for (verbIdx in 1..99) {
                if (Day2.execute(nounIdx, verbIdx, source) == solution) {
                    return nounIdx to verbIdx
                }
            }
        }
        return null
    }
}