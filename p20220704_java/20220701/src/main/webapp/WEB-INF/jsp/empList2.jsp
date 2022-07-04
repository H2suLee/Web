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

</head>
<body>
	<h1>사원 목록</h1>
	<a href="empInsert">사원 등록</a>

	<table border=1>
		<thead>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>급여</th>
			</tr>
		</thead>

		<tbody>
			<!-- for(EmpVO : list) -->
			<c:forEach var="vo" items="${list}">
				<tr>
					<th>${vo.getEmployeeId()}</th>
					<th>${vo.firstName}</th>
					<th>${vo.salary}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>