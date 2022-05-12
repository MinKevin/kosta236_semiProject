package action.MyPage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class insertAnnualLeavePage implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = new ActionForward();

        actionForward.setPath("/views/MyPage/InsertAnnualLeave.jsp");

        return actionForward;
    }
}
