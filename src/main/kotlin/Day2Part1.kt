object Day2Part1 {

    fun calc(source: List<Int>): List<Int> {
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
}
