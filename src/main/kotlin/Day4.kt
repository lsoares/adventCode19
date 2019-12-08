object Day4 {

    fun isValid1(input: Int) =
        input in (100000..999999) && input.countConsecutivePairs() > 0 && input.increases()

    fun isValid2(input: Int): Boolean {
        return input in (100000..999999) && input.getCounters().contains(1) && input.increases()
    }

    private fun Int.countConsecutivePairs() =
        toString().zipWithNext().count { it.first == it.second }

    private fun Int.getCounters(): List<Int> {
        val res = IntArray(6)
        var consec = 0
        for (i in 1 until toString().length) {
            if (toString()[i] == toString()[i - 1]) res[consec]++
            else consec++
        }
        return res.toList()
    }

    private fun Int.increases() =
        toString().zipWithNext().all { it.first <= it.second }
}
