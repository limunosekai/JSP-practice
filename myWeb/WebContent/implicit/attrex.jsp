<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
pageContext.setAttribute("pageAttribute", "����");
%>

<%
request.setAttribute("requestAttribute", "010-xxxx-xxxx");
%>

<%
session.setAttribute("sessionAttribute", "xxxx@test.com");	
%>

<%
application.setAttribute("applicationAttribute", "KG ITBank");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Scope Example</title>
</head>
<body>
<ul>
	<li>�̸� : <%=pageContext.getAttribute("pageAttribute") %></li>
	<li>��ȭ : <%=request.getAttribute("requestAttribute") %></li>
	<li>���� : <%=session.getAttribute("sessionAttribute") %></li>
	<li>ȸ�� : <%=application.getAttribute("applicationAttribute") %></li>
</ul>
</body>
</html>