package programmers

fun main() {

    val enroll = arrayOf("john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young")
    val referral = arrayOf("-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward")
    val seller = arrayOf("young", "john", "tod", "emily", "mary")
    val amount = intArrayOf(12, 4, 2, 5, 10)

    Pyramid().solution(enroll, referral, seller, amount)
}

class Pyramid {

    class Member(
        val parent: Member?,
        var revenue: Long = 0
    )

    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
        val memberMap = linkedMapOf<String, Member>()

        for (i in enroll.indices) {
            val parentMember = memberMap[referral[i]]
            memberMap[enroll[i]] = Member(parentMember)
        }

        for (j in seller.indices) {
            val totalPrice: Long = amount[j] * 100L
            val member = memberMap[seller[j]]
            if (member != null) {
                repayment(memberMap, member, totalPrice)
            }
        }

        val answer = memberMap.values.map { member -> member.revenue.toInt() }

        return answer.toIntArray()
    }

    private fun repayment(memberMap: LinkedHashMap<String, Member>, member: Member, price: Long) {
        val commission = price / 10
        member.revenue += price - commission
        val parentMember = member.parent
        if (parentMember != null) {
            repayment(memberMap, parentMember, commission)
        }
    }
}