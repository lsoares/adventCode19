import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

object Day3Part1Test {

    @Test
    fun test1() {
        val result = Day3Part1.calcRanges(
            listOf("R8", "U5", "L5", "D3"),
            listOf("U7", "R6", "D4", "L4")
        )

        assertEquals(6, result)
    }

    @Test
    fun test2() {
        val result = Day3Part1.calcRanges(
            listOf("R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72"),
            listOf("U62", "R66", "U55", "R34", "D71", "R55", "D58", "R83")
        )

        assertEquals(159, result)
    }

    @Test
    fun test3() {
        val result = Day3Part1.calcRanges(
            listOf("R98", "U47", "R26", "D63", "R33", "U87", "L62", "D20", "R33", "U53", "R51"),
            listOf("U98", "R91", "D20", "R16", "D67", "R40", "U7", "R15", "U6", "R7")
        )

        assertEquals(135, result)
    }

    @Test
    fun exercise() {
        val scanner = Scanner(this::class.java.getResourceAsStream("day3.txt"))
        val row1 = scanner.nextLine().split(",")
        val row2 = scanner.nextLine().split(",")

        assertEquals(8015, Day3Part1.calcRanges(row1, row2))
    }
}