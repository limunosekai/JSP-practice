<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage="true" %>
<%
	response.setStatus(HttpServletResponse.SC_OK);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>예외 발생</title>
</head>
<body>
요청 처리 과정에서 예외가 발생하였습니다.<br>
빠른 시간내에 문제를 해결하도록 하겠습니다.<br>
에러 타입 : <%= exception.getClass().getName() %><br>
에러 메세지 : <%= exception.getMessage() %>
</body>
</html>