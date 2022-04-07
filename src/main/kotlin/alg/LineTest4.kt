package alg

fun main() {

    val arr = intArrayOf(6, 2, 2, 6)
    val brr = intArrayOf(4, 4, 4, 4)

    LineTest4().solution(arr, brr)
}

class LineTest4 {
    fun solution(arr: IntArray, brr: IntArray): Int {

        var answer = 0

        for (i in 0..arr.size - 2) {
            val changeValue = brr[i] - arr[i]
            if (changeValue != 0) {
                arr[i] += changeValue
                arr[i + 1] -= changeValue
                answer++
            }
        }

        println(answer)

        return answer
    }
}