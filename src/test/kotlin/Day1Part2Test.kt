import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

object Day1Part2Test {

    @JvmStatic
    fun input() = setOf(14 to 2, 1969 to 966, 100756 to 50346)

    @ParameterizedTest
    @MethodSource("input")
    fun `basic input`(value: Pair<Int, Int>) {
        assertEquals(value.second, Day1Part2.calc(value.first))
    }

    @Test
    fun exercise() {
        val inputStream = this::class.java.getResourceAsStream("day1.txt")
        val sum = Scanner(inputStream).asSequence().map { Day1Part2.calc(it.toInt()) }.sum()
        assertEquals(5132018, sum)
    }
}
