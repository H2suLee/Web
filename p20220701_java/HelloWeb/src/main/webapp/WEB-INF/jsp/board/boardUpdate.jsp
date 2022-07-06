<%@page import="co.edu.prj.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 수정</h1>
	<form action="BoardUpdate" name="boardForm" method="post"
		onsubmit="return validateForm()">
		<!-- <label for="no">글번호</label> <input type="number" name="no" id="no"><br> -->
		<%
		BoardVO board = (BoardVO) request.getAttribute("board");
		%>
		<label for="id">글번호</label> <input type="number" name="id" id="id"
			value="<%=board.getId()%>" readonly><br> <label
			for="title">글제목</label> <input type="text" name="title" id="title"
			value="<%=board.getTitle()%>"><br> <label for="content">내용</label>
		<input type="text" name="content" id="content"
			value="<%=board.getContent()%>"><br> <label
			for="writer">작성자</label> <input type="text" name="writer" id="writer"
			value="<%=board.getWriter()%>" readonly><br> <label
			for="rdt">작성일</label><input type="date" name="rdt" id="rdt"
			value="<%=board.getRdt()%>" readonly><br> <label
			for="hit">조회수</label><input type="number" name="hit" id="hit"
			value="<%=board.getHit()%>" readonly> <br>
		<button>수정</button>
		<button type="button" onclick="DelFnc()">삭제</button>
		<br>
		</form>
		<script>

	function DelFnc(){
		location.href="BoardDelete?id=<%=board.getId()%>";
		}
		</script>
</body>
</html>