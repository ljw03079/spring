<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- form이 아닌 Ajax 사용할 때 -->
<sec:csrfMetaTags />
</head>
<body>
	<h1>톱 페이지입니다.</h1>
	<ul>
		<li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
		</sec:authorize>
	</ul>
	<sec:authorize access="isAuthenticated() ">
		<sec:authentication property="principal.username"/>
		<form action="logout" method="post">
			<!-- form이 넘어갈때 토큰값이 같이 넘어가기때문에 동작을 함. -->
			<sec:csrfInput />
			<button>로그아웃</button>
		</form>
	</sec:authorize>
</body>
</html>