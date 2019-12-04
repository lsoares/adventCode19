object Day2Part2 {

    fun calc(input1: Int, input2: Int, source: List<Int>): Int {
        val initialState = listOf(source.first()) + listOf(input1, input2) + source.drop(3)
        val finalState = Day2Part1.calc(initialState)
        return finalState.first()
    }
}
