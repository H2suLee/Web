<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frmData" id="frmData" method="post">
	닉네임	<input type="text" name="memberNickname" id="memberNickname" value="${vo.memberNickname }" /> <br>
	프로필 사진 <input
			type="text" name="memberImg" id="memberImg" value="${vo.memberImg }" />
	</form>

	<a href="#" onClick="openPop();">팝업창으로 POST 전송!!</a>

	<script>
		function openPop() {

			var pop_title = "popupOpener";

			window.open("", pop_title);

			var frmData = document.frmData;
			frmData.target = pop_title;
			frmData.action = "popup.jsp";

			frmData.submit();

		}
	</script>
</body>
</html>