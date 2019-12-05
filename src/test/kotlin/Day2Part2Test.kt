import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

object Day2Part2Test {

    @Test
    fun exercise() {
        val inputStream = this::class.java.getResourceAsStream("day2.txt")
        val row = Scanner(inputStream).nextLine()
        val input = row.split(",").map { it.toInt() }.toList()

        val nounAndVerb = Day2Part2.findSolution(19690720, input)

        assertEquals(51 to 21, nounAndVerb)
        assertEquals(5121, nounAndVerb!!.first * 100 + nounAndVerb.second)
    }
}