package alg

fun main() {
    val begin = "hit"
    val target = "cog"
    val words = arrayOf<String>("hot", "dot", "dog", "lot", "log", "cog")

    ConvertWord().solution(begin, target, words)
}

class ConvertWord {

    private var result = hashSetOf<Int>()

    fun solution(begin: String, target: String, words: Array<String>): Int {

        dfs(hashSetOf(), begin, target, words, 0)

        var answer = 0
        if (result.isNotEmpty()) {
            answer = result.minOrNull()!!
        }
        println(answer)

        return answer
    }

    private fun dfs(seen: HashSet<String>, change: String, target: String, words: Array<String>, depth: Int) {
        if (depth == words.size) {
            return
        }

        print("$change -> ")

        if (change == target) {
            result.add(depth)
            println("success!!!")
            return
        }
        val newSeen = hashSetOf<String>()
        newSeen.addAll(seen)
        newSeen.add(change)

        for (word in words) {
            if (isChangeable(change, word) && !newSeen.contains(word)) {
                dfs(newSeen, word, target, words, depth + 1)
            }
        }
    }

    private fun isChangeable(word1: String, word2: String): Boolean {
        var diffCount = 0
        for (i in word1.indices) {
            if (word1[i] != word2[i]) {
                diffCount++
            }
        }
        return diffCount == 1
    }
}