package kakao

fun main() {
    val n = 9
    val info = intArrayOf(0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1)

    Archery().solution(n, info)
}

class Archery {
    private var answer = intArrayOf(-1)
    private var answerScore = 0

    fun solution(n: Int, info: IntArray): IntArray {
        dfs(n, info, IntArray(info.size) { 0 }, n, 0)
        return answer
    }

    private fun dfs(n: Int, apeach: IntArray, lion: IntArray, arrows: Int, index: Int) {
        if (arrows <= 0 || index >= lion.lastIndex) {
            if (index >= lion.lastIndex) {
                lion[lion.lastIndex] = arrows
            }

            val scoreDiff = getScoreDiff(apeach, lion)
            if (scoreDiff > answerScore) {
                answer = lion
                answerScore = scoreDiff
            } else if (scoreDiff == answerScore && answerScore != 0) {
                for (i in answer.lastIndex downTo 0) {
                    if (answer[i] < lion[i]) {
                        answer = lion
                    } else if (answer[i] == lion[i]) {
                        continue
                    }
                    break
                }
            }
            return
        }

        val newLion = lion.clone()
        dfs(n, apeach, lion, arrows, index + 1)
        if (arrows > apeach[index]) {
            val shots = apeach[index] + 1
            newLion[index] = shots
            dfs(n, apeach, newLion, arrows - shots, index + 1)
        }
    }

    private fun getScoreDiff(apeach: IntArray, lion: IntArray): Int {
        var lionScore = 0
        var apeachScore = 0
        for (i in apeach.indices) {
            if (lion[i] > apeach[i]) {
                lionScore += 10 - i
            } else if (apeach[i] != 0) {
                apeachScore += 10 - i
            }
        }

        return lionScore - apeachScore
    }
}