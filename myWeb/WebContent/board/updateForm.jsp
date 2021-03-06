<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="style.css"/>
<script src="script.js"></script>
</head>
<body>
<div class="updateForm">
	<p><strong>글수정</strong></p><br/>
	<form method="post" name="writeform" action="/myWeb/board/updatePro.do?pageNum=${pageNum}" onsubmit="return writeSave()">
		<table class="updateForm_table">
			<tr>
				<td class="updateForm_title">이름</td>
				<td class="updateForm_input">
					<input type="text" name="writer" value="${article.writer}"/>
					<input type="hidden" name="num" value="${article.num}"/>
				</td>
			</tr>
			<tr>
				<td class="updateForm_title">제목</td>
				<td class="updateForm_input">
					<input type="text" name="subject" value="${article.subject}"/>
				</td>
			</tr>
			<tr>
				<td class="updateForm_title">Email</td>
				<td class="updateForm_input">
					<input type="text" name="email" value="${article.email}"/>
				</td>
			</tr>
			<tr>
				<td class="updateForm_title">내용</td>
				<td class="updateForm_input">
					<textarea name="content">${article.content}</textarea>
				</td>
			</tr>
			<tr>
				<td class="updateForm_title">비밀번호</td>
				<td class="updateForm_input">
					<input type="password" name="pass"/>
				</td>
			</tr>
			<tr>
				<td class="updateForm_button" colspan="2">
					<input type="submit" value="글수정"/>
					<input type="reset" value="다시작성"/>
					<input 
						type="button" 
						value="목록보기" 
						onclick="document.location.href='/myWeb/board/list.do?pageNum=${pageNum}'"/>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>