<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
	background-color: #666;
	padding: 30px;
	text-align: center;
	font-size: 35px;
	color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
	float: left;
	width: 30%;
	height: 300px; /* only for demonstration, should be removed */
	background: #ccc;
	padding: 20px;
}

/* Style the list inside the menu */
nav ul {
	list-style-type: none;
	padding: 0;
}

article {
	float: left;
	padding: 20px;
	width: 70%;
	background-color: #f1f1f1;
	height: 300px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section::after {
	content: "";
	display: table;
	clear: both;
}

/* Style the footer */
footer {
	background-color: #777;
	padding: 10px;
	text-align: center;
	color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media ( max-width : 600px) {
	nav, article {
		width: 100%;
		height: auto;
	}
}
</style>
</head>
<body>
	<nav>
		<ul>
			<c:if test="${empty id}">
				<li><a href="memberJoinForm.do">회원가입</a></li>
				<li><a href="memberLoginForm.do">로그인</a></li>
				<li><a href="noticeList.do">글보기</a></li>
			</c:if>
			<c:if test="${not empty id}">
				<li><a href="memberLogout.do">로그아웃</a></li>
			</c:if>
			<c:if test="${auth eq 'admin'}">
				<li><a href="memberList.do">회원 조회</a></li>
			</c:if>
		</ul>
	</nav>
		<!-- 로그인이 안되었으면 메인에서 memberLoginForm.do가 보이고, 
	로그인이 되었으면 meberLogout.do -->

</body>
</html>