<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

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
        <a class="nav-link active" href="${sessionScope.contextPath}/mypage/private-info">개인 정보</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/attendance">근태 기록</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/annual-leave">연차 기록</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/paystub">급여 명세서</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="${sessionScope.contextPath}/mypage/phonebook">주소록</a>
    </li>
</ul>
<ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="">개인 정보</a></li>
</ol>


<form class="form-parent"
method="post" action="${sessionScope.contextPath}/mypage/updatePrivateInfo.do">
    <fieldset>
        <legend>개인 정보</legend>
        <div class="form-group row">
            <label for="staticE_No" class="col-sm-2 col-form-label">사원번호</label>
            <div class="col-sm-10">
                <input type="text" readonly="" class="form-control-plaintext" id="staticE_No"
                       name="e_No" value="${privateInfo.e_No}">
            </div>
        </div>
        <div class="form-group row">
            <label for="staticD_No" class="col-sm-2 col-form-label">부서번호</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="staticD_No"
                       name="d_No" value="${privateInfo.d_No}">
            </div>
        </div>
        <div class="form-group row">
            <label for="staticGrade" class="col-sm-2 col-form-label">직급</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="staticGrade"
                       name="grade" value="${privateInfo.grade}">
            </div>
        </div>
        <div class="form-group row">
            <label for="staticName" class="col-sm-2 col-form-label">이름</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="staticName"
                       name="name" value="${privateInfo.name}">
            </div>
        </div>
        <div class="form-group row">
            <label for="staticHireDate" class="col-sm-2 col-form-label">입사일</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="staticHireDate"
                       name="hireDate" value="${privateInfo.hireDate}">
            </div>
        </div>
        <div class="form-group row">
            <label for="staticId" class="col-sm-2 col-form-label">아이디</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="staticId"
                       name="id" value="${privateInfo.id}">
            </div>
        </div>
        <div class="form-group row">
            <label for="staticPhoneNumber" class="col-sm-2 col-form-label">전화번호</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="staticPhoneNumber"
                       name="phoneNumber" value="${privateInfo.phoneNumber}">
            </div>
        </div>
        <div class="d-grid gap-2">
            <button class="btn btn-lg btn-primary" type="submit">수정</button>
        </div>
    </fieldset>
</form>
</body>
</html>

