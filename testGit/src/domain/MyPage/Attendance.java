package domain.MyPage;

import java.io.Serializable;

public class Attendance implements Serializable {
    int a_No;
    int e_No;
    String a_Date;
    String a_CheckIn;
    String a_CheckOut;

    public int getA_No() {
        return a_No;
    }

    public int getE_No() {
        return e_No;
    }

    public String getA_Date() {
        return a_Date;
    }

    public String getA_CheckIn() {
        return a_CheckIn;
    }

    public String getA_CheckOut() {
        return a_CheckOut;
    }
}
