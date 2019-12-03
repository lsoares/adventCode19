import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

object TestDay1Part1 {

    @JvmStatic
    fun `input`() = setOf(12 to 2, 14 to 2, 1969 to 654, 100756 to 33583)

    @ParameterizedTest
    @MethodSource("input")
    fun `basic input`(value: Pair<Int, Int>) {
        assertEquals(value.second, Day1Part1.calc(value.first))
    }

    @Test
    fun exercise() {
        val inputStream = this::class.java.getResourceAsStream("day1part1.txt")
        val sum = Scanner(inputStream).asSequence().map { Day1Part1.calc(it.toInt()) }.sum()
        assertEquals(3423279, sum)
    }
}
