<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>
<script scr="script.js"></script>
<script>
function dongCheck() {
	if(document.zipForm.dong.value == '') {
		alert("동이름을 입력하세요");
		document.zipForm.dong.focus();
		return;
	}
	document.zipForm.submit();
}
function sendAddress(zipcode,sido,gugun,dong,ri,bunji) {
	var address = sido+" "+gugun+" "+dong+" "+ri+" "+bunji;
	opener.document.regForm.zipcode.value=zipcode;
	opener.document.regForm.address1.value=address;
	self.close();
}
</script>
</head>
<body>
<div id="zipCheck_font">
		<b>우편번호 찾기</b>
		<form name="zipForm" method="post" action="member.mdo?cmd=zipCheck">
			<table>
				<tr>
					<td>동이름 입력 :&nbsp;<input type="text" name="dong">
					<input type="button" value="검색" onClick="dongCheck()"></td>
				</tr>
			</table>
			<input type="hidden" name="check" value="n">
		</form>
		<table border="1">
			<c:if test="${check eq 'n'}">
				<c:if test="${zipcodeList.isEmpty()}">
					<tr>
						<td align="center"><br>검색된 결과가 없습니다</td>
					</tr>
				</c:if>
				<c:if test="${!zipcodeList.isEmpty()}">
					<tr>
						<td align="center">검색후 아래 우편번호를 클릭하세요</td>
					</tr>
					<c:forEach var="vo" items="${zipcodeList}">
						<tr>
							<td align="left">
								<a href="javascript:sendAddress()"></a><br>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</c:if>
					<tr>
						<td align="center"><a href="javascript:this.close();">닫기</a></td>
					</tr>
		</table>
	</div>
</body>
</html>