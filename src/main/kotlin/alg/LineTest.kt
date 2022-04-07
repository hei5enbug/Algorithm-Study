package alg

fun main() {
    val numbers = intArrayOf(3, 30, 34, 5, 9)

    MaxNumber().solution(numbers)
}

class MaxNumber {
    fun solution(numbers: IntArray): String {
        var answer = ""

        val newNumbers = numbers.sortedByDescending { it % 10 }

        newNumbers.map {
            answer += it
        }
        println(answer)
        return answer
    }
}