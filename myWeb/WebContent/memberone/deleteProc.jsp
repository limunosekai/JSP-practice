<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="memberone.*" %>
<%--<jsp:useBean id="dao" class="memberone.StudentDAO" />--%>
<%
	StudentDAO dao = StudentDAO.getInstance();
%>
<%
	String id = (String) session.getAttribute("loginID");
	String pass = request.getParameter("pass");
	int check = dao.deleteMember(id, pass);
	if(check == 1) {
		session.invalidate();
%>
<meta http-equiv="Refresh" content="3;url=login.jsp">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
	<center>
		<font size="5" face="바탕체">
			회원정보가 삭제되었습니다.<br>
			3초 후 로그인 페이지로 이동합니다
		</font>
	</center>
<% } else { %>
		<script>
			alert("비밀번호가 일치하지 않습니다");
			history.go(-1);
		</script>
<%	} %>
</body>
</html>