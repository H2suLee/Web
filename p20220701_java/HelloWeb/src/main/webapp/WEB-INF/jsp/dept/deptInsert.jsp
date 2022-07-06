<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dept Insert</title>

<script>
	function validationForm() {
		if (deptForm.departmentId.value == "") {
			alert("부서번호 입력");
			return;
		}
		deptForm.submit(); // 폼 전송(submit 버튼 클릭과 같음)
	}
</script>

</head>
<body>
	<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>

	<h1>부서 등록</h1>

	<form action="DeptInsert" name="deptForm" method="post">
		<!-- input태그에서 name은 필수 -->
		부서번호 <input name="departmentId"> 부서명 <input
			name="departmentName">
		<button type="button" onclick="validationForm()">부서등록</button>
		<!-- 버튼의 디폴트 이벤트는 submit, 이를 수정하려면 type속성을 따로 줘야함! -->
	</form>
	<br>

</body>
</html>