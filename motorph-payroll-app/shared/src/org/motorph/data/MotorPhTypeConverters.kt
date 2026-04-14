package org.motorph.data

import androidx.room.TypeConverter
import org.motorph.employees.EmploymentStatus
import java.time.LocalDate
import java.time.LocalDateTime


class MotorPhTypeConverters {
    @TypeConverter
    fun fromEmploymentStatus(value: EmploymentStatus): String = value.name

    @TypeConverter
    fun toEmploymentStatus(value: String): EmploymentStatus = EmploymentStatus.valueOf(value)

    @TypeConverter
    fun fromLocalDate(value: LocalDate): String = value.toString()

    @TypeConverter
    fun toLocalDate(value: String): LocalDate = LocalDate.parse(value)

    @TypeConverter
    fun fromLocalDateTime(value: LocalDateTime): String = value.toString()

    @TypeConverter
    fun toLocalDateTime(value: String): LocalDateTime = LocalDateTime.parse(value)
}