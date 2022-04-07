fun main() {

    val board = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )
    val skill = arrayOf(
        intArrayOf(1, 1, 1, 2, 2, 4),
        intArrayOf(1, 0, 0, 1, 1, 2),
        intArrayOf(2, 2, 0, 2, 0, 100),
    )
    Solution2().solution(board, skill)
}

class Solution2 {
    fun solution(board: Array<IntArray>, skills: Array<IntArray>): Int {
        var answer: Int = 0
        val imos = Array(board.size + 1) { IntArray(board[0].size + 1) { 0 } }

        skills.map { skill ->
            val value = if (skill[0] == 1) -skill[5] else skill[5]
            imos[skill[1]][skill[2]] += value
            imos[skill[3] + 1][skill[4] + 1] += value
            imos[skill[1]][skill[4] + 1] -= value
            imos[skill[3] + 1][skill[2]] -= value
        }

        for (i in imos.indices) {
            var default = 0
            for (j in imos[0].indices) {
                default += imos[i][j]
                imos[i][j] = default
            }
        }

        for (i in imos[0].indices) {
            var default = 0
            for (j in imos.indices) {
                default += imos[j][i]
                imos[j][i] = default
            }
        }

        for (i in board.indices) {
            for (j in board[0].indices) {
                board[i][j] += imos[i][j]
                if (board[i][j] > 0) answer++
            }
        }

        return answer
    }
}