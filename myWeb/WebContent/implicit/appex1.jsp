<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>초기화 파라미터 읽어오기</title>
</head>
<body>
초기화 파라미터 목록:
<ul>
<%
	Enumeration enumData = application.getInitParameterNames();
	while(enumData.hasMoreElements()) {
		String initParamName = (String) enumData.nextElement();
%>
<li><%= initParamName %> = <%= application.getInitParameter(initParamName) %></li>
<%
	}
%>
</ul>
</body>
</html>