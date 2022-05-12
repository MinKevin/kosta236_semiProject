package domain.MyPage;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

public class PhoneBook implements Serializable {
    int pb_No;
    int e_No;
    String pb_Cpn;
    String pb_Name;
    String pb_PhoneNumber;
    String pb_Rank;
    String pb_Email;

    public PhoneBook() {
    }

    public int getPb_No() {
        return pb_No;
    }

    public int getE_No() {
        return e_No;
    }

    public String getPb_Cpn() {
        return pb_Cpn;
    }

    public String getPb_Name() {
        return pb_Name;
    }

    public String getPb_PhoneNumber() {
        return pb_PhoneNumber;
    }

    public String getPb_Rank() {
        return pb_Rank;
    }

    public String getPb_Email() {
        return pb_Email;
    }

    public void setPb_No(int pb_No) {
        this.pb_No = pb_No;
    }

    public void setE_No(int e_No) {
        this.e_No = e_No;
    }

    public void setPb_Cpn(String pb_Cpn) {
        this.pb_Cpn = pb_Cpn;
    }

    public void setPb_Name(String pb_Name) {
        this.pb_Name = pb_Name;
    }

    public void setPb_PhoneNumber(String pb_PhoneNumber) {
        this.pb_PhoneNumber = pb_PhoneNumber;
    }

    public void setPb_Rank(String pb_Rank) {
        this.pb_Rank = pb_Rank;
    }

    public void setPb_Email(String pb_Email) {
        this.pb_Email = pb_Email;
    }

    public void setInnerData(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        int userNo = (int)request.getSession().getAttribute("userNo");
        String pb_Cpn = request.getParameter("pb_Cpn");
        String pb_Name = request.getParameter("pb_Name");
        String pb_PhoneNumber = request.getParameter("pb_PhoneNumber");
        String pb_Rank = request.getParameter("pb_Rank");
        String pb_Email = request.getParameter("pb_Email");

        this.e_No = userNo;
        this.pb_Cpn = pb_Cpn;
        this.pb_Name = pb_Name;
        this.pb_PhoneNumber = pb_PhoneNumber;
        this.pb_Rank = pb_Rank;
        this.pb_Email = pb_Email;
    }
}
