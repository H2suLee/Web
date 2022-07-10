<%@page import="co.home.hr.dept.DeptVO"%>
<%@page import="co.home.hr.emp.JobVO"%>
<%@page import="java.util.List"%>
<%@page import="co.home.hr.emp.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>emp Update</title>

<style>
form[name="insertForm"] label {
	width: 400px;
	text-align: center;
	background-color: rgb(225, 221, 221);
}
</style>

<script>
	function validationForm() {

		if (updateForm.lastName.value == "") {
			alert("사원이름 입력");
			updateForm.lastName.focus();
			return;
		}

		if (updateForm.email.value == "") {
			alert("이메일 입력");
			updateForm.email.focus();
			return;
		}

		// 이메일 정규식
		// https://epthffh.tistory.com/entry/%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8-%EC%A0%95%EA%B7%9C%EC%8B%9D
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if (regExp.test(updateForm.email.value) == false) {
			alert("이메일 형식 오류")
			updateForm.email.focus();
			return false
		}

		if (updateForm.hireDate.value == "") {
			alert("입사일 입력");
			updateForm.hireDate.focus();
			return;
		}

		if (updateForm.jobId.value == "") {
			alert("담당직무 입력");
			updateForm.jobId.focus();
			return;
		}
		updateForm.submit(); // 폼 전송(submit 버튼 클릭과 같음)
	}

	function delFnc() {
		location.href = 'EmpDeleteServ?employeeId=${emp.employeeId}';
	}
</script>
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />

	<h1>수정</h1>
	<form action="EmpUpdateServ" name="updateForm" method="post">
		<label for="employeeId">사원 번호</label> <input type="text"
			name="employeeId" id="employeeId" value="${emp.employeeId}"><br>
		<label for="lastName">사원 이름</label> <input type="text" name="lastName"
			id="lastName" value="${emp.lastName}"><br> <label
			for="email">이메일</label> <input type="text" name="email" id="email"
			value="${emp.email}"><br> <label for="hireDate">입사일</label>
		<input type="date" name="hireDate" id="hireDate"
			value="${emp.hireDate.substring(0,10)}"><br> <label
			for="jobId">담당 직무</label> <select id="departmentId" name="jobId">

			<c:forEach items="${jobList}" var="job">
				<option value="${job.jobId}"
					<c:if test="${job.jobId == emp.jobId}"> selected </c:if>>
					${job.jobTitle}
			</c:forEach>

		</select> <br> <label for="departmentId">소속 부서</label>
		<c:forEach items="${deptList}" var="dept">
			<input type="radio" name="departmentId" id="departmentId"
				value="${dept.departmentId}">
				${dept.departmentName}
		</c:forEach>
		<br>
		<button type="button" onclick="validationForm()">수정</button>
		<button type="button" onclick="delFnc()">삭제</button>

	</form>
	<script>
	/* document.getElementsByName("jobId")[0].value = ${emp.jobId}; */
	document.querySelector("[name=departmentId][value='${emp.departmentId}']").checked=true;
	</script>
</body>

</html>