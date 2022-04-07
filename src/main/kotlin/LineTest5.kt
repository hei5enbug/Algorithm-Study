fun main() {

    val abilities = intArrayOf(2, 8, 3, 6, 1, 9, 1, 9)
    val k = 2

    LineTest5().solution(abilities, k)
}

class LineTest5 {
    fun solution(abilities: IntArray, k: Int): Long {
        var answer: Long = 0
        val abilityList = arrayListOf<Int>()
        val diffList = arrayListOf<Int>()
        var score = 0L

        abilities.map { abilityList.add(it) }
        if (abilityList.size % 2 == 1) {
            abilityList.add(0)
        }
        abilityList.sortDescending()

        for (i in abilityList.indices step 2) {
            val yourMember = abilityList[i]
            val myMember = abilityList[i + 1]
            score += myMember

            val diff = yourMember - myMember
            diffList.add(diff)
        }
        diffList.sortDescending()
        for (j in 0 until k) {
            score += diffList[j]
        }

        return score
    }
}