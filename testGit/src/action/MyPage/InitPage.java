package action.MyPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitPage implements Action {
    public ActionForward execute (HttpServletRequest req, HttpServletResponse resp) throws Exception{
        ActionForward actionForward = new ActionForward();

        //actionForward.setRedirect(false);
        actionForward.setPath("/views/MyPage/InitMyPage.jsp");

        return actionForward;
    }
}
