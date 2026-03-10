package org.motorph;

import de.siegmar.fastcsv.reader.CsvReader;
import org.motorph.employees.Employee;
import org.motorph.employees.EmploymentStatus;
import org.motorph.timesheet.Timesheet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
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
    private List<Employee> employees = new ArrayList<>();
    private List<Timesheet> timesheets = new ArrayList<>();
    private static List<Employee> employees = new ArrayList<>();
    private static List<Timesheet> timesheets = new ArrayList<>();

    public static void main(String[] args) {
        LoadEmployees();



        // Needed Presentations
        // 1. Login
        // 2. Current Employee Display
        // 3. Process Payroll Selection (elevated access/staff)
            // 1. One Employee
            // 2. All Employees
    }

    // TODO(ComProg2): refactor to a separate class
    private static void LoadEmployees() {
        var employeeStream = Main.class.getClassLoader().getResourceAsStream("employees.csv");
        if (employeeStream == null) {
            System.out.println("[MotorPH] Could not find employees.csv");
            return;
        }

        var attendanceStream = Main.class.getClassLoader().getResourceAsStream("attendance.csv");
        if (attendanceStream == null) {
            System.out.println("[MotorPH] Could not find attendance.csv");
            return;
        }

        var employeeReader = new BufferedReader(new InputStreamReader(employeeStream));
        var attendanceReader = new BufferedReader(new InputStreamReader(attendanceStream));

        try {
            var usNumberFormat = NumberFormat.getInstance(Locale.US);

            var employeeStringData = employeeReader.lines().collect(Collectors.joining("\n"));
            var employeeCsv = CsvReader.builder().ofNamedCsvRecord(employeeStringData);
            employeeCsv.stream().forEach(x -> {
                Employee employee = null;
                // Try-Catch to satisfy usNumberFormat.parse throws
                try {
                    employee = new Employee(
                            x.getField("Employee #"),
                            x.getField("Last Name"),
                            x.getField("First Name"),
                            LocalDate.parse(x.getField("Birthday"), DateTimeFormatter.ofPattern("MM/dd/yyyy")),
                            x.getField("Address"),
                            x.getField("Phone Number"),
                            x.getField("SSS #"),
                            x.getField("Philhealth #"),
                            x.getField("TIN #"),
                            x.getField("Pag-ibig #"),
                            x.getField("Status").equalsIgnoreCase("regular") ? EmploymentStatus.Regular : EmploymentStatus.Probationary,
                            x.getField("Position"),
                            new BigDecimal(usNumberFormat.parse(x.getField("Basic Salary")).doubleValue())
                    );
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                employees.add(employee);
            });

            // TODO: rebuild heirarchy from Immediate Supervisor column (not needed for now)

            var attendanceStringData = attendanceReader.lines().collect(Collectors.joining("\n"));
            var attendanceCsv = CsvReader.builder().ofNamedCsvRecord(attendanceStringData);
            attendanceCsv.stream().forEach(x -> {
                var timesheet = new Timesheet(
                        x.getField("Employee #"),
                        LocalDateTime.parse(x.getField("Date") + " " + x.getField("Log In"), DateTimeFormatter.ofPattern("MM/dd/yyyy H:mm")),
                        LocalDateTime.parse(x.getField("Date") + " " + x.getField("Log Out"), DateTimeFormatter.ofPattern("MM/dd/yyyy H:mm"))
                );
                timesheets.add(timesheet);
            });

        } catch (Exception e) {
            System.out.println("[MotorPH] Error loading employees: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
