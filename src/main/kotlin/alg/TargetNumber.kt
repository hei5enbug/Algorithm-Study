package alg

fun main() {
    val numbers = intArrayOf(1,1,1,1,1)

    TargetNumber().solution(numbers, 3)
}

class TargetNumber {
    var answer = 0

    fun solution(numbers: IntArray, target: Int): Int {
        dfs(numbers, 0, target, 0)
        println(answer)
        return answer
    }

    private fun dfs(numbers: IntArray, depth: Int, target: Int, result: Int) {
        if (depth == numbers.size) {
            if (target == result) {
                answer++
            }
            return
        }

        dfs(numbers, depth + 1, target, result + numbers[depth])
        dfs(numbers, depth + 1, target, result - numbers[depth])
    }

}