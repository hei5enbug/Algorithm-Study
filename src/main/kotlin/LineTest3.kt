fun main() {
    val remote_tasks = arrayOf("development", "marketing", "hometask")
    val office_tasks = arrayOf("recruitment", "education", "officetask")
    val employees = arrayOf(
        "1 development hometask",
        "1 recruitment marketing",
        "2 hometask",
        "2 development marketing hometask",
        "3 marketing",
        "3 officetask",
        "3 development"
    )

    LineTest3().solution(3, remote_tasks, office_tasks, employees)
}

class Team(
    val teamNumber: Int,
    val memberList: ArrayList<Employee>,
    var goOffice: Boolean
)

class Employee(
    val employeeNumber: Int,
    val teamNumber: Int,
    val workList: ArrayList<String>,
    var goOffice: Boolean
)

class LineTest3 {

    private val teamSet = hashSetOf<Team>()


    fun solution(
        num_teams: Int,
        remote_tasks: Array<String>,
        office_tasks: Array<String>,
        employees: Array<String>
    ): IntArray {

        var employeeSet = hashSetOf<Employee>()
        getTeamSet(employees, office_tasks)

        teamSet.forEach { team ->
            if (!team.goOffice) {
                team.memberList[0].goOffice = true
                team.goOffice = true
            }
            team.memberList.map { employee -> employeeSet.add(employee) }
        }
        val stayEmployeeList = employeeSet
            .filter { !it.goOffice }
            .sortedBy { it.employeeNumber }
            .map { it.employeeNumber }


        return stayEmployeeList.toIntArray()
    }

    private fun getTeamSet(employees: Array<String>, office_tasks: Array<String>) {
        for (i in employees.indices) {
            val workList = arrayListOf<String>()
            val splitEmployee = employees[i].split(" ")
            val teamNumber = splitEmployee[0].toInt()
            var goOffice = false

            for (j in splitEmployee.indices) {
                val work = splitEmployee[j]
                if (j != 0) {
                    workList.add(work)
                }
                if (office_tasks.contains(work)) {
                    goOffice = true
                }
            }


            val employee = Employee(i + 1, teamNumber, workList, goOffice)

            val existTeam = teamSet.find { it.teamNumber == teamNumber }
            if (existTeam != null) {
                existTeam.memberList.add(employee)
                if (!existTeam.goOffice) {
                    existTeam.goOffice = goOffice
                }
            } else {
                teamSet.add(Team(teamNumber, arrayListOf(employee), goOffice))
            }
        }
    }

}