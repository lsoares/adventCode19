object Day5 {

    fun compute(initialState: List<Int>, input: Int = 1): List<Int> {
        val state = initialState.toMutableList()
        var ip = 0
        fun getArg(arg: Int, mode: Mode = Mode.POSITION) = when (mode) {
            Mode.IMMEDIATE -> state[ip + arg]
            Mode.POSITION -> state[state[ip + arg]]
        }

        fun setArg(arg: Int, value: Int) {
            state[state[ip + arg]] = value
        }

        while (ip < state.size) {
            val op = Operation(state[ip])
            when (op.code) {
                Op.ADD ->
                    setArg(3, getArg(1, op.param1Mode) + getArg(2, op.param2Mode))
                Op.MULTIPLY ->
                    setArg(3, getArg(1, op.param1Mode) * getArg(2, op.param2Mode))
                Op.SET -> setArg(1, input)
                Op.PRINT -> println(getArg(1))
                Op.HALT -> return state
            }
            ip += 1 + op.code.paramCount
        }
        return state
    }

    data class Operation(val value: Int) {
        private val instruction get() = value.toString().padStart(5, '0')
        val param1Mode get() = getMode(2)
        val param2Mode get() = getMode(1)
        val code
            get() = when (instruction.takeLast(2).toInt()) {
                1 -> Op.ADD
                2 -> Op.MULTIPLY
                3 -> Op.SET
                4 -> Op.PRINT
                99 -> Op.HALT
                else -> throw IllegalArgumentException(instruction.takeLast(2))
            }

        private fun getMode(pos: Int) =
            when (instruction[pos]) {
                '0' -> Mode.POSITION
                '1' -> Mode.IMMEDIATE
                else -> throw IllegalArgumentException(instruction[pos].toString())
            }
    }

    enum class Mode { IMMEDIATE, POSITION }
    enum class Op(val paramCount: Int) {
        ADD(3), MULTIPLY(3), HALT(0), SET(1), PRINT(1)
    }
}
