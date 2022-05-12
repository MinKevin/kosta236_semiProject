package action.MyPage;

import domain.MyPage.ListDB;
import domain.MyPage.PayStub;
import domain.MyPage.PrivateInfo;
import service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class ListPayStub implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        String userId = (String) request.getSession().getAttribute("userId");
        int userNo = (int) request.getSession().getAttribute("userNo");
        ListDB listDB = myPageService.listDB("PayStub", userNo, request);

        //현재 날짜 받아오기
        LocalDate now = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        String formattedNow = now.format(formatter);

        String presentYear = formattedNow.substring(0, 4);
        String presentMonth = formattedNow.substring(5, 7);
        String presentDay = formattedNow.substring(8, 10);

        String year = presentYear;
        String month = presentMonth;

        //선택된 날짜 받아오기
        String selectedYear = request.getParameter("selectedYear");
        String selectedMonth = request.getParameter("selectedMonth");
        System.out.println("year, month : " + selectedYear + selectedMonth);

        if (selectedMonth != null && selectedYear != null && !presentYear.equals(selectedYear) && !presentMonth.equals(selectedMonth)) {
                year = selectedYear;
                month = selectedMonth;
        } else if (Integer.parseInt(presentDay) < 10) {
            month = Integer.toString((Integer.parseInt(month) - 1));
        }
        System.out.println("year, month : " + year + month);
        request.setAttribute("year", year);
        request.setAttribute("month", month);

        //데이터 임의 조작 부분
//        presentYear = "2022";
//        presentMonth = "03";
//        year = "2022";
//        month = "03";
        //

        if (Integer.parseInt(presentYear) == Integer.parseInt(year) && Integer.parseInt(presentMonth) == Integer.parseInt(month)) {
            boolean HaveToMakePayStub = true;
            for (int i = 0; i < listDB.getList().size(); i++) {
                String db_year = ((List<PayStub>)listDB.getList()).get(i).getP_Date().substring(0, 4);
                String db_month = ((List<PayStub>)listDB.getList()).get(i).getP_Date().substring(5, 7);
                String db_day = ((List<PayStub>)listDB.getList()).get(i).getP_Date().substring(8, 10);

                if (Integer.parseInt(db_year) == Integer.parseInt(year) && Integer.parseInt(db_month) == Integer.parseInt(month)) {
                    HaveToMakePayStub = false;
                    break;
                }
            }

            //명세서 생성이 필요할 때
            if (HaveToMakePayStub == true) {
                PrivateInfo privateInfo = myPageService.getUserInfo(userId);
                int p_basePay = privateInfo.getBasePay();
                int nextP_No = 1;
                if (listDB.getList().size() != 0){
                    nextP_No = ((List<PayStub>)listDB.getList()).get(0).getP_No() + 1;
                }
                int e_No = privateInfo.getE_No();
//                String p_Date = formattedNow;
                String p_Date = presentYear + "/" + presentMonth + "/" + "10";
                PayStub myPagePayStub = new PayStub(nextP_No, e_No, p_Date, p_basePay);
                myPagePayStub.makeDetail();
                myPageService.insertPayStub(myPagePayStub);
                listDB = myPageService.listDB("PayStub", userNo, request);
            }
        }
        request.setAttribute("listPayStub", listDB);

        actionForward.setPath("/views/MyPage/ListPayStub.jsp");

        return actionForward;
    }
}
