import kotlin.math.abs

fun main() {
    val dist = arrayOf(
        intArrayOf(0, 5, 2, 4, 1),
        intArrayOf(5, 0, 3, 9, 6),
        intArrayOf(2, 3, 0, 6, 3),
        intArrayOf(4, 9, 6, 0, 3),
        intArrayOf(1, 6, 3, 3, 0)
    )
    val dist2 = arrayOf(
        intArrayOf(0, 1, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(1, 1, 0)
    )
    DevBackend1().solution(dist2)
}

class DevBackend1 {

    fun solution(dist: Array<IntArray>): Array<IntArray> {
        val answer = arrayListOf<IntArray>()

        val dotMap = hashMapOf<Int, Long>()

        for (id in dist[0].indices) {
            dotMap[id] = dist[0][id].toLong()
        }

        for (i in 1 until dist.size - 1) {
            val standard = dist[i]
            for (j in i until standard.size) {
                if (j == i) continue
                val dot1 = dotMap[i]!!.toLong()
                val dot2 = dotMap[j]!!.toLong()
                val mapDistance = abs(dot1 - dot2)
                val realDistance = standard[j].toLong()
                if (realDistance != mapDistance) {
                    dotMap[j] = dot2 - (realDistance - mapDistance)
                }
            }
        }

        val list1 = dotMap.entries.sortedBy { it.value }.map { it.key }
        val list2 = list1.reversed()

        for (i in list1.indices) {
            val element1 = list1[i].toString()
            val element2 = list2[i].toString()

            if (element1 < element2) {
                answer.add(list1.toIntArray())
                answer.add(list2.toIntArray())
                break
            } else if (element1 > element2) {
                answer.add(list2.toIntArray())
                answer.add(list1.toIntArray())
                break
            }
        }
        if (answer.isEmpty()) {
            answer.add(list1.toIntArray())
        }

        return answer.toTypedArray()
    }
}