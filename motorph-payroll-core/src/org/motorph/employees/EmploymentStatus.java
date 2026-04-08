package org.motorph.employees;

import org.motorph.core.MotorPhException;
import org.motorph.core.results.Result;

public enum EmploymentStatus
{
    Probationary,
    Regular;

    public static Result<EmploymentStatus> parse(String input) {
        var statuses = EmploymentStatus.values();
        for (var status : statuses) {
            if (status.name().equalsIgnoreCase(input)) {
                return Result.success(status);
            }
        }
        return Result.failure(new MotorPhException("Invalid EmploymentStatus String"));
    }
}
