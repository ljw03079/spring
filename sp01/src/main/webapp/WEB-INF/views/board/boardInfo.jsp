<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 정보</title>
<style>
img{
	width: 500px;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<td>${boardInfo.bno }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardInfo.title }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${boardInfo.writer }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="3" cols="2" style="width:100px;" readonly>${boardInfo.contents }</textarea>
			</td>
		</tr>
		<tr>
			<th>첨부파일</th>
			<!-- c태그 조건문 연산자 : eq(equal), ne(not equal), empty(list, class타입에서 사용 size가 0인지 체크), not(조건문의 반대), +등 다른연산도 가능 -->
			<c:choose>
				<c:when test="${not empty boardInfo.image }">
					<td><img src="<c:url value="/resources/${boardInfo.image }"/>"></td>
				</c:when>
				<c:otherwise>
					<td>파일없음</td>
				</c:otherwise>
			</c:choose>
			<!-- 경로사용할때 절대/상대 경로 뭐쓸지 판단해야함. -->
			<!-- ${pageContext.request.contextPath } 사용 or c태그의 url 사용 -->
			<!-- c:url => 절대,상대 자동으로 경로 만들어줌. -->
			<!-- menu나 image는 절대경로를 사용한다. -->
		</tr>
		<tr>
			<th>작성일자</th>
			<td>
				<fmt:formatDate value="${boardInfo.regdate }" pattern="yyyy/MM/dd" />
			</td>
		</tr>
	</table>
	<button type="button" onclick="location.href='boardUpdate?bno=${boardInfo.bno }'">수정</button>
	<button type="button" onclick="location.href='boardDelete?bno=${boardInfo.bno }'">삭제</button>
	<!-- NullPointException : 값을 불러오는 코드를 실행하는데 값이 없어서 나타나는 오류 -->
	<!-- ArrayIndexBoundException -->
</body>
</html>