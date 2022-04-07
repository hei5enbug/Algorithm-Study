package alg

fun main() {
    val progresses = intArrayOf(93, 30, 55)
    val speeds = intArrayOf(1, 30, 5)
    FeatureDevelop().solution(progresses, speeds)
}

class FeatureDevelop {

    class Feature(
        var progress: Int,
        private val speed: Int
    ) {
        fun develop() {
            progress += speed
        }
    }

    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = arrayListOf<Int>()

        val progressStack = arrayListOf<Feature>()
        for (i in progresses.indices) {
            progressStack.add(Feature(progresses[i], speeds[i]))
        }

        while (progressStack.isNotEmpty()) {
            var deployCount = 0
            while (progressStack[0].progress >= 100) {
                progressStack.removeFirst()
                deployCount++
                if (progressStack.isEmpty()) break
            }


            if (deployCount > 0) {
                answer.add(deployCount)
            }
            progressStack.map { feature -> feature.develop() }
        }

        println(answer)

        return answer.toIntArray()
    }
}