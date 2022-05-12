<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JKM
  Date: 2022-05-02
  Time: 오전 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
PrivateInfo.jsp
<button type="button" onclick="location.href='/mypage/init.do'">뒤로가기</button>
<table border="1">
    <tr>
        <td>사원번호</td>/
        <td>부서번호</td>/
        <td>아이디</td>/
        <td>비밀번호</td>
        <td>이름</td>/
        <td>전화번호</td>/
        <td>입사일</td>/
        <td>직급</td>/
        <td>서명</td>
    </tr>
    <tr>
        <%--없는 것 emp : c_No, basePay 없음--%>
        <td>${PrivateInfo.e_No}</td>
        <td>${PrivateInfo.d_No}</td>
        <td>${PrivateInfo.id}</td>
        <td>${PrivateInfo.pass}</td>
        <td>${PrivateInfo.name}</td>
        <td>${PrivateInfo.phoneNumber}</td>
        <td>${PrivateInfo.hireDate}</td>
        <td>${PrivateInfo.grade}</td>
        <td>${PrivateInfo.sign}</td>
    </tr>
</table>
</body>
</html>
