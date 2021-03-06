<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>헤더 목록 출력</title>
</head>
<body>
<%
	Enumeration enumData = request.getHeaderNames();
	while(enumData.hasMoreElements()) {
		String headerName = (String) enumData.nextElement();
		String headerValue = request.getHeader(headerName);
%>
<%= headerName %> = <%= headerValue %><br>
<%
	}
%>
</body>
</html>