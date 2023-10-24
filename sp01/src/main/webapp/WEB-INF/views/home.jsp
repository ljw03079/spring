<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div>
	<form action="reqParamTest" method="get">
		<input type="text" name="employeeId">
		<!-- <input type="text" name="lastName"> -->
		<input type="text" name="jobId">
		<button type="submit">get 전송</button>
	</form>
	
	<form action="reqParamTest" method="post">
		<input type="text" name="employeeId">
		<!-- <input type="text" name="lastName">  -->
		<input type="text" name="jobId">
		<button type="submit">post 전송</button>
	</form>
</div>
</body>
</html>
