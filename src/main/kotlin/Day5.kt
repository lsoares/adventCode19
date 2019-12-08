import Day5.Operation.Code
import Day5.Operation.Mode

object Day5 {

    fun compute(state: MutableList<Int>, input: List<Int> = listOf()): List<Int> {
        val inputMutable = input.toMutableList()
        var ip = 0
        fun getArg(arg: Int, mode: Mode) = when (mode) {
            Mode.IMMEDIATE -> state[ip + arg]
            Mode.POSITION -> state[state[ip + arg]]
        }

        fun setArg(arg: Int, value: Int) {
            state[state[ip + arg]] = value
        }

        val output = mutableListOf<Int>()
        while (ip < state.size) {
            var jumpTo = -1
            val op = Operation(state[ip])
            when (op.code) {
                Code.ADD ->
                    setArg(3, getArg(1, op.param1Mode) + getArg(2, op.param2Mode))
                Code.MULTIPLY ->
                    setArg(3, getArg(1, op.param1Mode) * getArg(2, op.param2Mode))
                Code.SET -> {
                    setArg(1, inputMutable[0])
                    inputMutable.removeAt(0)
                }
                Code.PRINT ->
                    output.add(getArg(1, op.param1Mode))
                Code.JUMP_IF_TRUE -> {
                    val isNonZero = getArg(1, op.param1Mode) != 0
                    if (isNonZero) jumpTo = getArg(2, op.param2Mode)
                }
                Code.JUMP_IF_FALSE -> {
                    val isZero = getArg(1, op.param1Mode) == 0
                    if (isZero) jumpTo = getArg(2, op.param2Mode)
                }
                Code.LESS_THAN -> {
                    val isLessThan = getArg(1, op.param1Mode) < getArg(2, op.param2Mode)
                    setArg(3, if (isLessThan) 1 else 0)
                }
                Code.EQUALS -> {
                    val isEquals = getArg(1, op.param1Mode) == getArg(2, op.param2Mode)
                    setArg(3, if (isEquals) 1 else 0)
                }
                Code.HALT -> return output
            }
            if (jumpTo != -1) ip = jumpTo
            else ip += 1 + op.code.paramCount
        }
        return output
    }

    data class Operation(val operationAs: Int) {
        private val operationAsStr get() = operationAs.toString().padStart(5, '0')
        val param1Mode get() = getMode(2)
        val param2Mode get() = getMode(1)
        val code
            get() = when (operationAsStr.takeLast(2).toInt()) {
                1 -> Code.ADD
                2 -> Code.MULTIPLY
                3 -> Code.SET
                4 -> Code.PRINT
                5 -> Code.JUMP_IF_TRUE
                6 -> Code.JUMP_IF_FALSE
                7 -> Code.LESS_THAN
                8 -> Code.EQUALS
                99 -> Code.HALT
                else -> throw IllegalArgumentException(operationAsStr.takeLast(2))
            }

        private fun getMode(pos: Int) =
            when (operationAsStr[pos]) {
                '0' -> Mode.POSITION
                '1' -> Mode.IMMEDIATE
                else -> throw IllegalArgumentException(operationAsStr[pos].toString())
            }

        enum class Mode { IMMEDIATE, POSITION }
        enum class Code(val paramCount: Int) {
            ADD(3),
            MULTIPLY(3),
            HALT(0),
            SET(1),
            PRINT(1),
            JUMP_IF_TRUE(2),
            JUMP_IF_FALSE(2),
            LESS_THAN(3),
            EQUALS(3)
        }
    }
}
