package domain.MyPage;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class AnnualLeave implements Serializable {
    int an_no;
    int e_no;
    int an_distinct;
    double an_deduction;
    String an_startDate;
    String an_endDate;
    String an_acknowledge;


    public int getAn_no() {
        return an_no;
    }

    public int getE_no() {
        return e_no;
    }

    public int getAn_distinct() {
        return an_distinct;
    }

    public double getAn_deduction() {
        return an_deduction;
    }

    public String getAn_startDate() {
        return an_startDate;
    }

    public String getAn_endDate() {
        return an_endDate;
    }

    public String getAn_acknowledge() {
        return an_acknowledge;
    }

    public void setAn_no(int an_no) {
        this.an_no = an_no;
    }

    public void setAn_acknowledge(String an_acknowledge) {
        this.an_acknowledge = an_acknowledge;
    }

    public void setInnerData(HttpServletRequest request) {
        int userNo = (int) request.getSession().getAttribute("userNo");
        int an_no = 0;
        if (request.getParameter("an_no") != null){
           an_no = Integer.parseInt(request.getParameter("an_no"));
        }
        int an_distinct = Integer.parseInt(request.getParameter("an_distinct"));
        double an_deduction = Double.parseDouble(request.getParameter("an_deduction"));
        String an_startDate = request.getParameter("an_startDate").substring(6, 10) + "/" + request.getParameter("an_startDate").substring(0, 5);
        String an_endDate = request.getParameter("an_endDate").substring(6, 10) + "/" + request.getParameter("an_endDate").substring(0, 5);
        String an_acknowledge = "처리중";

        this.e_no = userNo;
        this.an_no = an_no;
        this.an_distinct = an_distinct;
        this.an_deduction = an_deduction;
        this.an_startDate = an_startDate;
        this.an_endDate = an_endDate;
        this.an_acknowledge = an_acknowledge;
    }
}
