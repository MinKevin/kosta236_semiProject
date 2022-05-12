package action.MyPage;

import domain.MyPage.PrivateInfo;
import service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectUserNo implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        String userId = (String)request.getSession().getAttribute("userId");
        PrivateInfo myPagePrivateInfo = myPageService.getUserInfo(userId);

        request.getSession().setAttribute("userNo", myPagePrivateInfo.getE_No());
        request.getSession().setAttribute("trial", true);

        request.getSession().setAttribute("d_no", myPagePrivateInfo.getD_No());

//        actionForward.setRedirect(false);
        actionForward.setPath("/views/MyPage/InitMyPage.jsp");

        return actionForward;
    }
}
