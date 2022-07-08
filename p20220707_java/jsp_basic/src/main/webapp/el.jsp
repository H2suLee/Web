<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 사용법</title>
</head>
<body>
	<ul>
		<li>파라미터 : ${param.name}</li> 
		<!--스클립틀릿 ' =request.getParameter("name") ' 랑 같은 의미 -->
		<li>속성 : ${id}</li>
		<!--request.setAttribute("id")-->
		<li>배열 : ${arr[1] }</li>
		<li>메소드 : ${pageContext.request.getMethod()}</li>
		<li>메소드 : ${pageContext.request.method}</li>
		<!--request.setAttribute("id")-->
		
	</ul>

</body>
</html>