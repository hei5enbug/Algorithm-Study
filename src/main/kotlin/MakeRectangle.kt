fun main() {
    val v = arrayOf(intArrayOf(1, 4), intArrayOf(3, 4), intArrayOf(3, 10))

    MakeRectangle().solution(v)
}

class MakeRectangle {
    fun solution(v: Array<IntArray>): IntArray {

        val xMap = mutableMapOf<Int, Int>()
        val yMap = mutableMapOf<Int, Int>()

        v.map { point ->
            val x = point[0]
            val y = point[1]

            xMap[x] = xMap.getOrDefault(x, 0) + 1
            yMap[y] = yMap.getOrDefault(y, 0) + 1
        }

        val answerX = xMap.entries.find { it.value == 1 }!!.key
        val answerY = yMap.entries.find { it.value == 1 }!!.key

        return intArrayOf(answerX, answerY)
    }
}