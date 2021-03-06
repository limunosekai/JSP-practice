<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	function deleteSave() {
		if(document.delForm.pass.value === ''){
			alert("비밀번호를 입력하세요");
			document.delForm.pass.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<center><b>글삭제</b><br></center>
	<form method="post" name="delForm" action="deleteProc.jsp?pageNum=<%=pageNum %>" onSubmit="return deleteSave()">
		<table border="1" align="center" cellspacing="0" cellpadding="0" width="360">
			<tr height="30">
				<td align="center">
					<b>비밀번호를 입력해주세요</b>
				</td>
			</tr>
			<tr height="30">
				<td align="center">
					<b>비밀번호 :&nbsp;</b>
					<input type="password" name="pass" size="8" maxlength="12" />
					<input type="hidden" name="num" value="<%=num %>" />
				</td>
			</tr>
			<tr height="30">
				<td align="center">
					<input type="submit" value="글삭제" />
					<input type="button" value="글목록" onClick="document.location.href='list.jsp?pageNum=<%=pageNum %>'" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>