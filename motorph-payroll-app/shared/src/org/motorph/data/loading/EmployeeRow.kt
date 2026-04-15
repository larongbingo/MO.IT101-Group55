package org.motorph.data.loading

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.motorph.core.results.Success
import org.motorph.employees.Employee
import org.motorph.employees.dto.NewEmployeeDto

@Serializable
data class EmployeeRow(
    @SerialName("Employee #")
    val employeeId: String,

    @SerialName("Last Name")
    val lastName: String,

    @SerialName("First Name")
    val firstName: String,

    @SerialName("Birthday")
    val birthday: String,

    @SerialName("Address")
    val address: String,

    @SerialName("Phone Number")
    val phoneNumber: String,

    @SerialName("SSS #")
    val sssNumber: String,

    @SerialName("Philhealth #")
    val philHealthNumber: String,

    @SerialName("TIN #")
    val taxIdNumber: String,

    @SerialName("Pag-ibig #")
    val pagibigMemberIdNumber: String,

    @SerialName("Status")
    val employmentStatus: String,

    @SerialName("Position")
    val position: String,

    @SerialName("Basic Salary")
    val basicSalary: String,

    @SerialName("Immediate Supervisor")
    val immediateSupervisor: String,
) {
    fun toDto(): NewEmployeeDto =
        NewEmployeeDto(
            this.employeeId,
            this.lastName,
            this.firstName,
            this.birthday,
            this.address,
            this.phoneNumber,
            this.sssNumber,
            this.philHealthNumber,
            this.taxIdNumber,
            this.pagibigMemberIdNumber,
            this.employmentStatus,
            this.position,
            this.basicSalary,
            "N/A"
        )
}