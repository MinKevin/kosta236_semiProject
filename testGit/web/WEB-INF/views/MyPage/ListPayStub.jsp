<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JKM
  Date: 2022-05-02
  Time: 오후 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //현재 날짜 및 연 월 입력
    LocalDate now = LocalDate.now();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    String formattedNow = now.format(formatter);

    request.setAttribute("formattedNow", formattedNow);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
listPayStub.jsp
<button type="button" onclick="location.href='/mypage/init.do'">뒤로가기</button>
<form method="get" action="/mypage/listPayStub.do">
    <select name="selectedYear">
        <c:forEach var="i" begin="2000" end="2022">
            <c:set var="presentYear" value="<%=formattedNow.substring(0, 4)%>"/>
            <c:choose>
                <c:when test="${i eq presentYear}">
                    <option value="${i}" selected>${i}년</option>
                </c:when>
                <c:otherwise>
                    <option value="${i}">${i}년</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
    <select name="selectedMonth">
        <c:forEach var="i" begin="1" end="12">
            <c:set var="presentMonth" value="<%=formattedNow.substring(5, 7)%>"/>
            <c:choose>
                <c:when test="${i eq presentMonth}">
                    <option value="${i}" selected>${i}월</option>
                </c:when>
                <c:otherwise>
                    <option value="${i}">${i}월</option>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </select>
    <button type="submit">조회</button>
</form>

<table board="1">
    <tr>
        <td>번호</td>
        <td>사원번호</td>
        <td>지급일</td>
        <td>기본급여</td>
        <td>실수령액</td>
    </tr>
    <c:forEach var="payStub" items="${listPayStub.list}">
        <tr>
            <form method="get" action="/mypage/detailPayStub.do">
                <td>${payStub.p_No}</td>
                <input type="hidden" name="p_No" value="${payStub.p_No}"/>
                <td>${payStub.e_No}</td>
                <td>${payStub.p_Date}</td>
                <td>${payStub.p_BasePay}</td>
                <td>${payStub.p_NetPay}</td>
                <td>
                    <button type="submit">자세히보기</button>
                </td>
            </form>
        </tr>
    </c:forEach>
</table>

<%--페이징 처리 부분--%>

<%--이전 영역--%>
<c:if test="${listPayStub.startPage >= 6}">
    <a href="listPayStub.do?pageNum=${listPayStub.startPage - 1}">[이전]</a>
</c:if>

<%--페이지 목록 출력--%>
<c:forEach var="pageNo" begin="${listPayStub.startPage}" end="${listPayStub.endPage}">
    <c:if test="${listPayStub.requestPage == pageNo}"><b></c:if>
    <a href="listPayStub.do?pageNum=${pageNo}">[${pageNo}]</a>
    <c:if test="${listPayStub.requestPage == pageNo}"></b></c:if>
</c:forEach>

<%--이후 영역--%>
<c:if test="${listPayStub.endPage < listPayStub.totalPageCount}">
    <a href="listPayStub.do?pageNum=${listPayStub.endPage + 1}">[이후]</a>
</c:if>

</body>
</html>
