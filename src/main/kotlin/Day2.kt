object Day2 {

    fun compute(initialState: List<Int>): List<Int> {
        val state = initialState.toMutableList()
        var ip = 0
        while (ip < state.size) {
            val opCode = state[ip]
            if (opCode == 1 || opCode == 2) {
                val a = state[ip + 1]
                val b = state[ip + 2]
                val target = state[ip + 3]
                if (opCode == 1)
                    state[target] = state[a] + state[b]
                else
                    state[target] = state[a] * state[b]
                ip += 4
            } else break
        }
        return state
    }

    fun calc(noun: Int, verb: Int, source: List<Int>): Int {
        val initialState = listOf(source.first()) + listOf(noun, verb) + source.drop(3)
        return compute(initialState).first()
    }
}
