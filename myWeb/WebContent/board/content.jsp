<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="style.css" type="text/css"/>
</head>
<body>
	<div class="content">
		<p><strong>글내용 보기</strong></p><br/>
		<form>
			<table class="content_table">
				<tr class="content_title">
					<td>글번호</td>
					<td>${article.num}</td>
					<td>조회수</td>
					<td>${article.readcount}</td>
				</tr>
				<tr class="content_title">
					<td>작성자</td>
					<td>${article.writer}</td>
					<td>작성일</td>
					<td>${article.regdate}</td>
				</tr>
				<tr class="content_title">
					<td>글제목</td>
					<td colspan="3">${article.subject}</td>
				</tr>
				<tr class="content_title">
					<td>글내용</td>
					<td colspan="3">
						<pre>${article.content}</pre>
					</td>
				</tr>
				<tr class="content_title">
					<td colspan="4">
						<input 
							type="button" 
							value="글수정" 
							onClick="document.location.href='/myWeb/board/updateForm.do?num=${article.num}&pageNum=${pageNum}'"/>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input 
							type="button" 
							value="글삭제" 
							onClick="document.location.href='/myWeb/board/deleteForm.do?num=${article.num}&pageNum=${pageNum}'"/>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input 
							type="button" 
							value="답글쓰기" 
							onClick="document.location.href='/myWeb/board/writeForm.do?num=${article.num}&ref=${article.ref}&step=${article.step}&depth=${article.depth}'"/>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input 
							type="button" 
							value="글목록" 
							onClick="document.location.href='/myWeb/board/list.do?pageNum=${pageNum}'"/>
						&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>