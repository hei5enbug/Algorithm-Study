fun main() {
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(4, 0),
        intArrayOf(5, 1),
        intArrayOf(6, 1),
        intArrayOf(7, 2),
        intArrayOf(7, 3),
        intArrayOf(4, 5),
        intArrayOf(5, 6),
        intArrayOf(6, 7),
    )
    DevBackend3().solution(8, edges, 4, 0, 3)
}

class DevBackend3 {
    fun solution(n: Int, edges: Array<IntArray>, k: Int, a: Int, b: Int): Int {
        var answer: Int = -1

        val graph = Array(n) { IntArray(n) { 0 } }
        edges.map { edge ->
            val x = edge[0]
            val y = edge[1]
            graph[x][y] = 1
            graph[y][x] = 1
        }

        fun bfs(seen: HashSet<Int>, target: Int, depth: Int) {
            if (depth >= n || depth > k || target == b) {
                return
            }
            println(seen.toString())

            for (index in graph[target].indices) {
                val link = graph[target][index]
                if (link == 1) {
                    seen.add(index)
                    bfs(seen, index, depth + 1)
                }
            }
        }

        bfs(hashSetOf(), a, 0)

        printGraph(graph)

        return answer
    }


}

fun printGraph(graph: Array<IntArray>) {
    graph.map {
        it.map { dot ->
            print("$dot ")
        }
        println()
    }
}