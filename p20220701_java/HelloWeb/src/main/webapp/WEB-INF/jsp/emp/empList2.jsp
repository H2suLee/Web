<%@page import="co.edu.prj.emp.EmpVO"%>
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
<title>Emp List</title>

</head>
<body>
	<h1>사원 목록</h1>
	<a href="empInsert">사원 등록</a>
	
	<form>
		부서번호 <input name="departmentId">
		<button>검색</button>
	</form>

	<table border=1>
		<thead>
			<tr>
				<th>사원번호</th>
				<th>사원이름</th>
				<th>이메일</th>
				<th>입사일</th>
				<th>직무번호</th>
			</tr>
		</thead>

		<tbody>
			<!-- for(EmpVO : list) -->
			<c:forEach var="vo" items="${list}">
				<tr>
					<th>
					<a href="empUpdate?no="${vo.employeeId}">${vo.employeeId}</a>
					</th>
					<th>${vo.lastName}</th>
					<th>${vo.email}</th>
					<th>${vo.hireDate}</th>
					<th>${vo.jobId}</th>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>