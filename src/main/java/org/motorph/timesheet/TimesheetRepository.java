package org.motorph.timesheet;

public interface TimesheetRepository {
    Boolean AddTimesheet(Timesheet newTimesheet);
    Boolean UpdateTimesheet(Timesheet timesheetToBeUpdated);
}
