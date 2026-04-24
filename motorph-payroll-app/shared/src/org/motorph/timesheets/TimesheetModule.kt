package org.motorph.timesheets

import org.koin.dsl.module
import org.motorph.data.AppDatabase
import org.motorph.timesheet.TimesheetRepository

val timesheetModule = module {
    single<TimesheetDao> { get<AppDatabase>().timesheetDao() }
    single<TimesheetRepository> { TimesheetRepositoryImpl(get()) }
}