<%@page import="co.home.hr.emp.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp Select</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<h1>조회</h1>
<a href="EmpInsertServ">사원 등록</a>
	<table border="1" width="600px">
		<thead>
			<tr>
				<th>사원 번호</th>
				<th>사원 이름</th>
				<th>이메일</th>
				<th>입사일</th>
				<th>담당 직무</th>
				<th>소속 부서</th>
			</tr>

		</thead>
		<tbody>
				<%
				List<EmpVO> list = (List<EmpVO>) request.getAttribute("list");
				for (EmpVO vo : list) {
				%>
			<tr>
				<td>
				<a href="EmpUpdateServ?employeeId=<%=vo.getEmployeeId()%>"><%=vo.getEmployeeId()%></a>
				</td>
				<td><%=vo.getLastName()%></td>
				<td><%=vo.getEmail()%></td>
				<td><%=vo.getHireDate().substring(0,10)%></td>
				<td><%=vo.getJobId()%></td>
				<td><%=vo.getDepartmentId()%></td>
			</tr>
				<%
				}
				%>
		</tbody>
	</table>
</body>
</html>