<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello, World @.@
<!-- 모든 요청을 하나의 Controller가 받고, Command 객체들이 DAO와 상호작용하며 요청을 처리, 처리 결과를 Controller에게 전달  -->
<!-- Controller는 View를 거쳐 웹브라우저(클라이언트)에게 응답   -->
	<jsp:forward page="main.do"/> <!-- ?? -->
</body>
</html> 