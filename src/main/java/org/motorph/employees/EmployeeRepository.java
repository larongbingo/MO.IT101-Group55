package org.motorph.employees;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> getAllEmployees();
    Employee getEmployeeByEmployeeId(String employeeId);
}
