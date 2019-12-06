import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.*

object Day1Test {

    @JvmStatic
    @Suppress("unused")
    fun input1() = setOf(12 to 2, 1969 to 654, 100756 to 33583)

    @ParameterizedTest
    @MethodSource("input1")
    fun `part 1`(value: Pair<Int, Int>) {
        assertEquals(value.second, Day1.calcBasic(value.first))
    }

    @JvmStatic
    @Suppress("unused")
    fun input2() = setOf(14 to 2, 1969 to 966, 100756 to 50346)

    @ParameterizedTest
    @MethodSource("input2")
    fun `part 2`(value: Pair<Int, Int>) {
        assertEquals(value.second, Day1.calcRec(value.first))
    }

    @Test
    fun exercise() {
        val inputStream = this::class.java.getResourceAsStream("day1.txt")
        val input = Scanner(inputStream).asSequence().map { it.toInt() }.toList()

        val sum1 = input.map { Day1.calcBasic(it) }.sum()
        assertEquals(3423279, sum1)

        val sum2 = input.map { Day1.calcRec(it) }.sum()
        assertEquals(5132018, sum2)
    }
}
