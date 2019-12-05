import kotlin.math.abs

object Day3Part1 {

    private val CENTER = Point(0, 0)

    fun calcRanges(wire1: List<String>, wire2: List<String>) =
        wire1.map(::Move).traverse()
            .intersect(wire2.map(::Move).traverse())
            .map { it distanceTo CENTER }
            .min()

    private fun List<Move>.traverse(): Set<Point> {
        var lastPoint = CENTER
        return map { move ->
            (1..move.amount).map {
                lastPoint = lastPoint.move(Move(move.direction, 1))
                lastPoint
            }
        }.flatten().toSet()
    }

    data class Point(val x: Int, val y: Int) {
        fun move(move: Move) = when (move.direction) {
            Direction.L -> Point(x - move.amount, y)
            Direction.R -> Point(x + move.amount, y)
            Direction.U -> Point(x, y + move.amount)
            Direction.D -> Point(x, y - move.amount)
        }

        infix fun distanceTo(other: Point) = abs(x - other.x) + abs(y - other.y)
    }

    data class Move(val direction: Direction, val amount: Int) {
        constructor(move: String) : this(
            Direction.valueOf(move.substring(0, 1)),
            move.substring(1).toInt()
        )
    }

    enum class Direction { U, D, L, R }
}

