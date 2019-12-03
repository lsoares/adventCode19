import kotlin.math.floor

object Day1Part1 {

    fun calc(mass: Int) = (floor(mass / 3.0) - 2).toInt()
}