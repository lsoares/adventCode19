import kotlin.math.floor

object Day1Part2 {

    fun calc(mass: Int): Int {
        val result = (floor(mass / 3.0) - 2).toInt()
        return when {
            result <= 0 -> 0
            else -> result + calc(result)
        }
    }
}