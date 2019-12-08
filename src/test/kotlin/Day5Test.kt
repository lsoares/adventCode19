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
        val state = pair.first.toMutableList()
        Day5.compute(state)
        assertEquals(pair.second, state)
    }

    @Test
    fun `multiply with position and immediate (4~33 * 3 = 99)`() {
        val state = mutableListOf(1002, 4, 3, 4, 33)
        Day5.compute(state)
        assertEquals(listOf(1002, 4, 3, 4, 99), state)
    }

    @Test
    fun `set position 5 as 666`() {
        val state = mutableListOf(3, 5, 99, 0, 0, -1)
        Day5.compute(state, 666)
        assertEquals(listOf(3, 5, 99, 0, 0, 666), state)
    }

    @Test
    fun `prints the 5th position`() {
        assertEquals(-1, Day5.compute(mutableListOf(4, 5, 99, 0, 0, -1)).last())
    }

    @Test
    fun exercise1() {
        val inputStream = this::class.java.getResourceAsStream("day5.txt")
        val row = Scanner(inputStream).nextLine()
        val input = row.split(",").map { it.toInt() }.toMutableList()

        assertEquals(11933517, Day5.compute(input).last())
    }

    @Test
    fun `is equals to 8? (position mode)`() {
        val initialState = listOf(3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8)

        assertEquals(1, Day5.compute(initialState.toMutableList(), 8).last())
        assertEquals(0, Day5.compute(initialState.toMutableList(), 88).last())
    }

    @Test
    fun `is equals to 8? (immediate mode)`() {
        val initialState = listOf(3, 3, 1108, -1, 8, 3, 4, 3, 99)

        assertEquals(1, Day5.compute(initialState.toMutableList(), 8).last())
        assertEquals(0, Day5.compute(initialState.toMutableList(), 88).last())
    }

    @Test
    fun `is less than 8? (position mode)`() {
        val initialState = listOf(3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8)

        assertEquals(1, Day5.compute(initialState.toMutableList(), -8).last())
        assertEquals(0, Day5.compute(initialState.toMutableList(), 9).last())
    }

    @Test
    fun `is less than 8? (immediate mode)`() {
        val initialState = listOf(3, 3, 1107, -1, 8, 3, 4, 3, 99)

        assertEquals(1, Day5.compute(initialState.toMutableList(), -8).last())
        assertEquals(0, Day5.compute(initialState.toMutableList(), 9).last())
    }
}