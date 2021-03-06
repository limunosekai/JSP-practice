<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
pageContext.setAttribute("pageAttribute", "리무");
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
	<li>이름 : <%=pageContext.getAttribute("pageAttribute") %></li>
	<li>전화 : <%=request.getAttribute("requestAttribute") %></li>
	<li>메일 : <%=session.getAttribute("sessionAttribute") %></li>
	<li>회사 : <%=application.getAttribute("applicationAttribute") %></li>
</ul>
</body>
</html>