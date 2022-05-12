package action.MyPage;

import domain.MyPage.PrivateInfo;
import service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePrivateInfo implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();

        System.out.println(Integer.parseInt(request.getParameter("e_No")));
        request.setCharacterEncoding("UTF-8");
        int e_No = Integer.parseInt(request.getParameter("e_No"));
        int d_No = Integer.parseInt(request.getParameter("d_No"));
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String grade = request.getParameter("grade");;
        String phoneNumber = request.getParameter("phoneNumber");;
        String hireDate = request.getParameter("hireDate");;
        PrivateInfo privateInfo = new PrivateInfo(e_No, d_No, id, name, grade, phoneNumber, hireDate);

        int result = myPageService.updatePrivateInfo(privateInfo);
        String userId = (String) request.getSession().getAttribute("userId");
        privateInfo = myPageService.getUserInfo(userId);

        request.getSession().setAttribute("userId", userId);
        request.setAttribute("privateInfo", privateInfo);
        actionForward.setPath("/views/MyPage/PrivateInfo.jsp");
        return actionForward;
    }
}
