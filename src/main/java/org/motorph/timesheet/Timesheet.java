package org.motorph.timesheet;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public class Timesheet {
    @NotNull public final String EmployeeId;
    @NotNull public final LocalDateTime StartTime;
    public LocalDateTime EndTime;
    @NotNull public final AttendanceType AttendanceType;

    public Timesheet(String employeeId, LocalDateTime startTime, LocalDateTime endTime) {
        EmployeeId = employeeId;
        StartTime = startTime;
        EndTime = endTime;
        AttendanceType = org.motorph.timesheet.AttendanceType.AtWork;
    }
}
