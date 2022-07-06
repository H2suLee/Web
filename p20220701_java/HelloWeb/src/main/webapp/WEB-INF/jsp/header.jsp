<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header(include 사용)</title>
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
	<a <%if(request.getRequestURI().endsWith("empInsert.jsp")){%>class="active<%}%> href="empInsert">사원 등록</a>
	<a <%if(request.getRequestURI().endsWith("empList2.jsp")){%>class="active<%}%> href="EmpListServ2">사원 목록</a>
	<a <%if(request.getRequestURI().endsWith("deptInsert.jsp")){%>class="active<%}%> href="DeptInsert">부서 등록</a>
	<a <%if(request.getRequestURI().endsWith("deptList.jsp")){%>class="active<%}%> href="DeptListServ">부서 목록</a>
</div>
	<!-- servlet에서 /는 http://localhost/contextPath/-->
	<!-- html에서 /는 http://localhost/ -->
	<!-- html에서 /를 쓰고싶으면 /HelloWeb/empList 일케 써줘야 함 -->
	<!-- 위와 같이 절대경로로 하면 유지보수가 불편, 그래서 href="<%=request.getContextPath()%>/empList" 일케 쓰는 거도 됨 -->
</body>
</html>