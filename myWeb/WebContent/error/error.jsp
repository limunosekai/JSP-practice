<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page isErrorPage="true" %>
<%
	response.setStatus(HttpServletResponse.SC_OK);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� �߻�</title>
</head>
<body>
��û ó�� �������� ���ܰ� �߻��Ͽ����ϴ�.<br>
���� �ð����� ������ �ذ��ϵ��� �ϰڽ��ϴ�.<br>
���� Ÿ�� : <%= exception.getClass().getName() %><br>
���� �޼��� : <%= exception.getMessage() %>
</body>
</html>