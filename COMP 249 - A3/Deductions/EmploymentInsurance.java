package Deductions;

class EmploymentInsurance extends Deduction {
    EmploymentInsurance(double grossSalary) {
        super(grossSalary);
    }

    public double calculateTax() {
        double taxableIncome = getGrossSalary();
        double tax = 0;
        if (taxableIncome > 65700) {
            tax = 1077.48;
        } else {
            tax = (taxableIncome / 100) * 1.64;
        }
        return tax;
    }
}// END of EI
