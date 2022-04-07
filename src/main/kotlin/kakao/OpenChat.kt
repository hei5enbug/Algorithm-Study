package kakao

fun main() {

    OpenChat().solution(
        arrayOf(
            "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        )
    )
}

class OpenChat {

    fun solution(record: Array<String>): Array<String> {
        var answer = arrayListOf<String>()
        val idMap = hashMapOf<String, String>()

        record.map {
            val logs = it.split(" ")
            val action = logs[0]
            val id = logs[1]

            when (action) {
                "Enter" -> {
                    idMap[id] = logs[2]
                    answer.add("${id}님이 들어왔습니다.")
                }
                "Leave" -> {
                    answer.add("${id}님이 나갔습니다.")
                }
                "Change" -> {
                    idMap[id] = logs[2]
                }
                else -> {}
            }
        }

        for(i in answer.indices){
            val id = answer[i].split("님이 ")[0]
            val nickname = idMap[id]
            if (nickname != null) {
                answer[i] = answer[i].replace(id, nickname)
            }
        }

        return answer.toTypedArray()
    }
}