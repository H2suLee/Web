<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Login Form</title>

</head>
<body>
	<div align="center">
		<div>
			<h1>로 그 인</h1>
		</div>
		<div>
			<form id="frm" action="memberLogin.do" method="post">
				<div>
					<table border=1>
						<tr>
							<th width="150">아 이 디</th>
							<td width="200"><input type="text" id="memberId"
								name="memberId" required="required" placeholder="Enter Your Id"></td>
							<!-- placeholder는 도움말 -->
						</tr>
						<tr>
							<th width="150">비 밀 번 호</th>
							<td width="200"><input type="password" id="memberPW"
								name="memberPW" required="required"
								placeholder="Enter Your Password"></td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					<input type="submit" value="로그인"> &nbsp;&nbsp;&nbsp; <input
						type="reset" value="취소"> &nbsp;&nbsp;&nbsp; <input
						type="button" value="홈" onclick="location.href='main.do'">
				</div>
			</form>
		</div>
	</div>

	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<a href="javascript:KakaoLogin();"> <img
		style="height: 60px; width: auto;"
		src="https://www.gb.go.kr/Main/Images/ko/member/certi_kakao_login.png" /></a>

	<script>
	window.Kakao.init("2a2d3b75fcf2829f4ecf48caa95d3805");
	
	function KakaoLogin(){
		console.log('??')
		window.Kakao.Auth.login({
			scope: 'profile_nickname, profile_image, account_email, gender',
			success: function(result){
				console.log(result);
				window.Kakao.API.request({
					url: '/v2/user/me',
					success: res=>{
							let kakao_account = res.kakao_account
						if(res.kakao_account != null){
							//xhtp.open("get", "ajaxMemberIdCheck.do?id=" + id); // 호출할 주소와 방식 설정				
							let xhtp = new XMLHttpRequest();
							xhtp.open("get", `KakaoLogin.do?id=${kakao_account.email}&pw=${kakao_account.email}`);
							//xhtp.open("get", "KakaoLogin.do?id=" + kakao_account.email + "&pw=" + kakao_account.email);
							xhtp.send();
							xhtp.onload = function(){
								if(this.readyState == 4 && this.status == 200){
								successAjax(this.responseText);
								}else{
								failAjax();	
								}
							}
							console.log(kakao_account);
							//alert('로그인 성공!');
							//document.querySelector('#memberId').value = kakao_account.email
							//document.querySelector('#memberPW').value = kakao_account.email

							//location.href = 'memberLogin.do';
							
							//this.setState({isLogin:true})
							
							
							//console.log('1: ', document.querySelector('#memberId').value);
							//console.log('2: ', document.querySelector('#memberPW').value);
							
							//location.href='memberLogin.do';
						}
					}
				})
			},
	
		})
	}
	
	function successAjax(str){
		if(str == "ok"){
			alert('로그인 성공!');
		}else{
			alert('로그인 실패!');
		}
	}
	
	function failAjax() {
		alert('네트워크 통신 장애로 처리할 수 없습니다. 잠시 후 다시 시도해 주세요.');
	}
	</script>
</body>
</html>