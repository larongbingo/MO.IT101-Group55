package org.motorph.employee.login

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import org.motorph.employee.EmployeeEntity
import org.motorph.employees.login.Login

@Entity(
    tableName = "logins",
    foreignKeys = [
        ForeignKey(
            entity = EmployeeEntity::class,
            parentColumns = ["employeeId"],
            childColumns = ["employeeId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        ),
    ],
    indices = [
        Index(value = ["employeeId"], unique = false),
        Index(value = ["username"], unique = true),
    ]
)
data class LoginEntity(
    val employeeId: String,
    val username: String,
    val password: String,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
) {
    fun toLogin() = Login(employeeId, username, password)

    companion object {
        fun fromLogin(login: Login) =
            LoginEntity(login.EmployeeId, login.Username, login.Password)
    }
}
