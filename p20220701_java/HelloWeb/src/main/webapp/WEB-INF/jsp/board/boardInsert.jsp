<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert Board</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/boardHeader.jsp"></jsp:include>

	<h1>글 등록</h1>
	<form action="BoardInsert" name="boardForm" method="post"
		onsubmit="return validateForm()">
		<!-- <label for="no">글번호</label> <input type="number" name="no" id="no"><br> -->
		
		<label for="title">글제목</label> <input type="text" name="title" id="title"><br>
		<label for="content">내용</label> <input type="text" name="content"
			id="content"><br> <label for="writer">작성자</label> <input
			type="text" name="writer" id="writer"><br> <label
			for="rdt">작성일</label><input type="date" name="rdt" id="rdt"><br>
		<label for="hit">조회수</label><input type="number" name="hit" id="hit">
		<br>
		<button>등록</button>
		<br>
</body>
</html>