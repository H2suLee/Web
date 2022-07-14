<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div align="center">
		<div>게시글 목록</div>
		<div>
			<form action="" id="frm" name="frm">
				<select id="key" name="key">
					<option value="notice_title">제목</option>
					<option value="notice_content">내용</option>
					<option value="notice_writer">작성자</option>
				</select> &nbsp; <input type="text" id="val" name="val"> &nbsp;
				&nbsp; <input type="button" value="검색" onclick="noticeSearch()">
			</form>
		</div>
		<div>
			<table border=1>
				<thead>
					<tr>
						<th width="70">글번호</th>
						<th width="70">글쓴이</th>
						<th width="70">글제목</th>
						<th width="70">날짜</th>
						<th width="70">조회수</th>
						<th width="70">첨부파일</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty list }">
							<c:forEach items="${list }" var="list">
								<tr>
									<td>${list.noticeId }</td>
									<td>${list.noticeWriter }</td>
									<td>${list.noticeTitle }</td>
									<td>${list.noticeDate }</td>
									<td>${list.noticeHit }</td>
									<td>${list.noticeAttach }</td>
								</tr>
							</c:forEach>

						</c:when>
						<c:otherwise>
							<td colspan="6" align="center">작성된 글이 없습니다.</td>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<br>
		<div>
			<button type="button" onclick="location.href='noticeInsertForm.do'">글쓰기</button>
		</div>
	</div>

	<script type="text/javascript">
		function noticeSearch() {
			let key = $('#key').val();
			console.log(key); // notice_title

			let val = $('#val').val();
			console.log(val); // 1
			
			fetch("ajaxNoticeSearchList.do",{
				
			})
			
			// ajax function call
			$.ajax({
				url : "ajaxNoticeSearchList.do",
				type : "post",
				//contentType: 'application/x-www-form-urlencoded',
				data : {key : key, val : val},
				dataType : "json",
				success : function(result) {
					console.log(result);
					if(result.length>0){
					jsonHtmlConvert(result);
					}
				},
				error : function(error) {
					alert('처리 중 오류 발생!');
				}
			});
		}

		function jsonHtmlConvert(result) {
			$("tbody").remove();
			var tbody = $("<tbody />")
			$.each(data, function(idx, item) {
				var row = $("<tr />").append($("<td />").text(item.noticeId),
						$("<td />").text(item.noticeWriter),
						$("<td />").text(item.noticeTitle),
						$("<td />").text(item.noticeDate),
						$("<td />").text(item.noticeHit),
						$("<td />").text(item.noticeAttacg))
				tbody.append(row);		
			})
			$("table").append(tbody);
		}
	</script>

</body>
</html>