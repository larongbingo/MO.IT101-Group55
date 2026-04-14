package org.motorph.employee.login

import org.motorph.core.results.Result
import org.motorph.employees.Employee
import org.motorph.employees.login.Login
import org.motorph.employees.login.LoginRepository

class LoginRepositoryImpl : LoginRepository {
    override fun addLogin(login: Login?): Result<Login> {
        TODO("Not yet implemented")
    }

    override fun updateLogin(updatedLogin: Login?): Result<Login> {
        TODO("Not yet implemented")
    }

    override fun getLoginByUsername(username: String): Login? {
        TODO("Not yet implemented")
    }

    override fun getEmployeeByCredentials(username: String, password: String): Employee? {
        TODO("Not yet implemented")
    }
}