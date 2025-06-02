package Deductions;

class QuebecParentalInsurancePlan extends Deduction {
    QuebecParentalInsurancePlan(double grossSalary) {
        super(grossSalary);
    }

    public double calculateTax() {
        double taxableIncome = getGrossSalary();
        double tax = 0;
        if (taxableIncome > 98000) {
            tax = 484.12;
        } else {
            tax = taxableIncome * 0.00494;
        }
        return tax;
    }
} // END of QPIP
