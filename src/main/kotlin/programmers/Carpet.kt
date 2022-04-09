package programmers

import kotlin.math.sqrt

fun main() {

    val brown = 24
    val yellow = 24

    Carpet().solution(brown, yellow)
}

class Carpet {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()

        val tileCount = brown + yellow

        for (height in 1..sqrt(tileCount.toDouble()).toInt()) {
            val width = tileCount / height
            val outside = (height + width - 2) * 2
            if (outside == brown) {
                answer = intArrayOf(width, height)
            }
        }

        return answer
    }

}