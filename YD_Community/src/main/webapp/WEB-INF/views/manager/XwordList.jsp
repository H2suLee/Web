<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>금지어 관리</title>
</head>
<body>
	<div align="center">
		<div>금지어 목록</div>
	</div>
	<div align="center">
	<form id="frm">
		<input type="text" id="xword" name="xword">&nbsp;
		<input type="button" id="val" name="val" value="검색" onclick="XwordSearch()">
	</form>
	</div>
	<div align="center">
	<table border="1">
		<thead>
			<tr>
				<th><input type="checkbox"></th>
				<th>NO</th>
				<th>금지어</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty list }">
					<c:forEach items="${list }" var="x">
						<tr>
							<td><input type="checkbox"></td>
							<td>${x.xwordNo }</td>
							<td>${x.xword }</td>
							<td><input type="button" value="수정" onclick="XwordUpdate(${x.xwordNo })"></td>
							<td><input type="button" value="삭제" onclick="XwordDelete(${x.xwordNo })"></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="6" align="center">
							금지어가 존재하지 않습니다
						</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	<input type="button" value="추가" onclick="XwordInsert()">
	<input type="button" value="선택삭제" onclick="deleteValue()">
	</div>
	<script type="text/javascript">
		function XwordSearch() {
			let val = $("#val").val();
			$.ajax({
				url : "XwordSearchList.do",
				type : "post",
				data : {val : val},
				dataType : "json",
				success : function(result){
					if(result.length > 0) {
						jsonHtmlConvert(result);
					}else {
						alert("검색한 결과가 없습니다.");
					}
				},
				error : function(error){
					alert("ERROR!")
				}
			});
		}
		function jsonHtmlConvert(data) {
			$('tbody').remove();
			var tbody = $("<tbody />");
			$.each(data, function(index, item){
				var row = $("<tr />").append(
							$("<td />").append($("<input>").attr('type','checkbox')),
							$("<td />").text(item.xwordNo),
							$("<td />").text(item.xword),
							$("<td />").append($("<button onclick=XwordUpdate(this) />").text("수정")),
							$("<td />").append($("<button onclick=XwordDelete(this) />").text("삭제"))
						);
				tbody.append(row);
			});
			$('table').append(tbody);
		}
		
		function errorCallback(err){ //에러
			console.log('error : '+err.message);
		}
		
		function XwordInsert(){
			window.open("XwordInsertForm.do","팝업 테스트","width=400, height=300, top=10, left=10");
		}
		
		function XwordUpdate(no) { //금지어 수정
			let val = $(no);
			$.ajax({
				url : "xwordUpdate.do",
				type : "post",
				data : {no : no},
				dataType : "json",
				success : function(result){
					if(result.length > 0) {
						jsonHtmlConvert(result);
					}else {
						alert("검색한 결과가 없습니다.");
					}
				},
				error : function(error){
					alert("ERROR!")
				}
			});
		}
		
		function XwordDelete(obj){ //금지어 삭제
			let row = $(obj).parent().parent().get(0);
			let td = row.cells[1];
			let no = $(td).html();
			
			const xhr = new XMLHttpRequest();
			const url = "XwordDelete.do?xwordNo="+no;
			console.log(url)
			xhr.onload = function(){
				if(xhr.status >=200 && xhr.status <300){
					if(xhr.response ==1){
						alert("삭제되었습니다.");
						$(row).remove();
					}else{
						alert("삭제할 수 없습니다.");
					}
					
				}else {
					errorCallback(new Error(xhr.stautsText));
				}
			};
			xhr.open('GET',url);
			console.log(xhr.open('GET',url));
			xhr.send(); 
		}
	</script>
</body>
</html>