package alg

fun main() {
    val computers = arrayOf(
        intArrayOf(1, 1, 1, 0, 0, 0),
        intArrayOf(1, 1, 1, 0, 0, 0),
        intArrayOf(1, 1, 1, 0, 0, 0),
        intArrayOf(0, 0, 0, 1, 1, 0),
        intArrayOf(0, 0, 0, 1, 1, 0),
        intArrayOf(0, 0, 0, 0, 0, 1),
    )

    Network().solution(4, computers)
}

class Network {
    private var answer = 0
    private var checkMap = hashSetOf<Int>()

    fun solution(n: Int, computers: Array<IntArray>): Int {

        for (i in computers.indices) {
            if (!checkMap.contains(i)) {
                dfs(computers, i)
                answer++
            }
        }
        println(answer)
        return answer
    }

    private fun dfs(computers: Array<IntArray>, depth: Int) {
        checkMap.add(depth)

        for (i in computers.indices) {
            if (depth != i && computers[depth][i] == 1 && !checkMap.contains(i)) {
                dfs(computers, i)
            }
        }
    }
}