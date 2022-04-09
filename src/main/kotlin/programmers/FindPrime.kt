package programmers

import kotlin.math.sqrt

fun main() {

    FindPrime().solution("011")
}

class FindPrime {
    private val combination = hashSetOf<Int>()

    fun solution(numbers: String): Int {
        var answer = 0

        makeNumber(numbers, "", hashSetOf())
        combination.map {
            if (isPrimeNumber(it)) {
                answer++
            }
        }

        return answer
    }

    private fun makeNumber(numbers: String, current: String, useIndex: HashSet<Int>) {
        if (current.length > numbers.length) {
            return
        }

        for (i in numbers.indices) {
            if (!useIndex.contains(i)) {
                val number = numbers[i]
                val newUseIndex = useIndex.clone() as HashSet<Int>
                newUseIndex.add(i)

                val newCurrent = current + number.toString()
                combination.add(newCurrent.toInt())
                makeNumber(numbers, newCurrent, newUseIndex)
            }
        }
    }

    private fun isPrimeNumber(number: Int): Boolean {
        if (number < 2) return false

        for (i in 2..sqrt(number.toDouble()).toInt()) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
}