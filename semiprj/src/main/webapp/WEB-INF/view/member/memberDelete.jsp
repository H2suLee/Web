<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>탈퇴 진행을 위해 비밀번호를 한 번 더 입력해 주세요</h3>
	<form action="memberDelete.do" method="post">
		<p class="pass">비밀번호:</p>
		<input type="password" class="name" name="chkPw"
			placeholder="로그인 당시의 비밀번호" class="pwd1"> <br class="clear">
		<input type="button" value="탈퇴하기" class="xkf"
			onclick="javascript:btn()">
	</form>
<script>

</script>
</body>
</html>