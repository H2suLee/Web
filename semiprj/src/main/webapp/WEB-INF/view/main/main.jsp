<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
</head>
<body>
	<div align="center">
		<div>
			<h1>시작하는 곳</h1>
		</div>

		<c:if test="${empty id }">
			<div>
				<h3>
					<a href="memberJoinForm.do">회원 가입</a>
				</h3>
			</div>
			<div>
				<h3>
					<a href="memberLoginForm.do">로그인</a>
				</h3>
			</div>
		</c:if>

		<c:if test="${not empty id }">
			<div>
				<h3>
					<!-- 만약 카카오로 로그인이 되어있으면  -->
					<input type="button" name="logout" id="logout" value="로그아웃" onclick="Logout()">
					<a href="memberLogout.do" onclick="KakaoLogout()">로그아웃</a>
				</h3>
			</div>
		</c:if>


		<c:if test="${auth eq 'admin' }">
			<div>
				<h3>
					<a href="memberSelect.do">회원 조회</a>
				</h3>
			</div>
		</c:if>
	</div>
	<script>
	
	function Logout(){
		Kakao.init("2a2d3b75fcf2829f4ecf48caa95d3805");
		if(Kakao.Auth.getAccessToken()){
			Kakao.Auth.logout(function() {
		    	alert('로그아웃 성공!');
		    	location.href = 'memberLogout.do'; // 로그아웃 처리
			});
		}
		location.href = 'memberLogout.do';
	}
	/* function KakaoLogout(){
		function kakaoLogout() {
		     if (!Kakao.Auth.getAccessToken()) {
		      alert('로그인을 해주세요.');
		      return
		    } 
		}
	} */
	</script>
</body>
</html>