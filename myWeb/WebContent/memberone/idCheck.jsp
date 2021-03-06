<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="memberone.*" %>
<%
	StudentDAO dao = StudentDAO.getInstance();
%>
<%
	// regForm에서 보낸 id parameter값
	String id = request.getParameter("id");
	// DAO로 DB에 id 여부 체크한 결과값
	boolean check = dao.idCheck(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID Check</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<script src="script.js"></script>
</head>
<body>
<br>
<div id="check_font">
	<b><%= id %></b>
<%
		if(check) {
			out.println("는 이미 존재하는 ID입니다<br>");
		} else {
			out.println("는 사용가능합니다<br>");
		}
%>
<a href="#" onClick="javascript:self.close()">닫기</a>
</div>
</body>
</html>