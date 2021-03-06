<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>
</head>
<body>
	<form size="4">
		성공적으로 로그아웃 되었습니다.<br>
		<a href="login.jsp">로그인 페이지로 이동</a>
	</form>
</body>
</html>