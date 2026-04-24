package org.motorph

import org.koin.core.context.startKoin
import org.motorph.data.appDatabaseModule
import org.motorph.employee.employeeModule
import org.motorph.timesheets.timesheetModule

fun initKoin() {
    startKoin {
        modules(
            appDatabaseModule,
            employeeModule,
            timesheetModule,
        )
    }
}
