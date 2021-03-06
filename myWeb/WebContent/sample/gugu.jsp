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
				<th>2단</th>
				<th>3단</th>
				<th>4단</th>
				<th>5단</th>
				<th>6단</th>
				<th>7단</th>
				<th>8단</th>
				<th>9단</th>
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