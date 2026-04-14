package org.motorph.employee

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import org.motorph.employees.Employee
import org.motorph.employees.EmploymentStatus
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(
    tableName = "employees",
    primaryKeys = ["employeeId"],
    foreignKeys = [
        ForeignKey(
            entity = EmployeeEntity::class,
            parentColumns = ["employeeId"],
            childColumns = ["supervisorId"],
            onDelete = ForeignKey.RESTRICT,
            onUpdate = ForeignKey.CASCADE,
        )
    ],
    indices = [Index(value = ["supervisorId"], unique = false)]
)
data class EmployeeEntity(
    val employeeId: String,
    val lastName: String,
    val firstName: String,
    val birthday: LocalDate,
    val address: String,
    val phoneNumber: String,
    val sssNumber: String,
    val philHealthNumber: String,
    val taxIdNumber: String,
    val pagibigMemberIdNumber: String,
    val employmentStatus: EmploymentStatus,
    val position: String,
    val basicSalary: Double,
    val createdAt: LocalDateTime,
    val deletedAt: LocalDateTime?,
    val supervisorId: String?,
) {
    fun toEmployee() = Employee(
        employeeId,
        lastName,
        firstName,
        birthday,
        address,
        phoneNumber,
        sssNumber,
        philHealthNumber,
        taxIdNumber,
        pagibigMemberIdNumber,
        employmentStatus,
        position,
        basicSalary,
        supervisorId,
        createdAt,
        deletedAt,
    )

    companion object {
        fun fromEmployee(employee: Employee) = EmployeeEntity(
            employee.EmployeeId,
            employee.LastName,
            employee.FirstName,
            employee.Birthday,
            employee.Address,
            employee.PhoneNumber,
            employee.SSSNumber,
            employee.PhilHealthNumber,
            employee.TaxIdNumber,
            employee.PagibigMemberIdNumber,
            employee.EmploymentStatus,
            employee.Position,
            employee.BasicSalary,
            employee.CreatedAt,
            employee.DeletedAt,
            employee.SupervisorId,
        )
    }
}