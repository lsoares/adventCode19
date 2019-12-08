import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

object Day6Test {

    @Test
    fun test1() {
        assertEquals(6, Day6.calc(listOf("COM)C", "C)B", "B)A")))
    }

    @Test
    fun test2() {
        assertEquals(
            42,
            Day6.calc(listOf("COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L"))
        )
    }

    @Test
    fun exercise() {
        val inputStream = this::class.java.getResourceAsStream("day6.txt")
        val input = Scanner(inputStream).asSequence().toList()

        assertEquals(234446, Day6.calc(input))
    }
}