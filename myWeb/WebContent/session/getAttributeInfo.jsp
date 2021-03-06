<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String memberId = (String) session.getAttribute("memId");
	String name = (String) session.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션에 정보 불러오기</title>
</head>
<body>
세션 정보를 불러왔습니다.<br>
Member ID : <%=memberId %><br>
Name : <%=name %>
</body>
</html>