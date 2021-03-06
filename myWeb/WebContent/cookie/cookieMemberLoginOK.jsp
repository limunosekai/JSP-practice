<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="logon.LogonDBBean" %>
<% request.setCharacterEncoding("utf-8"); %>
<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	LogonDBBean manager = LogonDBBean.getInstance();
	int check = manager.userCheck(id,passwd);
	if(check == 1) {
		Cookie cookie = new Cookie("memId", id);
		cookie.setMaxAge(20*60);
		response.addCookie(cookie);
		response.sendRedirect("cookieLoginConfirm.jsp");
	} else if (check == 0) {
%>
	<script>
		alert("비밀번호가 맞지 않습니다");
		history.go(-1);
	</script>
<%
	} else if (check == -1) {
		%>
		<script>
			alert("아이디가 존재하지 않습니다");
			history.go(-1);
		</script>
	<%
		}
	%>
%>