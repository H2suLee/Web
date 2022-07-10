<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberJoinForm</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회 원 가 입</h1>
		</div>
		<div>
			<form id="frm" action="memberJoin.do" onsubmit="return formCheck()"
				method="post">
				<div>
					<table>
						<tr>
							<th width="150">아이디</th>
							<td width="300"><input type="text" id="memberId"
								name="memberId" size="20">&nbsp; <input type="hidden"
								id="checkId" value="No">
								<button type="button" id="btn" onclick="idCheck()" >중복체크</button>
							</td>
						</tr>
						<tr>
							<th width="150">패스워드</th>
							<td width="300"><input type="password" id="memberPw"
								name="memberPw" size="20"></td>
						</tr>
						<tr>
							<th width="150">패스워드 확인</th>
							<td width="300"><input type="password" id="checkPw"
								name="checkPw" size="20"></td>
						</tr>
						<tr>
							<th width="150">이름</th>
							<td width="300"><input type="text" id="memberName"
								name="memberName" size="20"></td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					<input type="submit" value="회원가입"> <input type="reset"
						value="취소"> <input type="button" value="홈으로 이동"
						onclick="location.href='main.do'">
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function formCheck() {
			// input에 널 값 안 들어가도록..
			// id 의 경우 중복 확인을 하고 넘어갈 수 있도록..
			// pw 의 경우 두 번 확인할 수 있도록..

			if (frm.memberId.value == "") {
				alert("아이디를 입력해 주세요.")
				frm.memberId.focus();
				return false;
			}

			if (frm.checkId.value == "No") {
				alert("아이디 중복 확인을 해 주세요.")
				return false;
			}

			if (frm.memberPw.value == "") {
				alert("패스워드를 입력해 주세요.")
				frm.memberPw.focus();
				return false;
			}

			if (frm.checkPw.value == "") {
				alert("패스워드를 한 번 더 입력해 주세요.")
				frm.checkPw.focus();
				return false;
			}

			if (frm.memberPw.value != frm.checkPw.value) {
				alert("패스워드가 일치하지 않습니다.")
				frm.memberPw.value = ""
				frm.checkPw.value = ""
				frm.memberPw.focus();
				return false;
			}

			if (frm.memberName.value == "") {
				alert("이름을 입력해 주세요.")
				frm.memberName.focus();
				return false;
			}
			return true;
		}

		function idCheck() {
			let id = frm.memberId.value;
			if (id == "") {
				alert("아이디를 입력해 주세요.")
				frm.memberId.focus();
			} else {

				 fetch("ajaxMemberIdCheck.do?id=" + id)
				.then(result=>result.text())
				.then(successAjax)
				.catch(failAjax);
				 
			/* 	const xhtp = new XMLHttpRequest();
				xhtp.open("get", "ajaxMemberIdCheck.do?id=" + id);
				xhtp.send();
				xhtp.onload = function() {
					if (this.readyState == 4 && this.status == 200) {
						successAjax(this.responseText);
					} else {
						failAjax();
					}
				} */
			}

		}

		function successAjax(str) {
			if (str == "able") {
				alert('사용 가능한 아이디 입니다.');
				frm.checkId.value = "Yes";
				frm.btn.disabled = true;
				frm.memberPw.focus(); // reset하면 disabled가 회복이 안 됨
			} else {
				alert("사용할 수 없는 아이디입니다.");
				frm.memberId.value = "";
				frm.memberId.focus();
			}
		}

		function failAjax() {
			alert('현재 네트워크 통신 장애로 처리할 수 없습니다. 잠시 후 다시 시도해 보세요.')
		}
	</script>
</body>
</html>