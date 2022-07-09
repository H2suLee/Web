<%@page import="co.home.hr.dept.DeptVO"%>
<%@page import="co.home.hr.emp.JobVO"%>
<%@page import="java.util.List"%>
<%@page import="co.home.hr.emp.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<%
		EmpVO vo = (EmpVO) request.getAttribute("emp");
		%>
		<label for="employeeId">사원 번호</label> <input type="text"
			name="employeeId" id="employeeId" value="<%=vo.getEmployeeId()%>"><br>
		<label for="lastName">사원 이름</label> <input type="text" name="lastName"
			id="lastName" value="<%=vo.getLastName()%>"><br> <label
			for="email">이메일</label> <input type="text" name="email" id="email"
			value="<%=vo.getEmail()%>"><br> <label for="hireDate">입사일</label>
		<input type="date" name="hireDate" id="hireDate"
			value="<%=vo.getHireDate().substring(0, 10)%>"><br> <label
			for="jobId">담당 직무</label> <select id="departmentId" name="jobId">
			<%
			List<JobVO> list2 = (List<JobVO>) request.getAttribute("jobList");
			for (JobVO vo2 : list2) {
			%>
			<option value="<%=vo2.getJobId()%>"
				<%if (vo.getJobId() != null && vo.getJobId().equals(vo2.getJobId())) {%>
				selected <%}%>>
				<%=vo2.getJobTitle()%></option>
			<%
			}
			%>
		</select> <br> <label for="departmentId">소속 부서</label>
		<%
		List<DeptVO> list3 = (List<DeptVO>) request.getAttribute("deptList");
		for (DeptVO vo3 : list3) {
			if (vo.getDepartmentId() != null && vo.getDepartmentId().equals(vo3.getDepartmentId())) {
		%>
		<input type="radio" name="departmentId" id="departmentId"
			value="<%=vo3.getDepartmentId()%>" checked><%=vo3.getDepartmentName()%>
		<%
		} else {
		%>
		<input type="radio" name="departmentId" id="departmentId"
			value="<%=vo3.getDepartmentId()%>"><%=vo3.getDepartmentName()%>
		<%
		}
		}
		%>
		<br>
		<button type="button" onclick="validationForm()">수정</button>
		<button type="button" onclick="delFnc()">삭제</button>

	</form>
</body>

</html>