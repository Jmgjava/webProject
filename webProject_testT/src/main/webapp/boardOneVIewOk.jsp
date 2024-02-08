<%@page import="org.project.dto.Board0208Dto"%>
<%@page import="org.project.dao.Board0208Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 조회(하나)</title>
</head>
<body>
	<h1>게시글조회</h1>
	<div>
		<%
		Board0208Dto board = (Board0208Dto) request.getAttribute("board");
		if (board != null) {
		%>

		글 번호:
		<%=board.getNo()%>, 글 제목:
		<%=board.getTitle()%>, 글 내용:
		<%=board.getContent()%>, 글 작성자:
		<%=board.getUserId()%>
		<br>

		<%
		}
		%>
	</div>
	<div>
		<a href="boardListView.bo">게시글조회(전체목록)</a> <a href="boardOneView.bo">게시글조회(하나)</a>
	</div>

</body>
</html>