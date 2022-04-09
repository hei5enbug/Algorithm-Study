package kakao

fun main() {
    val board = arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), intArrayOf(1, 1, 1))
    val aloc = intArrayOf(1, 0)
    val bloc = intArrayOf(1, 2)

    VanishingTile().solution(board, aloc, bloc)
}

class VanishingTile {
    fun solution(board: Array<IntArray>, aloc: IntArray, bloc: IntArray): Int {
        var answer: Int = -1
        return answer
    }
}