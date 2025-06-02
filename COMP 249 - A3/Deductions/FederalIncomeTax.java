package Deductions;

class FederalIncomeTax extends Deduction {
    FederalIncomeTax(double salary) {
        super(salary);
    }
    public double calculateTax() {
        double taxableIncome = getGrossSalary();
        double tax = 0;
        if (taxableIncome < 16129){
            tax = 0;
        }
        else if(taxableIncome >= 16129 && taxableIncome <= 57375){
            tax = taxableIncome * 0.15;
        } else if(taxableIncome > 57376 && taxableIncome <= 114750){
            tax = taxableIncome * 0.205;
        }else if(taxableIncome > 114751 && taxableIncome <= 177882){
            tax = taxableIncome * 0.26;
        }else if(taxableIncome > 177883 && taxableIncome <=253414){
            tax = taxableIncome * 0.29;
        }else if(taxableIncome > 253414){
            tax = taxableIncome * 0.33;
        }
        return tax;
    }
}// END of FIT
