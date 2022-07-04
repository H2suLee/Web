<%@page import="co.edu.prj.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ★ jstl ★ -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Prac using JSTL</title>

<style>
form label {
	display: inline-block;
	width: 20%;
	text-align: center;
	background-color: rgb(225, 221, 221);
}
</style>

</head>
<body>
	<h1>사원 등록</h1>

	<div id="box">
		<form action="" name="empForm">
			<label for="no">사원번호</label> <input type="number" name="no" id="no"><br>
			<label for="name">사원이름</label> <input type="text" name="name"
				id="name"><br> <label for="email">이메일</label> <input
				type="text" name="email" id="email"><br> <label
				for="date">입사일</label> <input type="date" name="date" id="date"><br>
			<label for="job">직무번호</label> <input type="text" name="job" id="job">
			<input type="submit" value="저장"> <input type="button"
				value="선택삭제" id="chkDel">
		</form>
		<br>
		<div id="show">
</body>
</html>