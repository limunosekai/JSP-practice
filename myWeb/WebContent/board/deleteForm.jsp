<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="style.css"/>
<script>
function deleteSave() {
	if(document.delForm.pass.value == '') {
		alert("비밀번호를 입력");
		document.delForm.pass.focus();
		return false;
	}
}
</script>
</head>
<body bgcolor="${bodyback_c}">
	<div class="deleteForm">
		<p><strong>글 삭제</strong></p><br/>
		<form 
			method="post" 
			name="delForm" 
			action="/myWeb/board/deletePro.do?pageNum=${pageNum}" 
			onsubmit="return deleteSave()">
			<table class="deleteForm_table">
				<tr class="deleteForm_tr">
					<td>
						<b>비밀번호를 입력하세요</b>
					</td>
				</tr>
				<tr class="deleteForm_tr">
					<td>
						비밀번호:
						<input type="password" name="pass" />
						<input type="hidden" name="num" value="${num}"/>
					</td>
				</tr>
				<tr class="deleteForm_tr">
					<td class="deleteForm_button">
						<input type="submit" value="글삭제"/>
						<input 
							type="button" 
							value="글목록" 
							onclick="document.location.href='/myWeb/board/list.do?pageNum=${pageNum}'"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>