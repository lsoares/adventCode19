object Day2 {

    fun compute(source: List<Int>): List<Int> {
        val input = source.toMutableList()
        var ip = 0
        while (ip < input.size) {
            val opCode = input[ip]
            if (opCode == 1 || opCode == 2) {
                val a = input[ip + 1]
                val b = input[ip + 2]
                val target = input[ip + 3]
                if (opCode == 1)
                    input[target] = input[a] + input[b]
                else
                    input[target] = input[a] * input[b]
                ip += 4
            } else break
        }
        return input
    }

    fun execute(noun: Int, verb: Int, source: List<Int>): Int {
        val initialState = listOf(source.first()) + listOf(noun, verb) + source.drop(3)
        val finalState = compute(initialState)
        return finalState.first()
    }
}
