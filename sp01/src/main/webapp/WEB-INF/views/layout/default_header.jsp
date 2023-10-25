<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.header {
		background-color: #aaa;
	}
	.header a {
		color: #fff;
	}
</style>
<!-- header는 절대경로 : / => port 다음 -->
<!-- http://localhost/app/ => / : localhost 다음 / -->
<ul class="nav header">
  <!-- 절대경로 -->
  <li class="nav-item">
  	<!-- request가 접근한 페이지에서 contextPath만 가져옴 => app -->
    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }/">Home</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath }/empList">전체사원조회</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath }/empInsert">사원정보등록</a>
  </li>
  <!-- 상대경로, 현재페이지 기준으로 불러옴. app 내의 경로이므로 정상적으로 페이지 불러옴
  <li class="nav-item">
    <a class="nav-link" href="empInsert">사원정보등록</a>
  </li> -->
  <li class="nav-item">
    <a class="nav-link disabled" aria-disabled="true">Disabled</a>
  </li>
</ul>