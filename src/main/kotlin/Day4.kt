object Day4 {

    fun isValid(input: Int) =
        input in (111111..999999) && input.hasConsecutive() && input.increases()

    private fun Int.hasConsecutive() =
        toString().zipWithNext().any { it.first == it.second }

    private fun Int.increases() =
        toString().zipWithNext().all { it.first <= it.second }
}
