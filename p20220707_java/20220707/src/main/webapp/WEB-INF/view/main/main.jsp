<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
</head>
<body>
	<div align="center"></div>
	<div>
		<h1>시작하는 곳</h1>
	</div>

	<!-- 로그인이 안되었으면 메인에서 memberLoginForm.do가 보이고, 
	로그인이 되었으면 meberLogout.do -->
	<c:if test="${empty id}">
		<div>
			<h3>
				<a href="memberJoinForm.do">회원가입</a>
			</h3>
			<h3>
				<a href="memberLoginForm.do">로그인</a>
			</h3>
		</div>
	</c:if>
	<!-- el 태그 안에 불려진 값들은 로그인 시 세션 객체에 내가 담아놓은 속성들임(id, name, auth) -->
	<c:if test="${not empty id}">
		<div>
			<h3>
				<a href="memberLogout.do">로그아웃</a>
			</h3>
		</div>
	</c:if>
	<c:if test="${auth eq 'admin'}">
		<div>
			<h3>
				<a href="memberList.do">회원 조회</a>
			</h3>
		</div>
	</c:if>


</body>
</html>