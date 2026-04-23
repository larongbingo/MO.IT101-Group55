package org.motorph.data.loading

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.csv.Csv
import org.koin.mp.KoinPlatformTools
import org.motorph.core.results.Failure
import org.motorph.core.results.Success
import org.motorph.employees.Employee
import org.motorph.employees.EmployeeRepository
import org.motorph.employees.ManageEmployeesService
import org.motorph.employees.dto.NewLoginDto
import org.motorph.employees.login.Login
import org.motorph.employees.login.LoginService
import org.motorph.timesheet.Timesheet
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.util.stream.Collectors

/**
 * Loads data from InputStream into the database.
 * @property employeeService Mainly used to add employees
 * @property employeeRepository Mainly used to get employees
 * @property loginService Mainly used to add logins
 */
@OptIn(ExperimentalSerializationApi::class)
class DataLoader(
    private val employeeService: ManageEmployeesService,
    private val employeeRepository: EmployeeRepository,
    private val loginService: LoginService,
    ) {
    private val csv: Csv = Csv {
        hasHeaderRecord = true
        ignoreUnknownColumns = true
    }

    fun loadEmployees(stream: InputStream): List<Employee> {
        val reader = BufferedReader(InputStreamReader(stream))
        val text = reader.lines().collect(Collectors.joining("\n"))

        val results = csv.decodeFromString(ListSerializer(EmployeeRow.serializer()), text)
        return results.mapNotNull {
            val employee = it.toDto()
            val result = employeeService.addEmployee(employee)
            when (result) {
                is Success<Employee> -> result.value
                is Failure<Employee> -> {
                    println("${result.exception} ${result.exception?.cause}")
                    null
                }
                else -> null
            }
        }
    }

    fun loadLogins(stream: InputStream): List<Login> {
        val reader = BufferedReader(InputStreamReader(stream))
        val text = reader.lines().collect(Collectors.joining("\n"))
        val results = csv.decodeFromString(ListSerializer(LoginRow.serializer()), text)
        return results.mapNotNull {
            val employee = employeeRepository.getEmployeeByEmployeeId(it.employeeId)
            val login = NewLoginDto(it.username, it.password, employee)
            val result = loginService.addLogin(login)
            if (result is Success<Login>) result.value else null
        }
    }

    fun loadAttendance(stream: InputStream): List<Timesheet> {
        TODO()
    }
}

expect val employeesStream: InputStream
expect val loginsStream: InputStream
expect val attendanceStream: InputStream

fun loadData() {
    val di = KoinPlatformTools.defaultContext().get()
    val employeeService = di.get<ManageEmployeesService>()
    val loginService = di.get<LoginService>()
    val employeeRepository = di.get<EmployeeRepository>()

    if (employeeRepository.getAllEmployees().isNotEmpty()) return

    val loader = DataLoader(employeeService, employeeRepository, loginService)
    val employees = loader.loadEmployees(employeesStream)
    val logins = loader.loadLogins(loginsStream)
    //loader.loadAttendance(attendanceStream)
}
