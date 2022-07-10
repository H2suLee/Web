<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSelect.jsp</title>
</head>
<body>
<h1> 회원 조회</h1>
<c:forEach items="${list}" var="list">
${list.memberId} :: ${list.memberName } :: ${list.memberAuth } 
<br>
</c:forEach>
<a href="main.do">홈</a>
</body>
</html>