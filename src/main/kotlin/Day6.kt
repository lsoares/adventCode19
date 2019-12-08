object Day6 {

    fun calc(input: List<String>): Int {
        val orbits = input.map {
            val split = it.split(")")
            split[1] to split[0]
        }.toMap()
        return orbits.keys.map { visit(orbits, it) }.sum()
    }

    private fun visit(orbits: Map<String, String>, current: String): Int =
        when (current) {
            "COM" -> 0
            else -> 1 + visit(orbits, orbits[current] ?: throw RuntimeException("no parent"))
        }
}
