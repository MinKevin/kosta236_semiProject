package controller;

import action.MyPage.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mypage/*")
public class MyPageController extends HttpServlet {
    //request.getMethod() : GET, POST 반환
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getMethod());
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        System.out.println("requestURI : " + requestURI);
        System.out.println("contextPath : " + contextPath);

        String command = requestURI.substring((contextPath + "/mypage/").length());

        ActionForward actionForward = new ActionForward();

        System.out.println("command : " + command);
        Action action = null;

        if (command.equals("init")) {
            action = new InitPage();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("getUserNo.do")) {
            action = new SelectUserNo();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("private-info")) {
            action = new SelectPrivateInfo();
            System.out.println("selectPrivateInfo.do");
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("attendance")) {
            action = new ListAttendance();
            System.out.println("attendance");
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("annual-leave")) {
            action = new listAnnualLeave();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("insertAnnualLeave")) {
            action = new insertAnnualLeavePage();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("paystub")) {
            action = new ListPayStub();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("detailPayStub.do")) {
            action = new DetailPayStub();
            System.out.println("detailPayStub.do");
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("phonebook")) {
            action = new ListPhoneBook();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("insertPhoneBookPage.do")) {
            action = new InsertPhoneBookPage();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!actionForward.isRedirect()) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(actionForward.getPath());
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect(actionForward.getPath());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println(request.getMethod());
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        System.out.println("requestURI : " + requestURI);
        System.out.println("contextPath : " + contextPath);

        String command = requestURI.substring((contextPath + "/mypage/").length());

        ActionForward actionForward = new ActionForward();

        System.out.println("command : " + command);
        Action action = null;

        if (command.equals("updatePrivateInfo.do")) {
            action = new UpdatePrivateInfo();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("annual-leave")) {
            action = new listAnnualLeave();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("insertAnnualLeave.do")) {
            action = new insertAnnualLeave();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("referAnnualLeave.do")) {
            action = new ReferAnnualLeave();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("acknowledgeAnnualLeave.do")) {
            action = new AcknowledgeAnnualLeave();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (command.equals("onProgressAnnualLeave.do")) {
            action = new OnProgressAnnualLeave();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("phonebook")) {
            action = new ListPhoneBook();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("insertPhoneBook.do")) {
            action = new InsertPhoneBook();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("updatePhoneBookPage.do")) {
            action = new UpdatePhoneBookPage();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("updatePhoneBook.do")) {
            action = new UpdatePhoneBook();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (command.equals("deletePhoneBook.do")) {
            action = new deletePhoneBook();
            try {
                actionForward = action.execute(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (!actionForward.isRedirect()) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(actionForward.getPath());
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect(actionForward.getPath());
        }
    }
}

