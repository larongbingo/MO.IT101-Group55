package org.motorph.data

import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.module.Module
import org.koin.dsl.module
import java.io.File

actual val platformModule: Module = module {
    single {
        val dbFile = File(System.getProperty("user.home"), ".motorph/payroll.db")
        dbFile.parentFile?.mkdirs()
        Room.databaseBuilder<AppDatabase>(
            name = dbFile.absolutePath,
        )
    }
}