<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	int bufferSize = out.getBufferSize();
	int remainSize = out.getRemaining();
	int usedSize = bufferSize - remainSize;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
���� ��ü ũ�� : <%= bufferSize %><br>
����� ���� ũ�� : <%= usedSize %><br>
���� ���� : <% out.println(remainSize); %>byte<br>
</body>
</html>