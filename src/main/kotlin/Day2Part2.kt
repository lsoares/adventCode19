object Day2Part2 {

    fun findSolution(solution: Int, source: List<Int>): Pair<Int, Int>? {
        for (nounIdx in 1..99) {
            for (verbIdx in 1..99) {
                if (calc(nounIdx, verbIdx, source) == solution) {
                    return nounIdx to verbIdx
                }
            }
        }
        return null
    }

    private fun calc(noun: Int, verb: Int, source: List<Int>): Int {
        val initialState = listOf(source.first()) + listOf(noun, verb) + source.drop(3)
        val finalState = Day2Part1.calc(initialState)
        return finalState.first()
    }
}
