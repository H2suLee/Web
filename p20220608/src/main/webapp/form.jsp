
<%@page import="co.edu.Employee"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.EmpDAO"%>
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
	String ln = request.getParameter("last_name"); // form > input : last_name
	String em = request.getParameter("email");
	String ji = request.getParameter("job_id");
	String hd = request.getParameter("hire_date");

	String[] hbs = request.getParameterValues("hobby"); // checkbox로 hobby에는 복수의 값이 담길 수 있다. 모든 값을 받을 경우 getParameterValues로 받아올 수 있고, 리턴타입은 스트링 배열

	/* <h3>에 담을 경우
	취미 : reading
	취미 : workout
	취미 : cooking
	취미 : eating*/

	Employee emp = new Employee();
	emp.setLastName(ln);
	emp.setEmail(em);
	emp.setJobId(ji);
	emp.setHireDate(hd);

	EmpDAO dao = new EmpDAO(); // import 하려면 커서를 놓고 컨트롤+스페이스
	dao.insertEmp(emp);
	%>

	<h3>
		사용자 입력 아이디:
		<%=ln%>
	</h3>
	<h3>
		사용자 입력 이메일:
		<%=em%>
	</h3>
	<h3>
		사용자 입력 직무:
		<%=ji%>
	</h3>
	<h3>
		사용자 입력 입사일:
		<%=hd%>
	</h3>

	<%
	List<String> list = dao.getNames(); // 리스트 타입의 first-name 컬렉션
	for (String str : list) {
		out.print("<h3>" + str + "</h3>"); // jsp의 sysout
	}
	%>

	<!-- run as 전송을 누르면 아래와 같이 주소 설정됨 -->
	<!-- http://localhost/formPrj0608/form.jsp?last_name=Added3&email=adflajk%40aaaaaa&job_id=IT_PROG&hire_date=2022-05-31&userpw=1234 -->

</body>
</html>