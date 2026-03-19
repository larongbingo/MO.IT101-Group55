package org.motorph.payroll.repositories;

import org.jetbrains.annotations.Nullable;
import org.motorph.employees.Employee;
import org.motorph.employees.EmployeeRepository;

import java.util.List;

public class ListEmployeeRepository implements EmployeeRepository {
    private List<Employee> employees = List.of();

    public ListEmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    @Nullable
    public Employee getEmployeeByEmployeeId(String employeeId) {
        return employees.stream().filter(x -> x.EmployeeId.equals(employeeId)).findFirst().orElse(null);
    }
}
