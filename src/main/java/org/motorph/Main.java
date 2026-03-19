package org.motorph;

import de.siegmar.fastcsv.reader.CsvReader;
import org.motorph.employees.Employee;
import org.motorph.employees.EmploymentStatus;
import org.motorph.employees.Login;
import org.motorph.payroll.ConsolePayroll;
import org.motorph.payroll.PayrollService;
import org.motorph.timesheet.Timesheet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        new ConsolePayroll().Start();
    }
}
