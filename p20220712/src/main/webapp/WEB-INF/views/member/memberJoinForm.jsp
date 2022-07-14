<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Join</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회 원 가 입</h1>
			<div>
				<form id="frm" action="memberJoin.do" method="post"
					onsubmit="return formCheck()">
					<div>
						<table border="1">
							<tr>
								<th width="150">아이디</th>
								<td width="300"><input type="text" id="memberId"
									name="memberId" size="20"> &nbsp; <input type="hidden"
									id="checkId" value="No">
									<button type="button" id="btn" onclick="idCheck()">중복체크</button></td>
							</tr>
							<tr>
								<th width="150">패스워드</th>
								<td width="300"><input type="password" id="memberPW"
									name="memberPW" size="20"></td>

							</tr>
							<tr>
								<th width="150">패스워드 확인</th>
								<td width="300"><input type="password" id="membePW2"
									name="memberPW2" size="20"></td>
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
						<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp; <input
							type="reset" value="취소">&nbsp;&nbsp;&nbsp; <input
							type="button" value="홈" onclick="location.href='main.do'">&nbsp;&nbsp;&nbsp;

					</div>

				</form>
				<a href="javascript:KakaoLogin();"> <img
					style="height: 60px; width: auto;"
					src="https://www.gb.go.kr/Main/Images/ko/member/certi_kakao_login.png" /></a>
			</div>
		</div>
	</div>

<script>	
		function formCheck() {
			// 요즘 value 널 체크는 input태그의 required 속성으로 처리함
			if (frm.memberId.value == "") {
				alert('사용자 아이디를 입력하세요.');
				frm.memberId.focus();
				return false;
			}

			// 사용자 아이디 중복 체크
			if (frm.checkId.value == "No") {
				alert('아이디 중복체크를 해 주세요');
				return false;
			}

			if (frm.memberPW.value == "") {
				alert('비밀번호를 입력하세요');
				frm.memberPW.focus();
				return false;
			}

			// 비밀번호 재확인
			if (frm.memberPW.value != frm.memberPW2.value) {
				alert('비밀번호가 일치하지 않습니다.');
				frm.memberPW.value = "";
				frm.memberPW2.value = "";
				frm.memberPW.focus();
				return false
			}
			if (frm.memberName.value == "") {
				alert('이름을 입력하세요');
				frm.memberName.focus();
				return false;
			}
			return true;
		}

		function idCheck() {
			let id = frm.memberId.value;
			if (id == '') {
				alert('사용자 아이디를 입력하세요.');
				frm.memberId.focus();
			} else {
				// ajax - xmlhttprequest 객체 이용

				let xhtp = new XMLHttpRequest();
				xhtp.onload = function() {
					console.log('? ', this.responseText); // xhtp.responseText?
					if (this.readyState == 4 && this.status == 200) {
						// 성공했을 때 수행하는 함수
						htmlConvertAjax(this.responseText);
					} else {
						errorAjaxCall();
					}
				}
				xhtp.open("get", "ajaxMemberIdCheck.do?id=" + id); // 호출할 주소와 방식 설정
				xhtp.send();

				// ajax - fetch 방식 이용
				/* 				fetch()
				 .then(result => result.json())
				 .then(result =>{
				
				 })
				 .catch(error=> console.error(error));
				 */
			}

		}

		function htmlConvertAjax(str) {
			if (str == "used") {
				
				alert('사용할 수 없는 아이디입니다.');
				frm.memberId.value = "";
				frm.memberId.focus();
			} else {
				alert('사용 가능한 아이디입니다.');
				// id="checkId" value="No"
				frm.btn.disabled = true;
				frm.checkId.value = "Yes";
				frm.memberPW.focus();
			}
		}
		function errorAjaxCall() {
			alert('네트워크 통신 장애로 처리할 수 없습니다. 잠시 후 다시 시도해 주세요.');
		}
	</script>

</body>
</html>