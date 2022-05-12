package action.MyPage;

import domain.MyPage.PrivateInfo;
import service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectPrivateInfo implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        String userId = (String)request.getSession().getAttribute("userId");
        PrivateInfo myPagePrivateInfo = myPageService.getUserInfo(userId);

        request.setAttribute("privateInfo", myPagePrivateInfo);
        actionForward.setPath("/views/MyPage/PrivateInfo.jsp");

        return actionForward;
    }
}
