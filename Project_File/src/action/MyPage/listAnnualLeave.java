package action.MyPage;

import domain.MyPage.ListDB;
import service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class listAnnualLeave implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        int userNo = (int) request.getSession().getAttribute("userNo");

        int d_no = (int) request.getSession().getAttribute("d_no");

        ListDB listDB = null;
        if (d_no == 1){
            listDB = myPageService.listDB("AnnualByAdmin", userNo, request);

        }else{
            listDB = myPageService.listDB("Annual", userNo, request);
        }



        request.setAttribute("listAnnualLeave", listDB);

        actionForward.setRedirect(false);
        actionForward.setPath("/views/MyPage/ListAnnualLeave.jsp");

        return actionForward;
    }
}
