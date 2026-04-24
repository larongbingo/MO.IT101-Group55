package org.motorph.timesheet;

import java.time.Duration;
import java.time.LocalDateTime;

public class Timesheet {
    /**
     * Console app specific constructor
     */
    public Timesheet(String employeeId, LocalDateTime startTime, LocalDateTime endTime) {
        this(employeeId, startTime, endTime, org.motorph.timesheet.AttendanceType.AtWork);
    }

    /**
     * ORM specific constructor
     */
    public Timesheet(String employeeId, LocalDateTime startTime, LocalDateTime endTime, AttendanceType attendanceType) {
        EmployeeId = employeeId;
        StartTime = startTime;
        EndTime = endTime;
        AttendanceType = attendanceType;
    }

    public final String EmployeeId;
    public final LocalDateTime StartTime;
    public LocalDateTime EndTime;
    public final AttendanceType AttendanceType;

    public double getTotalHours() {
        return Duration.between(StartTime, EndTime).toHours();
    }
}
