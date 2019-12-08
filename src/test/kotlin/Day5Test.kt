import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

object Day5Test {

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
    fun `add and multiply by position`(pair: Pair<List<Int>, List<Int>>) {
        assertEquals(pair.second, Day5.compute(pair.first))
    }

    @Test
    fun `multiply with position and immediate (4~33 * 3 = 99)`() {
        assertEquals(
            listOf(1002, 4, 3, 4, 99),
            Day5.compute(listOf(1002, 4, 3, 4, 33))
        )
    }

    @Test
    fun `set position 5 as 666`() {
        assertEquals(
            listOf(3, 5, 99, 0, 0, 666),
            Day5.compute(listOf(3, 5, 99, 0, 0, -1), 666)
        )
    }

    @Test
    fun `prints the 5th position`() {
        Day5.compute(listOf(4, 5, 99, 0, 0, -1)) // prints -1
    }

    @Test
    fun exercise() {
        val inputStream = this::class.java.getResourceAsStream("day5.txt")
        val row = Scanner(inputStream).nextLine()
        val input = row.split(",").map { it.toInt() }.toList()

        Day5.compute(input) // prints 11933517
    }
}