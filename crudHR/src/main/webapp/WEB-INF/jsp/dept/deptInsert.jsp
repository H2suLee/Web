<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dept Insert</title>
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
		if (insertForm.departmentId.value == "") {
			alert("부서번호 입력");
			return;
		}
		insertForm.submit(); // 폼 전송(submit 버튼 클릭과 같음)
	}
</script>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>

<h1>등록</h1>
<form action="DeptInsertServ" name="insertForm" method="post">
<label for="departmentId">부서 번호</label> <input type="text" name="departmentId" id="departmentId">
<label for="departmentName">부서 이름</label> <input type="text" name="departmentName" id="departmentName"><br>
<button type="button" onclick="validationForm()">등록</button>
</form>
</body>
</html>