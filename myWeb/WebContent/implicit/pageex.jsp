<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>pageContext �⺻��ü</title>
</head>
<body>
<%
	HttpServletRequest httpRequest =
	//gerRequest()�� ��ȯ���� ServletRequest�̹Ƿ� ���� ����ȯ
		(HttpServletRequest)pageContext.getRequest();
%>
request �⺻ ��ü�� pageContext.getRequest()�� ���� ����:
<%= request == httpRequest %><br>
pageContext.getOut() �޼ҵ带 ����� ������ ���:
<% pageContext.getOut().println("Hello World"); %>
</body>
</html>