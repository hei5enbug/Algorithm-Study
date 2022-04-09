package kakao

import kotlin.math.sqrt

fun main() {

    PrimeNumber().solution(2047, 2)
}

class PrimeNumber {
    fun solution(n: Int, k: Int): Int {
        var answer = 0
        val notation = getNotation(n, k)

        notation.split("0").map { number ->
            if (number.toDoubleOrNull() !== null) {
                if (isPrimeNumber(number.toLong())) {
                    answer++
                }
            }
        }

        return answer
    }

    // 2047을 2진수로 표현하면 Int 범위를 넘어가므로 Long 형식으로 사용
    private fun isPrimeNumber(n: Long): Boolean {
        if (n == 1L) return false

        for (i in 2L..sqrt(n.toDouble()).toLong()) {
            if (n % i == 0L) {
                return false
            }
        }
        return true
    }

    private fun getNotation(number: Int, k: Int): String {
        var result = ""
        var target = number

        while (target >= k) {
            result = (target % k).toString() + result
            target /= k
        }

        return target.toString() + result
    }

}