<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보 조회</title>
</head>
<body>
	<form>
		<div>
			<label>department_id : <input type="text" name="departmentId" value="${deptInfo.departmentId }" readonly></label>
		</div>
		<div>
			<label>department_name : <input type="text" name="departmentName" value="${deptInfo.departmentName }" readonly></label>
		</div>
		<div>
			<label>manager_id : <input type="text" name="managerId" value="${deptInfo.managerId }" readonly></label>
		</div>
		<div>
			<label>location_id : <input type="text" name="locationId" value="${deptInfo.locationId }" readonly></label>
		</div>
		<div>
			<button type="button" onclick="location.href='deptList'">목록</button>
		</div>
	</form>
</body>
</html>