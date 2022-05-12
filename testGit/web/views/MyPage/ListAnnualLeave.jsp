<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: JKM
  Date: 2022-05-04
  Time: 오전 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}Resource/CSS/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Resource/CSS/bootstrap_modify.css" type="text/css">
    <style>
        .add {
            margin-left: 2rem;
            margin-bottom: 1rem;
            text-decoration-line: none;
        }

        .btn {
            font-size: 10px;
            width: 50px;
            height: 25px;
            padding: 0px 0px 0px 0px;
        }
    </style>
    <script>
        function referAnnualLeave(frm) {
            frm.method = "post";
            frm.action = '${sessionScope.contextPath}/mypage/referAnnualLeave.do';
            frm.submit();
            return true;
        }

        function acknowledgeAnnualLeave(frm) {
            frm.method = "post";
            frm.action = '${sessionScope.contextPath}/mypage/acknowledgeAnnualLeave.do';
            frm.submit();
            return true;
        }

        function onProgressAnnualLeave(frm){
            frm.method = "post";
            frm.action = '${sessionScope.contextPath}/mypage/onProgressAnnualLeave.do';
            frm.submit();
            return true;
        }
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">StarWorks</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="mainAction.do">홈
                        <span class="visually-hidden">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/testGit/document/listAction.do">전자결제</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/testGit/schedule/moveSchedule.do">일정관리</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/testGit/Meetingroom/listNoticeAction.do">공지사항</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/testGit/community/listCommunityAction.do">커뮤니티</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/testGit/views/MyPage/Init.jsp">마이페이지</a>
                </li>
            </ul>
            <form class="d-flex">
                <a class="nav-link" href="logOutAction.do" id = "logout">로그아웃</a>
            </form>
        </div>
    </div>
</nav>

<ul class="nav nav-pills flex-column">
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/private-info">개인 정보</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/attendance">근태 기록</a>
    </li>
    <li class="nav-item">
        <a class="nav-link active" href="${sessionScope.contextPath}/mypage/annual-leave">연차 기록</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/paystub">급여 명세서</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/phonebook">주소록</a>
    </li>
</ul>

<ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="${sessionScope.contextPath}/mypage/annual-leave">연차 기록</a></li>
</ol>

<a class="badge rounded-pill bg-primary add" href="${sessionScope.contextPath}/mypage/insertAnnualLeave">추가</a>
<ul>
    <table class="table table-hover">
        <thead>
        <tr class="table-dark">
            <td>연차 번호</td>
            <td>사원 번호</td>
            <td>휴가 명</td>
            <td>연차 공제일</td>
            <td>시작 일</td>
            <td>종료 일</td>
            <td>승인 여부</td>
        </tr>
        </thead>
        <tbody>
        <c:set var="odd" value="true"/>
        <c:forEach var="annualLeave" items="${listAnnualLeave.list}">
            <c:choose>
                <c:when test="${odd eq true}">
                    <tr class="table-info">
                    <c:set var="odd" value="false"/>
                </c:when>
                <c:when test="${odd eq false}">
                    <tr class="table-secondary">
                    <c:set var="odd" value="true"/>
                </c:when>
            </c:choose>
            <form>
                <input type="hidden" name="an_no" value="${annualLeave.an_no}">
                <td name="an_no">${annualLeave.an_no}</td>

                <input type="hidden" name="e_no" value="${annualLeave.e_no}">
                <td name="e_no">${annualLeave.e_no}</td>

                <input type="hidden" name="an_distinct" value="${annualLeave.an_distinct}">
                <c:choose>
                    <c:when test="${annualLeave.an_distinct eq '1'}">
                        <td>외출</td>
                    </c:when>
                    <c:when test="${annualLeave.an_distinct eq '2'}">
                        <td>조퇴</td>
                    </c:when>
                    <c:when test="${annualLeave.an_distinct eq '3'}">
                        <td>연차</td>
                    </c:when>
                    <c:when test="${annualLeave.an_distinct eq '4'}">
                        <td>병가</td>
                    </c:when>
                    <c:when test="${annualLeave.an_distinct eq '5'}">
                        <td>오전반차</td>
                    </c:when>
                    <c:when test="${annualLeave.an_distinct eq '6'}">
                        <td>오후반차</td>
                    </c:when>
                    <c:when test="${annualLeave.an_distinct eq '7'}">
                        <td>무급휴가</td>
                    </c:when>
                    <c:when test="${annualLeave.an_distinct eq '8'}">
                        <td>교육</td>
                    </c:when>
                </c:choose>
                <input type="hidden" name="an_deduction" value="${annualLeave.an_deduction}">
                <td>${annualLeave.an_deduction}</td>

                <input type="hidden" name="an_startDate" value="${annualLeave.an_startDate}">
                <td>${annualLeave.an_startDate}</td>

                <input type="hidden" name="an_endDate" value="${annualLeave.an_endDate}">
                <td>${annualLeave.an_endDate}</td>

                <input type="hidden" name="an_acknowledge" value="${annualLeave.an_acknowledge}">
                <td>${annualLeave.an_acknowledge}</td>
                <c:if test="${sessionScope.d_no eq '1' && annualLeave.an_acknowledge == '처리중'}">
                    <td>
                        <input type="button" class="btn btn-outline-warning"
                               onclick="return acknowledgeAnnualLeave(this.form)"
                               value="승인"/>
                        <input type="button" class="btn btn-outline-danger" onclick="return referAnnualLeave(this.form)"
                               value="반려"/>
                    </td>
                </c:if>
                <c:if test="${sessionScope.d_no eq'1' && annualLeave.an_acknowledge != '처리중'}">
                    <td><input type="button" class="btn btn-outline-info"
                           style="font-size: 7px; padding:0px 0px 0px 0px"
                           onclick="return onProgressAnnualLeave(this.form)" value="처리중"/>
                    </td>
                </c:if>
            </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</ul>
<div>
    <ul class="pagination">
        <c:if test="${listAnnualLeave.startPage >= 6}">
            <li class="page-item disabled">
                <a class="page-link" href="annual-leave?pageNum=${listAnnualLeave.startPage - 1}">&laquo;</a>
            </li>
        </c:if>

        <c:forEach var="pageNo" begin="${listAnnualLeave.startPage}" end="${listAnnualLeave.endPage}">
            <c:choose>
                <c:when test="${listAnnualLeave.requestPage == pageNo}">
                    <li class="page-item active">
                        <a class="page-link" href="annual-leave?pageNum=${pageNo}">${pageNo}</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="annual-leave?pageNum=${pageNo}">${pageNo}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${listAnnualLeave.endPage < listAnnualLeave.totalPageCount}">
            <li class="page-item">
                <a class="page-link" href="annual-leave?pageNum=${listAnnualLeave.endPage + 1}">&raquo;</a>
            </li>
        </c:if>
    </ul>
</div>
</body>
</html>
