package domain.MyPage;

import java.io.Serializable;

import static java.lang.Math.round;

public class PayStub implements Serializable {
    final int mealAllowance = 200000;
    final double incomeTaxRate = 0.0283;
    final double inhabitantsTaxRate = 0.0028;
    final double nationalPensionRate = 0.045;
    final double employmentInsuranceRate = 0.008;
    final double healthInsuranceRate = 0.0343;

    int incomeTax;
    int inhabitantsTax;
    int nationalPension;
    int employmentInsurance;
    int healthInsurance;

    int p_No;
    int e_No;
    String p_Date;


    int p_BasePay;
    int p_NetPay;

    public PayStub() {
    }

    public PayStub(int nextP_No, int e_No, String p_Date, int p_BasePay) {
        this.p_No = nextP_No;
        this.e_No = e_No;
        this.p_Date = p_Date;
        this.p_BasePay = p_BasePay;
    }

    public void makeDetail() {
        //식대, 소득세, 국민연금, 고용보험, 건강보험
        //DecimalFormat df = new DecimalFormat("#");
        //String a = df.format(double);

        this.incomeTax = (int) (p_BasePay * incomeTaxRate);
        this.inhabitantsTax = (int) (p_BasePay * inhabitantsTaxRate);
        this.nationalPension = (int) (p_BasePay * nationalPensionRate);
        this.employmentInsurance = (int) (p_BasePay * employmentInsuranceRate);
        this.healthInsurance =  (int) (p_BasePay * healthInsuranceRate);
        double p_basePayBuf = p_BasePay
                - (incomeTax + inhabitantsTax + nationalPension + employmentInsurance + healthInsurance)
                + mealAllowance;
        //십원까지만 출력
        p_basePayBuf /= 10;
        p_basePayBuf = round(p_basePayBuf);
        p_basePayBuf *= 10;
        this.p_NetPay = (int) p_basePayBuf;
    }

    public int getP_No() {
        return p_No;
    }

    public int getE_No() {
        return e_No;
    }

    public String getP_Date() {
        return p_Date;
    }

    public int getP_NetPay() {
        return p_NetPay;
    }

    public int getMealAllowance() {
        return mealAllowance;
    }

    public double getIncomeTaxRate() {
        return incomeTaxRate;
    }

    public double getInhabitantsTaxRate() {
        return inhabitantsTaxRate;
    }

    public double getNationalPensionRate() {
        return nationalPensionRate;
    }

    public double getEmploymentInsuranceRate() {
        return employmentInsuranceRate;
    }

    public double getHealthInsuranceRate() {
        return healthInsuranceRate;
    }

    public int getIncomeTax() {
        return incomeTax;
    }

    public int getInhabitantsTax() {
        return inhabitantsTax;
    }

    public int getNationalPension() {
        return nationalPension;
    }

    public int getEmploymentInsurance() {
        return employmentInsurance;
    }

    public int getHealthInsurance() {
        return healthInsurance;
    }

    public int getP_BasePay() {
        return p_BasePay;
    }
}
