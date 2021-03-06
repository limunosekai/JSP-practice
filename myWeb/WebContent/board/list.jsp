<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="list">
		<b>글목록(전체 글:${count})</b>
		<table>
			<tr>
				<a href="/myWeb/board/writeForm.do">글작성</a>
			</tr>
		</table>
		<c:if test="${count == 0}">
			<table class="list_table">
				<tr>
					<td>게시판에 저장된 글이 없습니다</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${count > 0}">
			<table class="list_table">
				<tr class="list_tr_title">
					<td class="list_td_num">번호</td>
					<td align="center" >제목</td>
					<td class="list_td_auth">작성자</td>
					<td class="list_td_date">작성일</td>
					<td class="list_td_read">조회</td>
					<td class="list_td_ip">IP</td>
				</tr>
				<c:forEach var="article" items="${articleList}">
					<tr class="list_tr_board">
						<td class="list_td_num">
							<c:out value="${number}" />
							<c:set var="number" value="${number-1}" />
						</td>
						<td class="list_td_sub">
							<c:if test="${article.depth > 0}">
								<img class="img_level" src="images/level.gif" alt="#">
								<img src="images/re.gif">
							</c:if>
							<c:if test="${article.depth == 0}">
								<img class="img_level" src="images/level.gif" alt="#">
							</c:if>
							<a href="/myWeb/board/content.do?num=${article.num}&pageNum=${currentPage}">
								${article.subject}
							</a>
							<c:if test="${article.readcount >= 10}">
								<img class="img_hot" src="images/hot.gif" alt="#">
							</c:if>
						</td>
						<td class="list_td_auth">
							<a href="mailto:${article.email}">${article.writer}</a>
						</td>
						<td class="list_td_date">${article.regdate}</td>
						<td class="list_td_read">${article.readcount}</td>
						<td class="list_td_ip">${article.ip}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${count > 0}">
			<c:set var="temp" value="${count % pageSize == 0 ? 0 : 1}" />
			<c:set var="pageCount" value="${count / pageSize + temp}" />
			<c:set var="pageBlock" value="${3}" />
			<fmt:parseNumber var="result" value="${(currentPage - 1) / pageBlock}" integerOnly="true" />
			<c:set var="startPage" value="${result * pageBlock + 1}" />
			<c:set var="endPage" value="${startPage + pageBlock - 1}" />
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}" />
			</c:if>
			<c:if test="${startPage > pageBlock}">
				<a href="/myWeb/board/list.do?pageNum=${startPage - pageBlock}">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a href="/myWeb/board/list.do?pageNum=${i}">[${i}]</a>
			</c:forEach>
			<c:if test="${endPage < pageCount}">
				<a href="/myWeb/board/list.do?pageNum=${startPage + pageBlock}">[다음]</a>
			</c:if>
		</c:if>
	</div>
</body>
</html>