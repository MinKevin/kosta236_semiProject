package domain.MyPage;

import java.io.Serializable;

public class PrivateInfo implements Serializable {
    int e_No;
    int c_No;
    int d_No;
    String id;
    String pass;
    String name;
    String grade;
    String phoneNumber;
    String hireDate;
    String sign;
    int basePay;

    public PrivateInfo() {
    }

    public PrivateInfo(int e_No, int d_No, String id, String name, String grade, String phoneNumber, String hireDate) {
        this.e_No = e_No;
        this.d_No = d_No;
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
    }

    public int getBasePay() {
        return basePay;
    }

    public int getE_No() {
        return e_No;
    }

    public int getC_No() {
        return c_No;
    }

    public int getD_No() {
        return d_No;
    }

    public String getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHireDate() {
        return hireDate;
    }

    public String getGrade() {
        return grade;
    }

    public String getSign() {
        return sign;
    }
}
