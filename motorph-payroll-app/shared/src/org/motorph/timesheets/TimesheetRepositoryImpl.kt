package org.motorph.timesheets

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.runBlocking
import org.motorph.core.MotorPhException
import org.motorph.core.results.Result
import org.motorph.timesheet.Timesheet
import org.motorph.timesheet.TimesheetRepository
import java.time.LocalDateTime

class TimesheetRepositoryImpl(private val timesheetDao: TimesheetDao) : TimesheetRepository {
    override fun getAllTimesheetsByEmployeeIdAndDateRange(
        employeeId: String,
        startDate: LocalDateTime,
        endDate: LocalDateTime
    ): List<Timesheet> {
        TODO("Not yet implemented")
    }

    override fun getAllTimesheetsByEmployeeId(employeeId: String?): List<Timesheet> {
        TODO("Not yet implemented")
    }

    override fun getAllAvailableMonths(): List<String> {
        TODO("Not yet implemented")
    }

    override fun getAllAvailableMonthsByEmployeeId(employeeId: String?): List<String> {
        TODO("Not yet implemented")
    }

    override fun addTimesheet(timesheet: Timesheet): Result<Timesheet> {
        val entity = TimesheetEntity.fromTimesheet(timesheet)
        val result = runCatching {
            runBlocking {
                timesheetDao.insert(entity)
            }
        }
        return result.fold(
            onSuccess = {
                if (it > 0) Result.success(entity.toTimesheet())
                else Result.failure(MotorPhException("Failed to insert timesheet"))
            },
            onFailure = { Result.failure(MotorPhException("Failed to insert timesheet", it)) }
        )
    }

    override fun updateTimesheet(updatedTimesheet: Timesheet): Result<Timesheet> {
        TODO("Not yet implemented")
    }
}

@Dao
interface TimesheetDao {
//    @Query("SELECT * FROM timesheets")
//    suspend fun getAllTimesheetsByEmployeeIdAndDateRange(employeeId: String, startDate: LocalDateTime, endDate: LocalDateTime): List<TimesheetEntity>

    @Insert
    suspend fun insert(timesheet: TimesheetEntity): Long

    @Update
    suspend fun update(timesheet: TimesheetEntity): Int
}