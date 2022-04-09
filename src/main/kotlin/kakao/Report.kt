package kakao

fun main() {
    val id_list = arrayOf("muzi", "frodo", "apeach", "neo")
    val report = arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi")
    val k = 2

    Report().solution(id_list, report, k)
}

class Report {
    class UserInfo(
        val index: Int,
        val receiveSet: HashSet<String> = hashSetOf(),
        val sendSet: HashSet<String> = hashSetOf(),
    )

    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = IntArray(id_list.size) { 0 }
        val userMap = linkedMapOf<String, UserInfo>()
        val badUserList = arrayListOf<String>()

        for (i in id_list.indices) {
            userMap[id_list[i]] = UserInfo(index = i)
        }

        report.forEach {
            val informant = it.split(" ")[0]
            val userName = it.split(" ")[1]
            userMap[informant]?.sendSet?.add(userName)

            val warningUser = userMap[userName]

            if (warningUser != null) {
                warningUser.receiveSet.add(informant)
                if (warningUser.receiveSet.size >= k) {
                    badUserList.add(userName)
                }
            }
        }

        userMap.values.forEach { userInfo ->
            val index = userInfo.index
            val badUserCount = userInfo.sendSet.filter { badUserList.contains(it) }.size
            answer[index] = badUserCount
        }

        return answer
    }
}