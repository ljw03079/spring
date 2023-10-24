<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 등록</title>
</head>
<body>
	<form action="empInsert" method="post">
		<div>
			<label>first_name : <input type="text" name="firstName"></label>
		</div>
		<div>
			<label>last_name : <input type="text" name="lastName"></label>
		</div>
		<div>
			<label>email : <input type="text" name="email"></label>
		</div>
		<div>
			<label>hire_date : <input type="date" name="hireDate" placeholder="yyyy-MM-dd"></label>
		</div>
		<div>
			<label>job_id : <input type="text" name="jobId"></label>
		</div>
		<div>
			<label>salary : <input type="number" name="salary"></label>
		</div>
		<div>
			<button type="submit">등록</button>
			<button type="button" onclick="location.href='empList'">목록</button>
		</div>
	</form>
</body>
</html>