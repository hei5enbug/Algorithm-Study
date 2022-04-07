fun main() {
    val logs = arrayOf(
        "team_name : db application_name : dbtest error_level : info message : test",
        "team_name : test application_name : I DONT CARE error_level : error message : x",
        "team_name : ThisIsJustForTest application_name : TestAndTestAndTestAndTest error_level : test message : IAlwaysTestingAndIWillTestForever",
        "team_name : oberervability application_name : LogViewer error_level : error"
    )

    val logs2 = arrayOf(
        "team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange",
        "no such file or directory",
        "team_name : recommend application_name : recommend error_level : info message : RecommendSucces11",
        "team_name : recommend application_name : recommend error_level : info message : Success!",
        "   team_name : db application_name : dbtest error_level : info message : test",
        "team_name     : db application_name : dbtest error_level : info message : test",
        "team_name : TeamTest application_name : TestApplication error_level : info message : ThereIsNoError"
    )

    LineTest().solution(logs2)
}

class LineTest {

    private val keyArray = arrayOf("team_name", "application_name", "error_level", "message")

    fun solution(logs: Array<String>): Int {
        var answer = 0

        logs.map { log ->
            if (!isRightLog(log)) {
                answer++
            }
        }

        return answer
    }

    private fun isRightLog(log: String): Boolean {
        // length check
        if (log.length > 100) {
            return false
        }

        // key name check
        keyArray.map { key ->
            if (!log.contains(key)) {
                return false
            }
        }

        val splitLog = log.split(" : ")
        for (i in splitLog.indices) {
            val divideSpacing = splitLog[i].split(" ")
            var message = ""

            // spacing check
            if (i == 0 || i == splitLog.lastIndex) {
                if (divideSpacing.size != 1) {
                    return false
                }
                message = divideSpacing[0]
            } else {
                if (divideSpacing.size != 2) {
                    return false
                }
                message = divideSpacing[0]
            }

            // alphabet check
            if (i != 0 && !message.all { it.isLetter() }) {
                return false
            }
        }
        
        return true
    }
}