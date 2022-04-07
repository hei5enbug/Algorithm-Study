fun main() {

    val req_id = arrayOf("William", "Andy", "Rohan", "Rohan", "Louis", "Andy")
    val req_info = arrayOf(
        intArrayOf(1, 7, 20),
        intArrayOf(0, 10, 10),
        intArrayOf(1, 10, 40),
        intArrayOf(1, 4, 25),
        intArrayOf(0, 5, 11),
        intArrayOf(0, 20, 30),
    )

    LineTest6().solution(req_id, req_info)
}

class Buy(
    val number: Int,
    val buyer: String,
    var amount: Int,
    val price: Int,
    var state: String
)

class Sell(
    val number: Int,
    val seller: String,
    var amount: Int,
    val price: Int,
    var state: String
)

class Member(
    val name: String,
    var goldChange: Int,
    var silverChange: Int
)

class LineTest6 {

    private val buyList = arrayListOf<Buy>()
    private val sellList = arrayListOf<Sell>()
    private val memberList = hashSetOf<Member>()

    fun solution(req_id: Array<String>, req_info: Array<IntArray>): Array<String> {
        var answer: Array<String> = arrayOf<String>()

        for (i in req_id.indices) {
            val name = req_id[i]
            val type = req_info[i][0]
            val amount = req_info[i][1]
            val price = req_info[i][2]

            if (type == 0) {
                val buy = Buy(i + 1, name, amount, price, "pending")
                buyList.add(buy)
            } else if (type == 1) {
                val sell = Sell(i + 1, name, amount, price, "pending")
                sellList.add(sell)
            }

            getTransaction()
        }

        return answer
    }

    private fun getTransaction() {

        for (buy in buyList) {
            var buyAmount = buy.amount
            while (buyAmount > 0) {
                val getSell = sellList.find { sell -> sell.price <= buy.price }

                if (getSell != null) {
                    val value = buyAmount - getSell.amount
                    if (value >= 0) {
                        buyAmount -= value
                        getSell.amount = 0
                        getSell.state = "done"
                    } else if (value < 0) {
                        buyAmount = 0
                        getSell.amount -= value
                    }
                } else {
                    break
                }
            }
            if (buyAmount == 0) {
                buy.state = "done"
            }
            buy.amount = buyAmount
        }
    }
}