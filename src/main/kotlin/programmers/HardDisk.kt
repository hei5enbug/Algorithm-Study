package programmers

fun main() {

    val jobs = arrayOf(
        intArrayOf(0, 3),
        intArrayOf(1, 9),
        intArrayOf(2, 6),
    )

    HardDisk().solution(jobs)
}

class HardDisk {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        val doneArray = Array(jobs.size) { false }

        var count = 0
        while (!doneArray.all { it }) {
            val requestJobs = jobs.filter { it[0] <= count && !doneArray[jobs.indexOf(it)] }

            if (requestJobs.isNotEmpty()) {
                val shortestJob = requestJobs.sortedBy { it[1] }[0]
                val jobIndex = jobs.indexOf(shortestJob)
                val requestTime = shortestJob[0]
                val accessTime = shortestJob[1]
                doneArray[jobIndex] = true
                answer += count - requestTime + accessTime
                count += accessTime
            } else {
                count++
            }
        }


        return answer / jobs.size
    }
}