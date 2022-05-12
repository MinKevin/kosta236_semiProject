package action.MyPage;

import domain.MyPage.PayStub;
import domain.MyPage.PrivateInfo;
import service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailPayStub implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        String userId = (String)request.getSession().getAttribute("userId");

        PrivateInfo privateInfo = myPageService.getUserInfo(userId);

        int p_No = Integer.parseInt(request.getParameter("p_No"));

        PayStub detailPayStub = myPageService.detailPayStub(p_No);
        System.out.println(detailPayStub.toString());
        detailPayStub.makeDetail();

        request.setAttribute("privateInfo", privateInfo);
        request.setAttribute("detailPayStub", detailPayStub);
        actionForward.setPath("/views/MyPage/DetailPayStub.jsp");

        System.out.println(detailPayStub.getIncomeTax());

        return actionForward;
    }


}
