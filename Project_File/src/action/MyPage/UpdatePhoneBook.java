package action.MyPage;

import domain.MyPage.PhoneBook;
import service.MyPageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdatePhoneBook implements Action {
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionForward actionForward = new ActionForward();
        MyPageService myPageService = MyPageService.getInstance();
        request.setCharacterEncoding("UTF-8");
        System.out.println("getParameter : " + request.getParameter("pb_Email"));

        int pb_No = Integer.parseInt(request.getParameter("pb_No"));

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.setInnerData(request);
        phoneBook.setPb_No(pb_No);

        System.out.println("update in action : " + phoneBook.getPb_Email());


        int result = myPageService.updatePhoneBook(phoneBook);
//        MyPage_ListDB listDB = myPageService.listDB("PhoneBook", phoneBook.getE_No(), request);
//
//        request.setAttribute("listPhoneBook", listDB);
        actionForward.setPath("phonebook");

        return actionForward;
    }
}
