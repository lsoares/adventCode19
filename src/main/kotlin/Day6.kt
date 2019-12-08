object Day6 {

    fun calcOrbitCount(orbitsStr: List<String>): Int {
        val orbits = calcGraph(orbitsStr)
        return orbits.map { visit(orbits, it.key) }.sum()
    }

    fun calcMinJumps(orbitsStr: List<String>): Int {
        val orbits = calcGraph(orbitsStr)
        val pathYou = mutableListOf<String>()
        orbits.pathTill("YOU", "COM", pathYou)
        val pathSan = mutableListOf<String>()
        orbits.pathTill("SAN", "COM", pathSan)

        return pathYou.size + pathSan.size - (2 * pathYou.intersect(pathSan).size)
    }

    private fun Map<String, String>.pathTill(source: String, target: String, path: MutableList<String>) {
        val parent = get(source) ?: throw RuntimeException("no parent")
        path.add(parent)
        when (parent) {
            target -> return
            else -> pathTill(parent, target, path)
        }
    }

    private fun calcGraph(orbitsStr: List<String>) =
        orbitsStr.map {
            val split = it.split(")")
            split[1] to split[0]
        }.toMap()

    private fun visit(orbits: Map<String, String>, current: String): Int =
        when (current) {
            "COM" -> 0
            else -> 1 + visit(orbits, orbits[current] ?: throw RuntimeException("no parent"))
        }
}
