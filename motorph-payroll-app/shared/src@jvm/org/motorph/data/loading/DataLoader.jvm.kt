package org.motorph.data.loading

import java.io.InputStream

actual val employeesStream: InputStream = ClassLoader.getSystemResourceAsStream("employees.csv")
actual val loginsStream: InputStream = ClassLoader.getSystemResourceAsStream("logins.csv")
actual val attendanceStream: InputStream = ClassLoader.getSystemResourceAsStream("attendance.csv")