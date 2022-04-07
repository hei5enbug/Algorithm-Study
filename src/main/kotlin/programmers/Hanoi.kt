package programmers

fun main() {

    Hanoi().solution(2)
}

class Hanoi {
    val answer = arrayListOf<IntArray>()

    fun solution(n: Int): Array<IntArray> {
        moveDisk(n, 1, 2, 3)
        return answer.toTypedArray()
    }

    private fun moveDisk(n: Int, start: Int, mid: Int, to: Int) {
        if (n == 1) {
            answer.add(intArrayOf(start, to))
            return
        }

        moveDisk(n - 1, start, to, mid)
        answer.add(intArrayOf(start, to))
        moveDisk(n - 1, mid, start, to)
    }
}