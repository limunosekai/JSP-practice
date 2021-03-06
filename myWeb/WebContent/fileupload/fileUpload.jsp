<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.*" %>
<%@ page import="java.util.*" %>
<%
	String uploadPath = request.getRealPath("upload");
	int size = 10*1024*1024;
	String name = "";
	String subject = "";
	String fileName1 = "";
	String fileName2 = "";
	String originalName1 = "";
	String originalName2 = "";
	try {
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		name = multi.getParameter("name");
		subject = multi.getParameter("subject");
		Enumeration files = multi.getFileNames();
		String file1 = (String) files.nextElement();
		fileName1 = multi.getFilesystemName(file1);
		originalName1 = multi.getOriginalFileName(file1);
		String file2 = (String) files.nextElement();
		fileName2 = multi.getFilesystemName(file2);
		originalName2 = multi.getOriginalFileName(file2);
	} catch(Exception e) {
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<form name="filecheck" action="fileCheck.jsp" method="post">
		<input type="hidden" name="name" value="<%=name %>" />
		<input type="hidden" name="subject" value="<%=subject %>" />
		<input type="hidden" name="filename1" value="<%=fileName1 %>" />
		<input type="hidden" name="filename2" value="<%=fileName2 %>" />
		<input type="hidden" name="originalname1" value="<%=originalName1 %>" />
		<input type="hidden" name="originalname2" value="<%=originalName2 %>" />
	</form>
	<a href="#" onClick="javascript:filecheck.submit()">업로드 확인 및 다운로드 페이지 이동</a>
</body>
</html>