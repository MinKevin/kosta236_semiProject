<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JKM
  Date: 2022-05-03
  Time: 오후 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("listPhoneBook", request.getAttribute("listPhoneBook"));
    System.out.println(request.getAttribute("listPhoneBook"));
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
listPhoneBook.jsp
<button type="button" onclick="location.href='/mypage/init.do'">뒤로가기</button>
<button type="button" onclick="location.href='/mypage/insertPhoneBookPage.do'">추가</button>
<table border="1">
    <tr>
        <td>회사명</td>
        <td>이름</td>
        <td>전화번호</td>
        <td>직급</td>
        <td>이메일</td>
    </tr>
    <c:forEach var="phoneBook" items="${listPhoneBook.list}">
        <form method="get" action="/mypage/updatePhoneBookPage.do">
            <tr>
                <input type="hidden" name="pb_No" value="${phoneBook.pb_No}">
                <td>${phoneBook.pb_Cpn}</td>
                <td>${phoneBook.pb_Name}</td>
                <td>${phoneBook.pb_PhoneNumber}</td>
                <td>${phoneBook.pb_Rank}</td>
                <td>${phoneBook.pb_Email}</td>
                <td>
                    <button type="submit">수정</button>
                </td>
            </tr>
        </form>
    </c:forEach>
</table>

<%--페이징 처리 부분--%>

<%--이전 영역--%>
<c:if test="${listPhoneBook.startPage >= 6}">
    <a href="listPhoneBook.do?pageNum=${listPhoneBook.startPage - 1}">[이전]</a>
</c:if>

<%--페이지 목록 출력--%>
<c:forEach var="pageNo" begin="${listPhoneBook.startPage}" end="${listPhoneBook.endPage}">
    <c:if test="${listPhoneBook.requestPage == pageNo}"><b></c:if>
    <a href="listPhoneBook.do?pageNum=${pageNo}">[${pageNo}]</a>
    <c:if test="${listPhoneBook.requestPage == pageNo}"></b></c:if>
</c:forEach>

<%--이후 영역--%>
<c:if test="${listPhoneBook.endPage < listPhoneBook.totalPageCount}">
    <a href="listPhoneBook.do?pageNum=${listPhoneBook.endPage + 1}">[이후]</a>
</c:if>
</body>
</html>
