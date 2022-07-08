<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립틑릿 태그 연습</title>
</head>
<body>
	<!-- html 주석 -->
	<%-- 자바 주석, 웹브라우저 개발자모드에서 안 보임--%>
	<ul>
		<%
		for (int i = 1; i <= 10; i++) {
			out.print("<li>" + i + "</li>"); /* out.print(): 브라우저로 출력 */
		}
		%>
	</ul>

	<ul>
		<%
		for (int i = 11; i <= 20; i++) {
		%>
		<li><%=i%></li>
		<%
		}
		%>
	</ul>

	<table border="1">
		<%
		for (int k = 2; k <= 9; k++) {
			for (int i = 1; i <= 9; i++) {
		%>
		<tr>
			<td><%=k%></td>
			<td>*</td>
			<td><%=i%></td>
			<td>=</a>
			<td><%=k * i%></td>
		</tr>
		<%
		}
		}
		%>
	</table>

	<table border="1">
		<%
		for (int k = 2; k <= 9; k++) {
		%>
		<tr>
			<%
			for (int i = 1; i <= 9; i++) {
			%>
			<td><%=k * i%></td>
			<%
			}
			%>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>