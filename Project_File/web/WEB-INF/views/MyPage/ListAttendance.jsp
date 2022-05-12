<%@ page import="domain.Attendance" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JKM
  Date: 2022-04-29
  Time: 오후 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Attendance.jsp</p>
<button type="button" onclick="">로그아웃</button>
<button type="button" onclick="location.href='/mypage/init.do'">뒤로가기</button>
<table border="1">
    <tr>
        <td>사원 번호</td>
        <td>날 짜</td>
        <td>출근 시간</td>
        <td>퇴근 시간</td>
    </tr>
    <c:forEach var="Attendance" items="${listAttendance.list}">
        <tr>
                <%--없는 것 attendance : a_no(attendance_no)--%>
            <td>${Attendance.e_No}</td>
            <td>${Attendance.a_Date}</td>
            <td>${Attendance.a_CheckIn}</td>
            <td>${Attendance.a_CheckOut}</td>
        </tr>
    </c:forEach>
    <tr>

    </tr>
</table>
<%--페이징 처리 부분--%>

<%--이전 영역--%>
<c:if test="${listAttendance.startPage >= 6}">
    <a href="listAttendance.do?pageNum=${listAttendance.startPage - 1}">[이전]</a>
</c:if>

<%--페이지 목록 출력--%>
<c:forEach var="pageNo" begin="${listAttendance.startPage}" end="${listAttendance.endPage}">
    <c:if test="${listAttendance.requestPage == pageNo}"><b></c:if>
    <a href="listAttendance.do?pageNum=${pageNo}">[${pageNo}]</a>
    <c:if test="${listAttendance.requestPage == pageNo}"></b></c:if>
</c:forEach>

<%--이후 영역--%>
<c:if test="${listAttendance.endPage < listAttendance.totalPageCount}">
    <a href="listAttendance.do?pageNum=${listAttendance.endPage + 1}">[이후]</a>
</c:if>

</body>
</html>
