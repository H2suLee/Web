<%@page import="co.home.hr.emp.JobVO"%>
<%@page import="co.home.hr.dept.DeptVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>emp Insert</title>

<style>
form>label {
	display: inline-block;
	width: 15%;
	background-color: rgb(225, 221, 221);
	text-align: center;
}
</style>

<script>
	function validationForm() {
		if (insertForm.employeeId.value == "") {
			alert("사원번호 입력");
			insertForm.employeeId.focus();
			return;
		}

		if (insertForm.lastName.value == "") {
			alert("사원이름 입력");
			insertForm.lastName.focus();
			return;
		}

		if (insertForm.email.value == "") {
			alert("이메일 입력");
			insertForm.email.focus();
			return;
		}

		// 이메일 정규식
		// https://epthffh.tistory.com/entry/%EB%B9%84%EB%B0%80%EB%B2%88%ED%98%B8-%EC%A0%95%EA%B7%9C%EC%8B%9D
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if (regExp.test(insertForm.email.value) == false) {
			alert("이메일 형식 오류")
			insertForm.email.focus();
			return false
		}

		if (insertForm.hireDate.value == "") {
			alert("입사일 입력");
			insertForm.hireDate.focus();
			return;
		}

		if (insertForm.jobId.value == "") {
			alert("담당직무 입력");
			insertForm.jobId.focus();
			return;
		}
		insertForm.submit(); // 폼 전송(submit 버튼 클릭과 같음)
	}
</script>

</head>

<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />

	<h1>등록</h1>
	<form action="EmpInsertServ" name="insertForm" method="post">
		<label for="employeeId">사원 번호</label> <input type="text"
			name="employeeId" id="employeeId"><br> <label
			for="lastName">사원 이름</label> <input type="text" name="lastName"
			id="lastName"><br> <label for="email">이메일</label> <input
			type="text" name="email" id="email"><br> <label
			for="hireDate">입사일</label> <input type="date" name="hireDate"
			id="hireDate"><br> <label for="jobId">담당 직무</label> <select
			id="departmentId" name="jobId">
			<%
			List<JobVO> list1 = (List<JobVO>) request.getAttribute("jobList");
			for (JobVO vo : list1) {
			%>
			<option value="<%=vo.getJobId()%>"><%=vo.getJobTitle()%></option>
			<%
			}
			%>
		</select> <br> <label for="departmentId">소속 부서</label>
		<%
		List<DeptVO> list2 = (List<DeptVO>) request.getAttribute("deptList");
		for (DeptVO vo : list2) {
		%>
		<input type="radio" name="departmentId" id="departmentId"
			value="<%=vo.getDepartmentId()%>"><%=vo.getDepartmentName()%>
		<%
		}
		%>
		<br>
		<button type="button" onclick="validationForm()">등록</button>
	</form>
</body>

</html>