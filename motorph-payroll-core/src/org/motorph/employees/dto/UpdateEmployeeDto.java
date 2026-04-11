package org.motorph.employees.dto;

import org.motorph.core.results.Success;
import org.motorph.employees.Employee;
import org.motorph.employees.EmploymentStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record UpdateEmployeeDto(
        String LastName,
        String FirstName,
        String Birthday,
        String Address,
        String PhoneNumber,
        String SSSNumber,
        String PhilHealthNumber,
        String TaxIdNumber,
        String PagibigMemberIdNumber,
        String EmploymentStatus,
        String Position,
        String BasicSalary,
        String SupervisorId
) {
    public boolean updateEmployee(Employee employeeToUpdate) {
        var isUpdated = false;

        if (this.LastName() != null) {
            employeeToUpdate.LastName = this.LastName();
            isUpdated = true;
        }

        if (this.FirstName() != null) {
            employeeToUpdate.FirstName = this.FirstName();
            isUpdated = true;
        }

        if (this.Birthday() != null) {
            employeeToUpdate.Birthday =
                    LocalDate.parse(this.Birthday(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            isUpdated = true;
        }

        if (this.Address() != null) {
            employeeToUpdate.Address = this.Address();
            isUpdated = true;
        }

        if (this.PhoneNumber() != null) {
            employeeToUpdate.PhoneNumber = this.PhoneNumber();
            isUpdated = true;
        }

        if (this.SSSNumber() != null) {
            employeeToUpdate.SSSNumber = this.SSSNumber();
            isUpdated = true;
        }

        if (this.PhilHealthNumber() != null) {
            employeeToUpdate.PhilHealthNumber = this.PhilHealthNumber();
            isUpdated = true;
        }

        if (this.TaxIdNumber() != null) {
            employeeToUpdate.TaxIdNumber = this.TaxIdNumber();
            isUpdated = true;
        }

        if (this.PagibigMemberIdNumber() != null) {
            employeeToUpdate.PagibigMemberIdNumber = this.PagibigMemberIdNumber();
            isUpdated = true;
        }

        if (this.EmploymentStatus() != null) {
            var res = org.motorph.employees.EmploymentStatus.parse(this.EmploymentStatus());
            if (res.isSuccess()) {
                var val = ((Success<EmploymentStatus>)res).value();
                employeeToUpdate.EmploymentStatus = val;
                isUpdated = true;
            }
        }

        return isUpdated;
    }
}