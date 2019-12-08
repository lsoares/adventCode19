import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

object Day7Test {

    @JvmStatic
    @Suppress("unused")
    fun `part 1`() = setOf(
        mutableListOf(
            3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0
        ) to 43210,
        mutableListOf(
            3, 23, 3, 24, 1002, 24, 10, 24, 1002, 23, -1, 23, 101, 5, 23, 23, 1, 24,
            23, 23, 4, 23, 99, 0, 0
        ) to 54321,
        mutableListOf(
            3, 31, 3, 32, 1002, 32, 10, 32, 1001, 31, -2, 31, 1007, 31, 0, 33,
            1002, 33, 7, 33, 1, 33, 31, 31, 1, 32, 31, 31, 4, 31, 99, 0, 0, 0
        ) to 65210
    )

    @ParameterizedTest
    @MethodSource
    fun `part 1`(testCase: Pair<MutableList<Int>, Int>) {
        assertEquals(testCase.second, Day7.getMaxThrust(testCase.first))
    }

    @Test
    fun exercise() {
        val inputStream = this::class.java.getResourceAsStream("day7.txt")
        val input = Scanner(inputStream).nextLine().split(",").map { it.toInt() }

        assertEquals(273814, Day7.getMaxThrust(input.toMutableList()))
    }
}