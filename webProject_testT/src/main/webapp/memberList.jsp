<%@page import="org.project.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원목록페이지</h1>
	<%
	List<MemberDto> members = (List<MemberDto>) request.getAttribute("members");
	for (MemberDto member : members) {
	%>
	<div>
		번호 :
		<%=member.getCustno()%>
		, 이름 :
		<%=member.getCustname()%>
		, phone:
		<%=member.getPhone()%>
		, address:
		<%=member.getAddress()%>
		, joindate:
		<%=member.getJoindate()%>
		, grade:
		<%=member.getGrade()%>
		, city:
		<%=member.getCity()%>
	</div>
	<%
	}
	%>
</body>
</html>