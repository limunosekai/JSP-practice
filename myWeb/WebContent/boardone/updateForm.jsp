<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="boardone.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script.js"></script>
</head>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	try {
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO article = dao.getArticle(num,"update");
%>
<body>
	<center><b>글수정</b></center><br>
	<form method="post" name="writeform" action="updateProc.jsp?pageNum=<%=pageNum %>" onSubmit="return writeSave()">
		<table width="400" border="1" cellspacing="0" cellpadding="0" align="center">
			<tr>
				<td width="70" align="center">이름</td>
				<td align="left" width="330">
					<input type="text" size="10" maxlength="10" name="writer" value="<%=article.getWriter() %>" />
					<input type="hidden" name="num" value="<%=article.getNum() %>" />
				</td>
			</tr>
			<tr>
				<td width="70" align="center">이메일</td>
				<td width="330"><input type="text" size="30" maxlength="30" name="email" value="<%=article.getEmail() %>"/></td>
			</tr>
			<tr>
				<td width="70" align="center">제목</td>
				<td align="left" width="330">
					<input type="text" size="40" maxlength="50" name="subject" value="<%=article.getSubject() %>" />
				</td>
			</tr>
			<tr>
				<td width="70" align="center">내용</td>
				<td width="330" align="left"><textarea rows="12" cols="42" name="content"><%=article.getContent() %></textarea></td>
			</tr>
			<tr>
				<td width="70" align="center">비밀번호</td>
				<td width="330"><input type="password" size="10" maxlength="10" name="pass" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글수정" />
					<input type="reset" value="다시작성" />
					<input type="button" value="목록" onClick="document.location.href='list.jsp?pageNum=<%=pageNum %>'" />
				</td>
			</tr>
		</table>
	</form>
<%	
	} catch(Exception e) {		
	} 
%>
</body>
</html>