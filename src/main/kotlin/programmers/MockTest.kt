package programmers

fun main() {

    val tickets = intArrayOf(1, 3, 2, 4, 2)

    MockTest().solution(tickets)
}

class MockTest {
    fun solution(answers: IntArray): IntArray {
        val nerd1 = intArrayOf(1, 2, 3, 4, 5)
        val nerd2 = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
        val nerd3 = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

        val countMap = hashMapOf(1 to 0, 2 to 0, 3 to 0)

        for (i in answers.indices) {
            val answer = answers[i % answers.size]
            if (nerd1[i % nerd1.size] == answer) {
                countMap[1] = countMap[1]!! + 1
            }
            if (nerd2[i % nerd2.size] == answer) {
                countMap[2] = countMap[2]!! + 1
            }
            if (nerd3[i % nerd3.size] == answer) {
                countMap[3] = countMap[3]!! + 1
            }
        }

        val max = countMap.maxOf { it.value }
        val answer = countMap.filter { it.value == max }.map { it.key }

        return answer.toIntArray()
    }
}