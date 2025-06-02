package Employees;

public class Employee {
    private long employeeNumber;
    private String firstName, lastName;
    private double hoursWorked, hourlyWage;

    public Employee(long employeeNumber, String fName, String lName, double hoursWorked, double hourlyWage) {
        this.employeeNumber = employeeNumber;
        this.firstName = fName;
        this.lastName = lName;
        this.hoursWorked = hoursWorked;
        this.hourlyWage = hourlyWage;
    }

    public long getEmployeeNumber() { return employeeNumber; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getHourlyWage() { return hourlyWage; }
    public double getHoursWorked() { return hoursWorked; }

    public double calculatingGrossSalary() {
        return hoursWorked * hourlyWage * 52;
    }

    public double getCalculatedGrossSalary() { return calculatingGrossSalary(); }

    @Override
    public String toString() {
        return String.format("%-6d | %-10s | %-10s | $%-11.2f", employeeNumber, firstName, lastName, calculatingGrossSalary());
    }
}
