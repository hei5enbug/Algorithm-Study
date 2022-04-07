package programmers

fun main() {

    val queries = arrayOf(intArrayOf(2, 2, 5, 4), intArrayOf(3, 3, 6, 6), intArrayOf(5, 1, 6, 3))

    RotateBox().solution(6, 6, queries)
}

class RotateBox {

    private var numberSet = hashSetOf<Int>()

    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = arrayListOf<Int>()

        // make matrix
        var count = 1
        var matrix = Array(rows) { IntArray(columns) { count++ } }

        queries.map { query ->
            numberSet = hashSetOf()
            matrix = rotate(matrix, query)
            val min = numberSet.toIntArray().sorted()[0]
            answer.add(min)
            printMatrix(matrix)
        }

        println(answer.toString())

        return answer.toIntArray()
    }

    private fun printMatrix(matrix: Array<IntArray>) {
        matrix.map {
            it.map { number -> print("$number ") }
            println()
        }
        println()
    }

    private fun rotate(matrix: Array<IntArray>, query: IntArray): Array<IntArray> {

        val startY = query[0] - 1
        val endY = query[2] - 1
        val startX = query[1] - 1
        val endX = query[3] - 1

        // copy matrix
        val rotateMatrix = Array(matrix.size) { IntArray(matrix[0].size) { 0 } }
        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                rotateMatrix[i][j] = matrix[i][j]
            }
        }

        for (i in 0 until endX - startX) {
            rotateMatrix[startY][startX + i + 1] = matrix[startY][startX + i]
            rotateMatrix[endY][startX + i] = matrix[endY][startX + i + 1]
            numberSet.add(matrix[startY][startX + i])
            numberSet.add(matrix[endY][startX + i + 1])

        }

        for (j in 0 until endY - startY) {
            rotateMatrix[startY + j + 1][endX] = matrix[startY + j][endX]
            rotateMatrix[startY + j][startX] = matrix[startY + j + 1][startX]
            numberSet.add(matrix[startY + j][endX])
            numberSet.add(matrix[startY + j + 1][startX])
        }

        println(numberSet.toString())

        return rotateMatrix
    }
}