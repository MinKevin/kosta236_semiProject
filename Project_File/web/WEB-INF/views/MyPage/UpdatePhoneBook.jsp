<%--
  Created by IntelliJ IDEA.
  User: JKM
  Date: 2022-05-03
  Time: 오후 8:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    UpdatePhoneBook.jsp
    <form action="/mypage/updatePhoneBook.do" method="get">
        <input type="hidden" name="pb_No" value="${phoneBook.pb_No}">
        <p>회사 : <input type="text" name="pb_Cpn" value="${phoneBook.pb_Cpn}"></p>
        <p>이름 : <input type="text" name="pb_Name" value="${phoneBook.pb_Name}"></p>
        <p>전화번호 : <input type="text" name="pb_PhoneNumber" value="${phoneBook.pb_PhoneNumber}"></p>
        <p>직급 : <input type="text" name="pb_Rank" value="${phoneBook.pb_Rank}"></p>
        <p>이메일 : <input type="text" name="pb_Email" value="${phoneBook.pb_Email}"></p>
        <p><button type="submit">저장</button></p>
    </form>
</body>
</html>
