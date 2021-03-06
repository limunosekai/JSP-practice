<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>pageContext 기본객체</title>
</head>
<body>
<%
	HttpServletRequest httpRequest =
	//gerRequest()의 반환형이 ServletRequest이므로 강제 형변환
		(HttpServletRequest)pageContext.getRequest();
%>
request 기본 객체와 pageContext.getRequest()의 동일 여부:
<%= request == httpRequest %><br>
pageContext.getOut() 메소드를 사용한 데이터 출력:
<% pageContext.getOut().println("Hello World"); %>
</body>
</html>