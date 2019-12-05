object Day3Part2 {

    private val CENTER = Point(0, 0)

    fun calcSteps(wire1: List<String>, wire2: List<String>): Int? {
        val traverse1 = wire1.map(::Move).traverse()
        val traverse2 = wire2.map(::Move).traverse()

        return traverse1.keys.intersect(traverse2.keys).map {
            traverse1.getValue(it) + traverse2.getValue(it)
        }.min()
    }

    private fun List<Move>.traverse(): Map<Point, Int> {
        var lastPoint = CENTER
        var steps = 0
        return map { move ->
            (1..move.amount).map {
                lastPoint = lastPoint.move(Move(move.direction, 1))
                steps++
                Pair(lastPoint, steps)
            }
        }.flatten().toMap()
    }

    private data class Point(val x: Int, val y: Int) {
        fun move(move: Move) = when (move.direction) {
            Direction.L -> Point(x - move.amount, y)
            Direction.R -> Point(x + move.amount, y)
            Direction.U -> Point(x, y + move.amount)
            Direction.D -> Point(x, y - move.amount)
        }
    }

    private data class Move(val direction: Direction, val amount: Int) {
        constructor(move: String) : this(
            Direction.valueOf(move.substring(0, 1)),
            move.substring(1).toInt()
        )
    }

    enum class Direction { U, D, L, R }
}

