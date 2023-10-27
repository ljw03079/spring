<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<!-- form은 json처리 못함 객체로 데이터 보냄 -->
	<form name="insertForm" action="boardInsert" method="post">
		<table>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title">
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="writer">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="contents"></textarea>
				</td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td>
					<input type="text" name="image">
				</td>
			</tr>
		</table>
		<button type="submit">등록</button>
	</form>
	<script>
		// form내의 이벤트 중 submit이 있음.
		document.querySelector('form[name="insertForm"]')
						.addEventListener('submit', boardInsertHandler);
		// boardInsertHandler() => 함수 실행, boardInsertHandler => 함수만 등록 이벤트 실행X
		// handler를 등록할 경우 ()를 붙이면 안됨

		function boardInsertHandler(e){
			// submit이 동작을 하면 일시적으로 동작을 막음.
			e.preventDefault();
			let title = document.getElementsByName('title')[0];
			let writer = document.getElementsByName('writer')[0];

			if(title.value == ''){
				alert('제목이 입력되지 않았습니다. 확인해주시기 바랍니다.');
				title.focus();
				// submit이 일어나면 안되니 멈춰달라는 코드
				return;
			}
			if(writer.value == ''){
				alert('작성자가 입력되지 않았습니다. 확인해주시기 바랍니다.');
				writer.focus();
				return;
			}

			// form은 name 속성으로 바로 접근가능.
			insertForm.submit();
		}
	</script>
</body>
</html>