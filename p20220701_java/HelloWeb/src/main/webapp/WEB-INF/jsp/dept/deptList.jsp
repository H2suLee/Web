
<%@page import="co.edu.prj.dept.DeptVO"%>
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
<title>Dept List</title>

</head>
<body>
	<h1>부서 목록</h1>
	<a href="DeptInsert">부서 등록</a>

	<table border=1>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서이름</th>
			</tr>
		</thead>

		<tbody>
			<!-- for(DeptVO : list) -->
			<c:forEach var="vo" items="${list}">
				<tr>
					<th>${vo.deptId}</th>
					<th><a href="DeptUpdate?departmentId=${vo.deptId}">${vo.deptName}</a></th>
				</tr>
			</c:forEach>

			<!-- 스크립틀릿 표기법으로 -->
			<!--
			<% ArrayList<DeptVO> list = (ArrayList<DeptVO>) request.getAttribute("list"); 
			for(DeptVO vo : list){%>
			
			<tr>
			<td><%=vo.getDeptId() %>></td>
			<td><%=vo.getDeptName() %></td>
			</tr>
			<%} %>
			 -->
		</tbody>
	</table>
</body>
</html>