<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script src="srcipt.js"></script>
</head>
<body>
	<div class="list">
		<b>글작성</b><br>
		<form 
			method="post" 
			name="writeForm" 
			action="/myWeb/board/writePro.do" 
			onSubmit="return writeSave()">
			<input type="hidden" name="num" value="${num}">
			<input type="hidden" name="ref" value="${ref}">
			<input type="hidden" name="step" value="${step}">
			<input type="hidden" name="depth" value="${depth}">
			<table class="form_table">
				<tr>
					<td class="form_title" colspan="2"><a href="/myWeb/board/list.do">글목록</a></td>
				</tr>
				<tr>
					<td class="form_info">이름</td>
					<td class="form_input">
						<input type="text" name="writer">
					</td>
				</tr>
				<tr>
					<td class="form_info">제목</td>
					<td class="form_input">
						<c:if test="${num == 0}">
							<input type="text" name="subject">
						</c:if>
						<c:if test="${num != 0}">
							<input type="text" name="subject" value="[답변]">
						</c:if>
					</td>
				</tr>
				<tr>
					<td class="form_info">이메일</td>
					<td class="form_input">
						<input type="text" name="email">
					</td>
				</tr>
				<tr>
					<td class="form_info">내용</td>
					<td class="form_input">
						<textarea name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td class="form_info">비밀번호</td>
					<td class="form_input">
						<input type="password" name="pass">
					</td>
				</tr>
			</table>
			<div class="form_button">
				<input type="submit" value="글작성">
				<input type="reset" value="다시작성">
				<input 
					type="button" 
					value="목록보기" 
					onClick="window.location='/myWeb/board/list.do'">
			</div>
		</form>
	</div>
</body>
</html>