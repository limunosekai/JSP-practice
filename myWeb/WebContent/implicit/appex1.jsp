<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ʱ�ȭ �Ķ���� �о����</title>
</head>
<body>
�ʱ�ȭ �Ķ���� ���:
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