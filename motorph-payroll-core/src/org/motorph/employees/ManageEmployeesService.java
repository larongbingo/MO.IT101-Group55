package org.motorph.employees;

import org.motorph.core.results.Result;
import org.motorph.employees.dto.NewEmployeeDto;
import org.motorph.employees.dto.UpdateEmployeeDto;

public interface ManageEmployeesService {
    Result<Employee> addEmployee(NewEmployeeDto newEmployee);
    Result<Employee> updateEmployee(Employee employeeToUpdate, UpdateEmployeeDto updateEmployee);
    Result<Employee> deleteEmployee(Employee employeeToDelete);
}
