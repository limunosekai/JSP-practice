<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
			<tr>
				<th>2��</th>
				<th>3��</th>
				<th>4��</th>
				<th>5��</th>
				<th>6��</th>
				<th>7��</th>
				<th>8��</th>
				<th>9��</th>
			</tr>
<%
	for(int i=1; i<10; i++) {		
%>
				<tr>
<%
		for(int z=2; z<10; z++){
%>
					<td><%=z+"X"+i+"="+i*z %></td>
<%
		}
%>
				</tr>
<%
	}
%>
	</table>
</body>
</html>