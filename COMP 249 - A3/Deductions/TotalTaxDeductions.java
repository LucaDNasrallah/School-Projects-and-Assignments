package Deductions;

public class TotalTaxDeductions extends Deduction {

    public TotalTaxDeductions(double grossSalary) {
        super(grossSalary);
    }
    public double calculateTax() {
       ProvincialIncomeTax PIT = new ProvincialIncomeTax(grossSalary);
       FederalIncomeTax FIT = new FederalIncomeTax(grossSalary);
       QuebecPensionPlan QPP = new QuebecPensionPlan(grossSalary);
       EmploymentInsurance EPI = new EmploymentInsurance(grossSalary);
       QuebecParentalInsurancePlan QIP = new QuebecParentalInsurancePlan(grossSalary);
        return PIT.calculateTax() + FIT.calculateTax() + QPP.calculateTax() + EPI.calculateTax() + QIP.calculateTax();
    }
}
