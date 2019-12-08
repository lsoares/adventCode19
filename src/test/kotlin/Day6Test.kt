import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

object Day6Test {

    @Test
    fun basic() {
        assertEquals(6, Day6.calcOrbitCount(listOf("COM)C", "C)B", "B)A")))
    }

    @Test
    fun example() {
        assertEquals(
            42,
            Day6.calcOrbitCount(listOf("COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L"))
        )
    }

    @Test
    fun minJumps() {
        val orbitsStr =
            listOf("COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L", "K)YOU", "I)SAN")

        assertEquals(4, Day6.calcMinJumps(orbitsStr, "YOU", "SAN"))
    }

    @Test
    fun exercise() {
        val inputStream = this::class.java.getResourceAsStream("day6.txt")
        val input = Scanner(inputStream).asSequence().toList()

        assertEquals(234446, Day6.calcOrbitCount(input))
        assertEquals(385, Day6.calcMinJumps(input, "YOU", "SAN"))
    }
}