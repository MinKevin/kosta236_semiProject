package action.MyPage;

import domain.MyPage.ListDB;
import service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deletePhoneBook implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        int pb_No = Integer.parseInt(request.getParameter("pb_No"));
        int result = myPageService.deletePhoneBook(pb_No);
        int userNo = (int) request.getSession().getAttribute("userNo");

        ListDB listDB = myPageService.listDB("PhoneBook", userNo, request);

        request.setAttribute("listPhoneBook", listDB);

        actionForward.setPath("/views/MyPage/ListPhoneBook.jsp");

        return actionForward;
    }
}
