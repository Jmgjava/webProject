<%@page import="org.project.dto.Board0208Dto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 전체 조회</title>
</head>
<body>
	<h1>게시글 조회(전체)</h1>

	<%
	List<Board0208Dto> boardList = (List<Board0208Dto>) request.getAttribute("boardList");
	if (boardList != null) {
		for (Board0208Dto board : boardList) {
		%>
		글번호:<%=board.getNo()%>, 
		글제목:<%=board.getTitle()%>, 
		글내용 :<%=board.getContent()%>, 
		글작성자:<%=board.getUserId()%> <br>
	<%
	}
	}
	%>
	
	<div>

	조회할 글번호: <br>
	<form action="boardOneOk.bo" method="GET">
	글 번호: <input type="text" name="no"> <br>
	<input type="submit" value="게시글 조회 GO">

</form>

</div>

</body>
</html>