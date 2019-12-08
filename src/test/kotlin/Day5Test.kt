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
    fun exercise() {
        val inputStream = this::class.java.getResourceAsStream("day5.txt")
        val row = Scanner(inputStream).nextLine()
        val input = row.split(",").map { it.toInt() }.toList()

        // exercise 1
        assertEquals(11933517, Day5.compute(input.toMutableList()).last())
        // exercise 2
        assertEquals(10428568, Day5.compute(input.toMutableList(), 5).last())
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

    @Test
    fun `jump if false (position mode)`() {
        val initialState = listOf(3, 12, 6, 12, 15, 1, 13, 14, 13, 4, 13, 99, -1, 0, 1, 9)

        assertEquals(0, Day5.compute(initialState.toMutableList(), 0).last())
        assertEquals(1, Day5.compute(initialState.toMutableList(), 3).last())
    }

    @Test
    fun `jump if true (immediate mode)`() {
        val initialState = listOf(3, 3, 1105, -1, 9, 1101, 0, 0, 12, 4, 12, 99, 1)

        assertEquals(0, Day5.compute(initialState.toMutableList(), 0).last())
        assertEquals(1, Day5.compute(initialState.toMutableList(), 3).last())
    }

    @Test
    fun `999 if input LT 8 , 1000 if input EQ 8 , 1001 if input GT 8`() {
        val initialState = listOf(
            3, 21, 1008, 21, 8, 20, 1005, 20, 22, 107, 8, 21, 20, 1006, 20, 31,
            1106, 0, 36, 98, 0, 0, 1002, 21, 125, 20, 4, 20, 1105, 1, 46, 104,
            999, 1105, 1, 46, 1101, 1000, 1, 20, 4, 20, 1105, 1, 46, 98, 99
        )

        assertEquals(999, Day5.compute(initialState.toMutableList(), 7).last())
        assertEquals(1000, Day5.compute(initialState.toMutableList(), 8).last())
        assertEquals(1001, Day5.compute(initialState.toMutableList(), 9).last())
    }
}