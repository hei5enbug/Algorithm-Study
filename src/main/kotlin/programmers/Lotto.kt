package programmers

fun main() {
//    val lottos = intArrayOf(44, 1, 0, 0, 31, 25)
//    val win_nums = intArrayOf(31, 10, 45, 1, 6, 19)

    val lottos = intArrayOf(0, 0, 0, 0, 0, 0)
    val win_nums = intArrayOf(38, 19, 20, 40, 15, 25)
    Lotto().solution(lottos, win_nums)
}

class Lotto {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var prizeCount = 0
        var zeroCount = 0

        lottos.map { number ->
            if (win_nums.contains(number)) {
                prizeCount++
            }
            if (number == 0) {
                zeroCount++
            }
        }

        val min = if (prizeCount > 1) 7 - prizeCount else 6
        val max = if (zeroCount >= min) 1 else min - zeroCount
        val answer: IntArray = intArrayOf(max, min)

        println("$max $min")

        return answer
    }
}