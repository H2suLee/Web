<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board List</title>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/boardHeader.jsp"></jsp:include>

	<table border=1>
		<thead>
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>

		<tbody>
			<!-- for(EmpVO : list) -->
			<c:forEach var="vo" items="${list}"> <!-- var: 객채명 (new 생성자와 같다) items: 객체명 (request.getAttribute랑 같다) -->
				<tr>
					<th>${vo.id}</th>
					<th><a href="BoardUpdate?id=${vo.id}">${vo.title}</a></th> <!-- getter로 불러와도 되고(.getId()), 필드명으로 불러올 수도 있다 (.id) -->
					<th>${vo.content}</th>
					<th>${vo.writer}</th>
					<th>${vo.rdt}</th>
					<th>${vo.hit}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>