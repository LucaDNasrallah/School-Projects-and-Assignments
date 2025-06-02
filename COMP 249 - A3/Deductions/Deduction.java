package Deductions;
import Employees.*;

public abstract class Deduction {
    protected double grossSalary;

    public Deduction(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getGrossSalary() { return grossSalary; }
    public abstract double calculateTax();
}
