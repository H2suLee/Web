<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>한글</h1>
		<a href="sum.do">서블릿 호출</a>
		
		<!-- 자바 선언 -->
		<%!
		int sum(int a, int b){
			return a+b;
		}
		%>
		
		<!-- 코드 -->
		<%
		int m = 10;
		int n = 2;
		sum(m,n);
		%>
		
		<!-- 출력 -->
		합계 값: <%= sum(m,n) %>
		
	</div>
</body>
</html>