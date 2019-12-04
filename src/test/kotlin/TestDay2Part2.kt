import org.junit.jupiter.api.Test
import java.util.*

object TestDay2Part2 {

    @Test
    fun exercise() {
        val inputStream = this::class.java.getResourceAsStream("day2.txt")
        val row = Scanner(inputStream).nextLine()
        val input = row.split(",").map { it.toInt() }.toList()
        for (noun in 1..99) {
            for (verb in 1..99) {
                if (Day2Part2.calc(noun, verb, input) == 19690720) {
                    println("found result for noun $noun, verb $verb")
                    println("result is: ${100 * noun + verb}")
                }
            }
        }
    }
}