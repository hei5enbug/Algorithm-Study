package kakao

fun main() {
    val fees = intArrayOf(180, 5000, 10, 600)
    val records = arrayOf(
        "05:34 5961 IN",
        "06:00 0000 IN",
        "06:34 0000 OUT",
        "07:59 5961 OUT",
        "07:59 0148 IN",
        "18:59 0000 IN",
        "19:09 0148 OUT",
        "22:59 5961 IN",
        "23:00 5961 OUT"
    )

    ParkingFee().solution(fees, records)
}

class ParkingFee {

    class Car(
        var start: String? = null,
        var parkingTime: Long = 0,
        var fee: Long = 0
    ) {
        fun calculateFee(fees: IntArray) {
            val defaultTime = fees[0]
            val defaultFee = fees[1]
            val overTime = fees[2]
            val overFee = fees[3]

            fee += defaultFee
            if (parkingTime > defaultTime) {
                var overCount = (parkingTime - defaultTime) / overTime
                if ((parkingTime - defaultTime) % overTime > 0) overCount++
                fee += overFee * overCount
            }
        }

        fun out(endTime: String) {
            if (start != null) {
                parkingTime += convertMinute(endTime) - convertMinute(start!!)
                start = null
            }
        }

        private fun convertMinute(time: String): Long {
            val hour = time.split(":")[0].toLong()
            val minute = time.split(":")[1].toLong()
            return hour * 60 + minute
        }
    }

    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val carMap = linkedMapOf<String, Car>()

        records.map {
            val record = it.split(" ")
            val time = record[0]
            val carId = record[1]
            val action = record[2]

            val car = carMap[carId]
            if (car == null) {
                carMap[carId] = Car(start = time)
            } else if (action == "IN") {
                car.start = time
            } else if (action == "OUT") {
                car.out(time)
            }
        }

        val answer = carMap.toSortedMap().values.map { car ->
            if (car.start != null) {
                car.out("23:59")
            }
            car.calculateFee(fees)
            return@map car.fee.toInt()
        }

        return answer.toIntArray()
    }
}