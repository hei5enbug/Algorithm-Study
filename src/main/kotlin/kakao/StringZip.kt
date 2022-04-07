package kakao

import kotlin.math.min

fun main() {

//    StringZip().solution("aabbaccc")
    StringZip().solution("aabbaabb")
}

class StringZip {

    var answer = 0

    fun solution(s: String): Int {
        answer = s.length
        for (n in 1..s.length / 2) {
            val compression = getCompression(s, n)
            answer = min(answer, compression.length)
        }

        return answer
    }

    private fun getCompression(s: String, num: Int): String {
        var result = ""
        var count = 1
        var target = s.substring(0, num)

        for (i in num..s.length step num) {
            val next = if (i + num > s.length) {
                s.substring(i, s.length)
            } else {
                s.substring(i, i + num)
            }

            if (target == next) {
                count++
            } else {
                if (count != 1) {
                    result += "$count"
                }
                result += target
                if (i + num > s.length) {
                    result += next
                }
                target = next
                count = 1
            }
        }

        return result
    }
}