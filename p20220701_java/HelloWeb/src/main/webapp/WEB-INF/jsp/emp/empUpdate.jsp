<%@page import="co.edu.prj.dept.DeptVO"%>
<%@page import="co.edu.prj.emp.JobsVO"%>
<%@page import="co.edu.prj.emp.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp Update</title>

<style>
form label {
	display: inline-block;
	width: 200px;
	text-align: center;
	background-color: rgb(225, 221, 221);
}
</style>

<script>
	function validateForm() {
		if (window.document.empForm.no.value == "") {
			alert("사원번호 입력");
			empForm.no.focus();
			return false;
		}
		if (window.document.empForm.name.value == "") {
			alert("사원이름 입력");
			empForm.name.focus();
			return false;
		}
		if (window.document.empForm.email.value == "") {
			alert("이메일 입력");
			empForm.email.focus();
			return false;
		}
		// 이메일 정규식
		// https://epthffh.tistory.com/entry/%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8-%EC%A0%95%EA%B7%9C%EC%8B%9D
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if (regExp.test(empForm.email.value) == false) {
			alert("이메일 형식 오류")
			empForm.email.focus();
			return false
		}
		if (window.document.empForm.date.value == "") {
			alert("입사일 입력");
			empForm.date.focus();
			return false;
		}
		if (window.document.empForm.job.value == "") {
			alert("직무번호 입력");
			empForm.job.focus();
			return false;
		}
		return true;
	}
</script>

</head>
<body>

	<h1>사원 수정</h1>
	
	<%
	EmpVO emp = (EmpVO) request.getAttribute("emp");
	%>

	<!-- 주석에 el 태그 있으면 이딴 오류남: Encountered " "}" "} "" at line 1, column 3. -->
	
	<form action="empUpdate" name="empForm" method="post"
		onsubmit="return validateForm()">
		<label for="no">사원번호</label> 
		<input type="number" name="no" id="no"	value="${ emp.getEmployeeId() }" readonly><br> 
		<label	for="name">사원이름</label> 
		<input type="text" name="name" id="name" value="${ emp.getLastName() }"><br> 
		<label for="email">이메일</label>
		<input type="text" name="email" id="email" value="${ emp.getEmail() }"><br>
		<label for="date">입사일</label>
		<input type="date" name="date" id="date" value="${emp.getHireDate().substring(0,10)}"><br> 
		
		<label for="dept">소속부서</label>
		<c:forEach var="dept" items="${depts}">
			<input id="dept" type="radio" name="deptId" value="${dept.getDeptId()}"
				<c:if test="${dept.getDeptId() == emp.getDepartmentId()}"> checked </c:if>>${dept.getDeptName()}
		</c:forEach>
		<br>
		<label for="job">담당직무</label>
		<select name="jobId" id="job">
			<c:forEach var="job" items="${jobs}">
				<option value="${job.jobId}" 
				<c:if test="${job.jobId == emp.jobId}"> selected </c:if>>${job.jobTitle}</option>
			</c:forEach>
		</select> <br>
		
		<button>수정</button>
		<br>
		<button type="button" onclick="empDelFnc()">삭제</button>
	</form>
	<script>

	function empDelFnc(){
		location.href="EmpDeleteServ?no=<%=emp.getEmployeeId()%>"
		} 
 
	</script>
	<br>
</body>
</html>