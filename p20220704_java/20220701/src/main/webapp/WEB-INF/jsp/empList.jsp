<%@page import="co.edu.prj.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Prac</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>급여</th>
			</tr>
		</thead>

		<tbody>

			<%
			List<EmpVO> list = new ArrayList<>();
			list.add(new EmpVO("100", "Ann", "43000"));
			list.add(new EmpVO("101", "Lesley", "20000"));
			list.add(new EmpVO("102", "Chris", "35000"));

			for (EmpVO vo : list) {
			%>
			<tr>
				<td><%=vo.getEmployeeId()%></td>
				<td><%=vo.getFirstName()%></td>
				<td><%=vo.getSalary()%></td>
			</tr>
			<%
			}
			%>
		</tbody>

	</table>
</body>
</html>