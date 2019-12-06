import kotlin.math.floor

object Day1 {

    fun calcBasic(mass: Int) = (floor(mass / 3.0) - 2).toInt()

    fun calcRec(mass: Int): Int {
        val result = calcBasic(mass)
        return when {
            result <= 0 -> 0
            else -> result + calcRec(result)
        }
    }
}