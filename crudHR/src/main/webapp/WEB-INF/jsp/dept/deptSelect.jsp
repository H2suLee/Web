<%@page import="co.home.hr.dept.DeptVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dept Select</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />

	<h1>조회</h1>
	<a href="DeptInsertServ">부서 등록</a>
	<table border="1" width="400px">
		<thead>
			<tr>
				<th>부서 번호</th>
				<th>부서 이름</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td><a href="DeptUpdateServ?departmentId=${vo.departmentId}">${vo.departmentId}</a>
					</td>
					<td>${vo.departmentName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>