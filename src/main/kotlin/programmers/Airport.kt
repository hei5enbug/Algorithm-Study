package programmers

fun main() {

    val tickets = arrayOf(
        arrayOf("ICN", "SFO"),
        arrayOf("ICN", "ATL"),
        arrayOf("SFO", "ATL"),
        arrayOf("ATL", "ICN"),
        arrayOf("ATL", "SFO")
    )

    Airport().solution(tickets)
}

class Airport {
    private val answerList = arrayListOf<String>()

    fun solution(tickets: Array<Array<String>>): Array<String> {

        dfs(tickets, Array(tickets.size) { false }, "ICN", "ICN")

        return answerList.sorted()[0].split(" ").toTypedArray()
    }

    private fun dfs(tickets: Array<Array<String>>, visit: Array<Boolean>, answer: String, location: String) {
        if (answer.split(" ").size > tickets.size) {
            answerList.add(answer)
            return
        }

        for (i in tickets.indices) {
            val ticket = tickets[i]
            if (!visit[i] && ticket[0] == location) {
                visit[i] = true
                dfs(tickets, visit, "$answer ${ticket[1]}", ticket[1])
                visit[i] = false
            }
        }
        return
    }
}