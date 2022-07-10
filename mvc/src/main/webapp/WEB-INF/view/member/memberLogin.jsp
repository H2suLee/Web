<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberLogin.jsp</title>
</head>
<body>
	<div align="center">
		<h1>${message }</h1>
		<input type="button" value="홈" onclick="location.href='main.do'">
		<input type="button" value="로그아웃" onclick="location.href='memberLogout.do'">
	</div>
</body>
</html>