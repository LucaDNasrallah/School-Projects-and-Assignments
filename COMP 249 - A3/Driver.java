// -----------------------------
// Assignment 2
// Name: Luca Nasrallah -40316548
// Group: COMP 249 - G-X
// -----------------------------

/* The Following code demonstrates a usage of reading from a file known as payroll.txt, that will have the contents regarding the EmployeeID, first and last name,
weekly hours worked, and their hourly Wage. The Information regarding the hours worked and hourly wage is used to create the gross salary. This information is then
processed through all the tax deductions in which are then summed together to get a number for how much deducted from the salary. All this information is then saved
an used to be written in certain files. Based on the information regarding the wage of a person inside of the payroll.txt file, if the persons wage is below 15.75$ then
the program will automatically create, clear and send that employees information to the payRollError.txt file. This will allow  a user to see all the people by their ID,
full name, hours worked, and hourly wage. Meaning if this test is passed, then the remaining people inside of payroll.txt file get transffered into the payRollReport.txt file,
where the file is created, cleared, and then written to. The contents of the file will only show a header which will demonstrate the company name, as well as Headers for where
the ID, first and last name, gross Salary, Deductions and Net salary will be displayed below it. this is done by means of interconnecting in the payroll processsor how the deduciton
class is taking the information about the gross salary in the employee class and linking their Strings together to be able to output all the displayed information.
]*/

import java.io.*;
import java.util.Scanner;
import Employees.*;

public class Driver {
    public static void main(String[] args) {
        final int MAX_EMPLOYEES = 1000000;
        Employee[] employees = new Employee[MAX_EMPLOYEES];
        int count = 0;

        // Clear previous payroll files
        clearFile("payRollReport.txt");
        clearFile("payRollError.txt");

        try (Scanner fileScanner = new Scanner(new File("payroll.txt"))) {
            while (fileScanner.hasNextLine() && count < MAX_EMPLOYEES) {
                String line = fileScanner.nextLine().trim();
                String[] parts = line.split("\\s+");

                if (parts.length != 5) {
                    System.err.println("Invalid line format: " + line);
                    continue;
                }

                try {
                    long employeeNumber = Long.parseLong(parts[0]);
                    String firstName = parts[1];
                    String lastName = parts[2];
                    double hoursWorked = Double.parseDouble(parts[3]);
                    double hourlyWage = Double.parseDouble(parts[4]);

                    employees[count++] = new Employee(employeeNumber, firstName, lastName, hoursWorked, hourlyWage);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid numeric value in: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: payroll.txt not found.");
            return;
        }

        // Process each employee
        writeHeader();
        for (int i = 0; i < count; i++) {
            PayrollProcessor.processEmployee(employees[i]);
        }
        System.out.println("Processing complete. Check payRollError.txt and payRollReport.txt.");
    }

    private static void clearFile(String filename) {
        try (FileWriter writer = new FileWriter(filename, false)) {
            // Clears the file
        } catch (IOException e) {
            System.err.println("Error clearing file: " + filename);
        }
    }

    public static void writeHeader() {
        try (FileWriter writer = new FileWriter("payRollReport.txt")) {
            writer.write("                                                  iDroid Solutions \n");
            writer.write("-----------------------------------------------------------------------------------\n");
            writer.write("ID     | First Name | Last Name  | Gross Salary | Deductions | Net Salary \n");
            writer.write("-----------------------------------------------------------------------------------\n");
        } catch (IOException e) {
            System.err.println("Error writing to payRollReport.txt: " + e.getMessage());
        }
    }
}
