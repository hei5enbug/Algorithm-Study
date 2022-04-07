package alg

import java.util.regex.Pattern

fun main() {
    val user_id = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc")
    val banned_id = arrayOf("fr*d*", "abc1**")
    Solution().solution(user_id, banned_id)
}

class Solution {

    lateinit var result: HashSet<HashSet<String>>
    lateinit var badUserList: ArrayList<ArrayList<String>>

    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {

        result = hashSetOf()
        badUserList = arrayListOf()

        banned_id.map { bannedId ->
            badUserList.add(getMatchIds(bannedId, user_id))
        }
        dfs(hashSetOf(), 0)

        return result.size
    }

    private fun getMatchIds(bannedId: String, user_id: Array<String>): ArrayList<String> {
        val pattern = bannedId.replace('*', '.')
        val matchIdList = arrayListOf<String>()

        user_id.map { userId ->
            if (Pattern.matches(pattern, userId)) {
                matchIdList.add(userId)
            }
        }
        return matchIdList
    }

    private fun dfs(seen: HashSet<String>, depth: Int) {
        if (depth == badUserList.size) {
            result.add(HashSet(seen))
            return
        }

        for (badUser in badUserList[depth]) {
            if (!seen.contains(badUser)) {
                seen.add(badUser)
                dfs(seen, depth + 1)
                seen.remove(badUser)
            }
        }
    }
}