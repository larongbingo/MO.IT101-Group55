package org.motorph.payroll.repositories;

import org.motorph.employees.Employee;
import org.motorph.employees.EmployeeRepository;
import org.motorph.employees.Login;
import org.motorph.employees.LoginRepository;

import java.util.List;

public class ListLoginRepository implements LoginRepository {
    private List<Login> logins = List.of();
    private EmployeeRepository employeeRepository;

    public ListLoginRepository(List<Login> logins, EmployeeRepository employeeRepository) {
        this.logins = logins;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeByCredentials(String username, String password) {
        var login = getLoginByUsername(username);

        if (login == null)
            return null;

        if (!login.Password.equals(password))
            return null;

        return employeeRepository.getEmployeeByEmployeeId(login.EmployeeId);
    }

    private Login getLoginByUsername(String username) {
        return logins.stream().filter(x -> x.Username.equals(username)).findFirst().orElse(null);
    }
}
