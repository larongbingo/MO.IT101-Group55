package org.motorph.timesheets

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import org.motorph.employee.EmployeeEntity
import org.motorph.timesheet.AttendanceType
import org.motorph.timesheet.Timesheet
import java.time.LocalDateTime

@Entity(
    tableName = "timesheets",
    foreignKeys = [
        ForeignKey(
            entity = EmployeeEntity::class,
            parentColumns = ["employeeId"],
            childColumns = ["employeeId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        ),
    ]
)
data class TimesheetEntity(
    val employeeId: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val attendanceType: AttendanceType,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
) {
    fun toTimesheet() = Timesheet(employeeId, startTime, endTime, attendanceType)

    companion object {
        fun fromTimesheet(timesheet: Timesheet) = TimesheetEntity(
            timesheet.EmployeeId,
            timesheet.StartTime,
            timesheet.EndTime,
            timesheet.AttendanceType,
        )
    }
}
