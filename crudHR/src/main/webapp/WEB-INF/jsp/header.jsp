<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #04AA6D;
	color: white;
}
</style>
</head>
<body>
	<div class="topnav">
		<!-- Context Path를 가져오도록 하는 메소드 -->
		<a <%if (request.getRequestURI().endsWith("empInsert.jsp")) {%>
			class="active" <%}%>
			href="<%=request.getContextPath()%>/EmpInsertServ">사원등록</a> <a
			<%if (request.getRequestURI().endsWith("empSelect.jsp")) {%>
			class="active" <%}%> href="<%=request.getContextPath()%>/EmpSelectServ">사원목록</a>
		<a <%if (request.getRequestURI().endsWith("deptInsert.jsp")) {%>
			class="active" <%}%>
			href="<%=request.getContextPath()%>/DeptInsertServ">부서등록</a> <a
			<%if (request.getRequestURI().endsWith("deptSelect.jsp")) {%>
			class="active" <%}%> href="<%=request.getContextPath()%>/DeptSelectServ">부서목록</a>
	</div>
</body>
</html>