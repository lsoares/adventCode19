import com.github.shiguruikai.combinatoricskt.permutations

object Day7 {
    private const val AMP_COUNT = 5

    fun getMaxThrust(initialState: MutableList<Int>) =
        (0..4).permutations(AMP_COUNT).toList().map { phaseSettings ->
            runAmplifiers(initialState, phaseSettings)
        }.max()!!

    private fun runAmplifiers(initialState: List<Int>, phaseSettings: List<Int>): Int {
        var lastOut = 0
        repeat(AMP_COUNT) {
            lastOut = Day5.compute(initialState.toMutableList(), listOf(phaseSettings[it], lastOut)).last()
        }
        return lastOut
    }
}