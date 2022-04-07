package alg

fun main() {
    val sentences = arrayOf(
        "line in line", "LINE", "in lion"
    )
    val n = 5

    LineTest2().solution(sentences, n)
}

class LineTest2 {

    private val sentencesInfo = hashMapOf<String, HashSet<String>>()
    private val scoreInfo = hashMapOf<String, Int>()

    fun solution(sentences: Array<String>, n: Int): Int {
        var answer: Int = -1

        sentences.map { sentence ->
            getSentenceInfo(sentence, n)
        }



        return answer
    }

    private fun getSentenceInfo(sentences: String, n: Int) {
        val needKeys = hashSetOf<String>()
        var score = 0

        sentences.map {
            if (it.isUpperCase()) {
                needKeys.add("shift")
                score += 1
            }
            if (it.isLetter()) {
                needKeys.add(it.lowercase())
            }
            score++
        }

        if (needKeys.size <= n) {
            sentencesInfo[sentences] = needKeys
            scoreInfo[sentences] = score
        }
    }
}