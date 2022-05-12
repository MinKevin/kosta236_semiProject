<%@ page import="domain.MyPage.PrivateInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  //테스트 부분
  String testId = "testId";
  session.setAttribute("userId", testId);

//  PrivateInfo emp = null;
//  try{
//     emp = (PrivateInfo) session.getAttribute("emp");
//    if (emp.getId() != null){
//      session.setAttribute("userId", emp.getId());
//    }
//  } catch (Exception e){
//    e.printStackTrace();
//  }


%>

<html>
<head>
  <title>MainPage</title>

  <script>
    <%--GET 방식--%>
    location.href = "/testGit/mypage/init"
  </script>
</head>
<body>
</body>
</html>