<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th><!-- yyyy년MM월dd일 -->
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList }" var="list">
				<tr onclick="location.href='boardInfo?bno=${list.bno }'">
					<td>${list.bno }</td>
					<td>${list.title }</td>
					<td>${list.writer }</td>
					<td>
						<fmt:formatDate value="${list.regdate }" pattern="yyyy년MM월dd일" />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		let msg = `${result }`;
		if(msg != '') alert(msg);
	</script>
</body>
</html>