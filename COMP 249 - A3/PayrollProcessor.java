import java.io.FileWriter;
import java.io.IOException;
import Deductions.*;
import Employees.*;

class PayrollProcessor {
    private static final double MINIMUM_WAGE = 15.75;
    static int errorCounter = 0;
    public static void processEmployee(Employee employee) {
        try {
            if (employee.getHourlyWage() < MINIMUM_WAGE) {
                throw new MinimumWageException("Salary below minimum wage: " + employee.getHourlyWage());
            }
            Deduction deduction = new TotalTaxDeductions(employee.getCalculatedGrossSalary());
            writeToPayrollReport(employee, deduction);
        } catch (MinimumWageException e) {
            writeToErrorLog(employee);
            errorCounter++;
        }
    }

    private static void writeToPayrollReport(Employee employee, Deduction deduction) {
        try (FileWriter writer = new FileWriter("payRollReport.txt", true)) {
            double grossSalary = employee.getCalculatedGrossSalary();
            double totalDeductions = deduction.calculateTax();
            double netSalary = grossSalary - totalDeductions;

            writer.write(String.format("%-6d | %-10s | %-10s | $%-11.2f | $%-10.2f | $%-10.2f\n",
                    employee.getEmployeeNumber(), employee.getFirstName(), employee.getLastName(),
                    grossSalary, totalDeductions, netSalary));
        } catch (IOException e) {
            System.err.println("Error writing to payRollReport.txt: " + e.getMessage());
        }
    }

    private static void writeToErrorLog(Employee employee) {
        try (FileWriter writer = new FileWriter("payRollError.txt", true)) {
            writer.write(employee.toString() +employee.getHoursWorked()+ employee.getHourlyWage()+"\n");
        } catch (IOException e) {
            System.err.println("Error writing to payRollError.txt: " + e.getMessage());
        }
    }
}
