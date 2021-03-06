<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String fileName1 = request.getParameter("filename1");
	String fileName2 = request.getParameter("filename2");
	String originalName1 = request.getParameter("originalname1");
	String originalName2 = request.getParameter("originalname2");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 확인 및 다운로드</title>
</head>
<body>
올린이 : <%=name %><br>
제목 : <%=subject %><br>
파일명1 : <%=originalName1 %><br>
파일명2 : <%=originalName2 %><br>
</body>
</html>