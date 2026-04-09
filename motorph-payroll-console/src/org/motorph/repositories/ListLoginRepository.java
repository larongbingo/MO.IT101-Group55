package org.motorph.repositories;

import org.motorph.core.MotorPhException;
import org.motorph.core.results.Result;
import org.motorph.employees.Employee;
import org.motorph.employees.EmployeeRepository;
import org.motorph.employees.login.Login;
import org.motorph.employees.login.LoginRepository;

import java.util.List;

/// In-memory implementation of LoginRepository
public class ListLoginRepository implements LoginRepository {
    private List<Login> logins = List.of();
    private EmployeeRepository employeeRepository;

    public ListLoginRepository(List<Login> logins, EmployeeRepository employeeRepository) {
        this.logins = logins;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Result<Login> addLogin(Login login) {
        return Result.failure(new MotorPhException("Method not implemented"));
    }

    @Override
    public Result<Login> updateLogin(Login updatedLogin) {
        return Result.failure(new MotorPhException("Method not implemented"));
    }

    /// {@inheritDoc}
    @Override
    public Employee getEmployeeByCredentials(String username, String password) {
        var login = getLoginByUsername(username);

        if (login == null)
            return null;

        if (!login.Password.equals(password))
            return null;

        return employeeRepository.getEmployeeByEmployeeId(login.EmployeeId);
    }

    /// {@inheritDoc}
    public Login getLoginByUsername(String username) {
        return logins.stream().filter(x -> x.Username.equals(username)).findFirst().orElse(null);
    }
}
