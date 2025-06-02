package Deductions;

class ProvincialIncomeTax extends Deduction {
    ProvincialIncomeTax(double grossSalary) {
        super(grossSalary);
    }
    public double calculateTax(){
        double taxableIncome = getGrossSalary();
        double tax = 0;

        if (taxableIncome <= 18571) {
            tax = 0;
        } else if(taxableIncome > 18571 && taxableIncome <= 53255){
            tax = taxableIncome * 0.14;
        }else if(taxableIncome > 53255 && taxableIncome <= 106495){
            tax = taxableIncome * 0.19;
        }else if(taxableIncome > 106495 && taxableIncome <= 129590){
            tax = taxableIncome * 0.24;
        }else if(taxableIncome > 129590){
            tax = taxableIncome * 0.2575;
        }
        return tax;
    }
}// END OF PIT
