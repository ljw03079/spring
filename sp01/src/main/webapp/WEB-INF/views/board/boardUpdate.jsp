<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 수정</title>
</head>
<body>
	<form name="updateForm">
		<table>
			<tr>
				<th>번호</th>
				<td>
					<input type="text" name="bno" value="${boardInfo.bno }" readonly>
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title" value="${boardInfo.title }">
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="writer" value="${boardInfo.writer }">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="contents">${boardInfo.contents }</textarea>
				</td>
			</tr>
			<tr>
				<th>첨부이미지</th>
				<td>
					<input type="text" name="image" value="${boardInfo.image }">
				</td>
			</tr>
		</table>
		<button type="button">저장</button>
		<button type="button" onclick="location.href='boardInfo?bno=${boardInfo.bno }'">취소</button>
	</form>
	<script>
		document.querySelector('form > button:nth-of-type(1)')
						.addEventListener('click', boardUpdateAjax);
		function boardUpdateAjax(e){
			
			let info = getBoardInfo();

			// header 가 통과돼야 데이터 전송가능. content-type : 통신규약
			fetch('boardUpdate', {
				method: 'post',
				headers: {
					'content-type' : 'application/json'
				},
				body : JSON.stringify(info)
			})
			.then(response => response.json())
			.then(result => {
				console.log(result);
			})
			.catch(err => console.log(err));

			function getBoardInfo(){
				let formTag = document.getElementsByName('updateForm')[0];

				let formData = new FormData(formTag);
				// form 태그 안의 입력만 관련된 태그만 남음. formData는 클래스. 내부에 값만 존재하는게 아니라 생성자 메서드도 존재

				// formData.forEach : formData 안에 통신을 하기 위한 정보를 하나씩 끄집어냄.
				let objData = {};
				formData.forEach((value, key) => {
					objData[key] = value;
				})

				return objData;
			};
		}
	</script>
</body>
</html>