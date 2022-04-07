package alg

fun main() {
    val clothes = arrayOf(
        arrayOf("yellowhat", "headgear"),
        arrayOf("bluesunglasses", "eyewear"),
        arrayOf("green_turban", "headgear"),
    )
    SpyClothes().solution(clothes)
}

class SpyClothes {

    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1

        clothes.groupBy({ it[1] }, { it[0] }).map { clothEntry ->
            answer *= clothEntry.value.size + 1
        }

        return answer - 1
    }
}