<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>글 쓰 기</h1>
			<div>
				<form id="frm" action="noticeInsert.do" method="post"
					enctype="multipart/form-data">
					<!--onsubmit="return formCheck()"-->
					<div>
						<table border="1">
							<tr>
								<th width="150">글쓴이</th>
								<td width="200"><input type="text" id="noticeWriter"
									name="noticeWriter"></td>

								<th width="150">작성일자</th>
								<td width="200"><input type="date" id="noticeDate"
									name="noticeDate"></td>
							</tr>
							<tr>
								<th>제목</th>
								<td colspan="3"><input type="text" size="78" id="noticeTitle"
									name="noticeTitle"></td>
							</tr>

							<tr>
								<th>내용</th>
								<td colspan="3"><textarea rows="6" cols="80"
										id="noticeContent" name="noticeContent"></textarea></td>
							</tr>

							<tr>
								<th>첨부파일</th>
								<td colspan="3"><input type="file" id="file" name="file"></td>
							</tr>
						</table>
					</div>
					<br>
					<div>
						<input type="submit" value="저장">&nbsp;&nbsp;&nbsp; <input
							type="reset" value="취소">&nbsp;&nbsp;&nbsp; <input
							type="button" value="글목록" onclick="location.href='noticeList.do'">&nbsp;&nbsp;&nbsp;

					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>