package org.motorph

import org.koin.core.context.startKoin
import org.motorph.data.appDatabaseModule
import org.motorph.employee.employeeModule

fun initKoin() {
    startKoin {
        modules(
            appDatabaseModule,
            employeeModule,
        )
    }
}
