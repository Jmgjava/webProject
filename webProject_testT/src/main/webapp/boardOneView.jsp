<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글조회페이지</title>
</head>
<body>
<h1>게시글조회</h1>
<div>

조회할 글번호: <br>

<form action="boardOneOk.bo" method="GET">

글 번호: <input type="text" name="no"> <br>
<input type="submit" value="게시글 조회 GO">

</form>

</div>
</body>
</html>