<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<script src="js/jquery-3.6.0.min.js"></script>
</head>

<body>
	<div align="center">
		<div>
			<h1>게시글 보기</h1>
		</div>


		<form name="writeFrm">
			<div>
				<table border="1">
					<tbody>
						<c:choose>
							<c:when test="${not empty vo}">
								<input type="hidden" name="board_no" value="${vo.boardNo}">
								<tr>
									<td><a href="myPage.do?no=${vo.memberNo}">${vo.boardWriter }</a></td>
									<td>${vo.boardScrap }</td>
									<td>${vo.boardRecommend }</td>
									<td>${vo.boardHit }</td>
								</tr>
								<tr>
									<td>${vo.boardNo }</td>
									<td>${vo.boardCategory }</td>
								</tr>
								<tr>
									<td colspan="3">${vo.boardTitle }</td>
									<td>${vo.boardDate }</td>
									<td>${vo.boardAttech }</td>
								</tr>
								<tr>
									<td colspan="4">${vo.boardSubject }</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="8" align="center">게시글이 존재하지 않습니다</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
				<br>

				<div align="center">
					<button type="button" onclick="updatePost()">수정</button>
					<button type="button" onclick="deletePost()">삭제</button>
				</div>

			</div>
		</form>
	</div>





	<script type="text/javascript">
		function deletePost() {
			var result = confirm("게시글을 삭제하시겠습니까?");
			if (result) {
				var form = document.writeFrm;
				form.method = "post";
				form.action = "boardDelete.do";
				form.submit();
			}
		}
	</script>

	<script type="text/javascript">
		function updatePost() {
			var result = confirm("게시글을 수정하시겠습니까?");
			if (result) {
				var form = document.writeFrm;
				form.method = "post";
				form.action = "boardUpdateForm.do";
				form.submit();
			}
		}
	</script>


</body>
</html>