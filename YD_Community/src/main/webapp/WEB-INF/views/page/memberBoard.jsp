<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<style>
.dropbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
}
 
.dropdown {
  position: relative;
  display: inline-block;
}
 
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}
 
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}
 
.dropdown-content a:hover {background-color: #ddd;}
 
.dropdown:hover .dropdown-content {display: block;}
 
.dropdown:hover .dropbtn {background-color: #3e8e41;}

.pagination>li>a, .pagination>li>span {
    position: relative;
    float: left;
    padding: 6px 12px;
    margin-left: -1px;
    line-height: 1.42857143;
    color: #337ab7;
    text-decoration: none;
    background-color: #fff;
    border: 1px solid #ddd;
}



</style>


<meta charset="UTF-8">
<title>내가 작성한 게시글 목록</title>
<script src="js/jquery-3.6.0.min.js"></script>
</head>
<body>

	<div align="center">
		<div><h1> </h1>
	</div>

<div class="dropdown">
  <button class="dropbtn">최근활동</button>
  <div class="dropdown-content">
   <a href="memberRecent.do">자유게시판</a>
    <a href="memberStudyRecent.do">스터디</a>
  </div>
  </div>
  
  <div class="dropdown">
   <button class="dropbtn">나의 게시글</button>
  <div class="dropdown-content">
   <a href="memberBoard.do">자유게시판</a>
   <a href="memberStudyBoard.do">스터디</a>
  </div>
  </div>
  
  <div class="dropdown">
   <button class="dropbtn">북마크</button>
  <div class="dropdown-content">
   <a href="memberScrap.do">스크랩</a>
     <a href="memberStudy.do">찜한 스터디</a>
  </div>
  </div>
  

		<div>
			<table align="center" border="1">
			<thead>
				<tr>  
						<th align="center" width="130">작성자</th>
						<th width="300">제목</th>
						<th width="130">작성일자</th>
				</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${not empty list }">
							<c:forEach items="${list }" var="b">
								<tr>
									<td align="center">${b.boardWriter }</td>
									<td><a href="boardView.do?board_no=${b.boardNo}">${b.boardTitle }</a></td>
									<td align="center">${b.boardDate }</td>
									</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="6" align="center">
									작성한 게시글이 존재하지 않습니다!
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
	</div>
	</div><br>
		
</body>
</html>