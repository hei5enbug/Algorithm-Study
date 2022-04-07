package programmers

fun main() {
    val s = "abcdcba"
    Palindrome().solution(s)
}

class Palindrome {
    fun solution(s: String): Int {
        var answer = 1
        val dp = Array(s.length) { Array(s.length) { 0 } }

        // 1 digit
        for (i in s.indices) {
            dp[i][i] = 1
        }

        // 2 digit
        for (i in 0 until s.length - 1) {
            if (s[i] == s[i + 1]) {
                dp[i][i + 1] = 1
                answer = 2
            }
        }

        // 3~ digit
        for (digit in 2 until s.length) {
            for (start in 0 until s.length - digit) {
                //      첫글자 == 마지막 글자        &&     dp (중간 글자들) == palindrome
                if (s[start] == s[start + digit] && dp[start + 1][start + digit - 1] == 1) {
                    dp[start][start + digit] = 1
                    answer = digit + 1
                }
            }
        }

        println(answer)

        return answer
    }
}