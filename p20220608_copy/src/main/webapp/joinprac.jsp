
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 페이지를 실행하기 위한 라이브러리(ex 톰캣)가 없어서 첨에 열면 에러남 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String gender = request.getParameter("gender");
	String[] lang = request.getParameterValues("lang");
	String intro = request.getParameter("intro");
	String nation = request.getParameter("nation");
	String food = request.getParameter("food");

	out.print("<h3> 이름 : </h3>" + name);
	out.print("<h3> 아이디 : </h3>" + id);
	out.print("<h3> 비밀번호 : </h3>" + password);
	out.print("<h3> 성별 : </h3>" + gender);
	out.print("<h3> 사용언어 : </h3>");
	for (String lan : lang) {
		out.print("<li>" + lan + "</li>");
	}
	out.print("<h3> 자기소개 : </h3>" + intro);
	out.print("<h3> 국적 : </h3>" + nation);
	out.print("<h3> 좋아하는 음식 : </h3>" + food);
	%>


</body>
</html>
<!-- http://localhost/formPrj0608/joinprac.jsp?
name=%EC%9D%B4%ED%9D%AC%EC%88%98&id=lee&
password=12345&tel1=010&tel2=7181&tel3=9541&
gender=%EC%97%AC%EC%9E%90&lang=eng&lang=jp&intro=adlfkj&
nation=USA&food=fadf -->