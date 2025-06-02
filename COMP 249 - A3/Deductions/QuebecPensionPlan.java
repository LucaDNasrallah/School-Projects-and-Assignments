package Deductions;

class QuebecPensionPlan extends Deduction {
    QuebecPensionPlan(double grossSalary) {
        super(grossSalary);
    }

    public double calculateTax() {
        double taxableIncome = getGrossSalary();
        double tax = 0;
        if (taxableIncome > 71300) {
            tax = 7700.40;
        } else {
            tax = taxableIncome * 0.108;
        }
        return tax;
    }
}// END of QPP
