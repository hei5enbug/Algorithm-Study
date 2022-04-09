package kakao

fun main() {
    val info = intArrayOf(0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1)
    val edges = arrayOf(
        intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 4), intArrayOf(0, 8),
        intArrayOf(8, 7), intArrayOf(9, 10), intArrayOf(9, 11), intArrayOf(4, 3),
        intArrayOf(6, 5), intArrayOf(4, 6), intArrayOf(8, 9)
    )

    SheepAndWolf().solution(info, edges)
}

class SheepAndWolf {
    var answer: Int = 0

    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        val nextArray = Array(info.size) { arrayListOf<Int>() }
        edges.map { edge ->
            nextArray[edge[0]].add(edge[1])
        }

        dfs(info, nextArray, hashSetOf(0), 0, 0, 0)

        return answer
    }

    fun dfs(info: IntArray, nextArray: Array<ArrayList<Int>>, path: HashSet<Int>, current: Int, sheep: Int, wolf: Int) {
        var sheepCount = sheep
        var wolfCount = wolf
        if (info[current] == 0) {
            sheepCount++
            if(sheepCount > answer){
                answer = sheepCount
            }
        } else {
            wolfCount++
        }

        if (wolfCount >= sheepCount) {
            return
        }

        path.map {
            nextArray[it].map { next ->
                if (!path.contains(next)) {
                    val newPath = path.clone() as HashSet<Int>
                    newPath.add(next)
                    dfs(info, nextArray, newPath, next, sheepCount, wolfCount)
                    newPath.remove(next)
                }
            }
        }
        return
    }
}