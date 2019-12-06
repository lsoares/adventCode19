import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.*

object Day3Test {

    @Test
    fun test1() {
        val wire1 = listOf("R8", "U5", "L5", "D3")
        val wire2 = listOf("U7", "R6", "D4", "L4")

        assertEquals(6, Day3.calcClosestIntersection(wire1, wire2))
        assertEquals(30, Day3.calcSteps(wire1, wire2))
    }

    @Test
    fun test2() {
        val wire1 = listOf("R75", "D30", "R83", "U83", "L12", "D49", "R71", "U7", "L72")
        val wire2 = listOf("U62", "R66", "U55", "R34", "D71", "R55", "D58", "R83")

        assertEquals(159, Day3.calcClosestIntersection(wire1, wire2))
        assertEquals(610, Day3.calcSteps(wire1, wire2))
    }

    @Test
    fun test3() {
        val wire1 = listOf("R98", "U47", "R26", "D63", "R33", "U87", "L62", "D20", "R33", "U53", "R51")
        val wire2 = listOf("U98", "R91", "D20", "R16", "D67", "R40", "U7", "R15", "U6", "R7")

        assertEquals(135, Day3.calcClosestIntersection(wire1, wire2))
        assertEquals(410, Day3.calcSteps(wire1, wire2))
    }

    @Test
    fun exercise() {
        val scanner = Scanner(this::class.java.getResourceAsStream("day3.txt"))
        val wire1 = scanner.nextLine().split(",")
        val wire2 = scanner.nextLine().split(",")

        assertEquals(8015, Day3.calcClosestIntersection(wire1, wire2))
        assertEquals(163676, Day3.calcSteps(wire1, wire2))
    }
}