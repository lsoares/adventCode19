object Day2 {

    fun calc(source: List<Int>): List<Int> {
        val input = source.toMutableList()
        var i = 0
        while (i < input.size) {
            if (input[i] == 1 || input[i] == 2) {
                val a = input[i + 1]
                val b = input[i + 2]
                val target = input[i + 3]
                if (input[i] == 1)
                    input[target] = input[a] + input[b]
                else
                    input[target] = input[a] * input[b]
                i += 4
            } else break
        }
        return input
    }
}
