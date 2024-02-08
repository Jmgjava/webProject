<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 페이지</title>
</head>
<body>
	<h1>게시글작성</h1>

	<form action="boardInsert.bo" method="POST">

		글제목 : <input type="text" name="title"> <br> 글내용 :
		<textarea rows="5" cols="30" name="content"></textarea>
		<br> 글 작성자 : <input type="text" name="userId"> <br>

		<input type="submit" value="글 작성 GO">

	</form>

</body>
</html>