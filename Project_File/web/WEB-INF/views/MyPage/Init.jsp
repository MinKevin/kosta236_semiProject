<%@ page import="java.util.Enumeration" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("userId") == null) {
        System.out.println("userId is empty!");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/mypage/init.do");
        requestDispatcher.forward(request, response);
        System.out.println("빙글빙글");
    }
    session.setAttribute("exPageURI", request.getRequestURI());
    System.out.println(request.getRequestURI());

    if (session.getAttribute("trial") == null || ((boolean) session.getAttribute("trial")) == false) {
        response.sendRedirect("/mypage/getUserNo.do");
    }
    System.out.println("여기있다!");
    session.setAttribute("trial", false);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>InitPage.jsp</p>
<%--button type = button|submit|reset    --%>

<button type="button" onclick="location.href='/mypage/selectPrivateInfo.do'">개인 정보</button>
<button type="button" onclick="location.href='listAttendance.do'">근태 기록</button>
<button type="button" onclick="location.href='listAnnualLeave.do'">연차 기록</button>
<button type="button" onclick="location.href='listPayStub.do'">급여 명세서</button>
<button type="button" onclick="location.href='listPhoneBook.do'">주소록</button>
</body>
</html>
