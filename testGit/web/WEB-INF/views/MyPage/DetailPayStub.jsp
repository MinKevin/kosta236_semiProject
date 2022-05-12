<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: JKM
  Date: 2022-05-03
  Time: 오후 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
DetailPayStub.jsp
<c:formatNumber type="number" maxFractionDigits="0"/>
<button type="button" onclick="location.href='listPayStub.do'">뒤로가기</button>
<table border="1">
    <tr>
        <td>직원 번호</td>
        <td>이 름</td>
        <td>직 급</td>
    </tr>
    <tr>
        <td>${privateInfo.e_No}</td>
        <td>${privateInfo.name}</td>
        <td>${privateInfo.grade}</td>
    </tr>
    <tr></tr>
    <tr>
        <td>번 호</td>
        <td>지급일</td>
        <td>기본급</td>
        <td>식 대</td>
        <td>소득세</td>
        <td>지방세</td>
        <td>국민연금</td>
        <td>고용보험</td>
        <td>건강보험</td>
    </tr>
    <tr>
        <td>${detailPayStub.p_No}</td>
        <td>${detailPayStub.p_Date}</td>
        <td>${detailPayStub.p_BasePay}</td>
        <td>${detailPayStub.mealAllowance}</td>
        <td>${detailPayStub.incomeTax}</td>
        <td>${detailPayStub.inhabitantsTax}</td>
        <td>${detailPayStub.nationalPension}</td>
        <td>${detailPayStub.employmentInsurance}</td>
        <td>${detailPayStub.healthInsurance}</td>
    </tr>
    <tr></tr>
    <tr>
        <td>실수령액</td>
    </tr>
    <tr>
        <td>${detailPayStub.p_NetPay}</td>
    </tr>
</table>

</body>
</html>
