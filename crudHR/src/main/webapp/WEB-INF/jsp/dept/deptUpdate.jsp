<%@page import="co.home.hr.dept.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dept Update</title>
<script>
	function validationForm() {
		if (updateForm.departmentName.value == "") {
			alert("수정할 부서명을 입력하세요.");
			return;
		}
		updateForm.submit(); // 폼 전송(submit 버튼 클릭과 같음)
	}
	function delFnc(){
		location.href='DeptDeleteServ?departmentId=${dept.departmentId}';
	}
</script>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<h1>수정</h1>
<a href="DeptSelectServ">부서 조회</a>
<form action="DeptUpdateServ" name="updateForm" method="post">
<% 
DeptVO vo = (DeptVO) request.getAttribute("dept"); 

%>
<label for="departmentId">부서 번호</label> <input type="text" name="departmentId" id="departmentId" value="<%=vo.getDepartmentId()%>">
<label for="departmentName">부서 이름</label> <input type="text" name="departmentName" id="departmentName" value="<%=vo.getDepartmentName()%>"><br>
<button type="button" onclick="validationForm()">수정</button> <button type="button" onclick="delFnc()">삭제</button>
</form>
</body>
</html>