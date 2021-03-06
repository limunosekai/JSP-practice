<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="msg" class="sample.SimpleData" />
<%-- SimpleData msg = new SimpleData(); --%>
<jsp:setProperty name="msg" property="message" />
<%-- msg.setMessage(?); --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>빈즈 활용 예제</title>
</head>
<body>
<h1>간단한 빈즈 프로그램 결과</h1>
<hr color="red"><br>
<font size="5">
메세지 : <jsp:getProperty name="msg" property="message" />
</font>
</body>
</html>