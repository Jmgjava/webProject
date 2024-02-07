<%@page import="org.project.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>grade</title>
</head>
<body>
	<h1>이름과 등급</h1>
	<%
	List<MemberDto> members = (List<MemberDto>) request.getAttribute("members");
	for (MemberDto member : members) {
	%>
	<div>
		이름 :
		<%=member.getCustname()%>
		, grade:
		<%=member.getGrade()%>
	</div>
	<%
	}
	%>

</body>
</html>