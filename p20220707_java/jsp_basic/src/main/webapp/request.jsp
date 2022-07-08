<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request</title>
</head>
<body>
	<ul>
		<li>Method : <%=request.getMethod()%></li>
		<li>URL : <%=request.getRequestURL()%></li>
		<li>Protocol : <%=request.getProtocol()%></li>
		<li>Query str : <%=request.getQueryString()%></li>
		<li>IP Addr : <%=request.getRemoteAddr()%></li>
	</ul>

</body>
</html>