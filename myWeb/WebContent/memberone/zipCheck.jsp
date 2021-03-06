<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, memberone.*" %>
<%
	StudentDAO dao = StudentDAO.getInstance();
	request.setCharacterEncoding("UTF-8");
	String check = request.getParameter("check");
	String dong = request.getParameter("dong");
	Vector<ZipCodeVO> zipList = dao.zipcodeRead(dong);
	int totalList = zipList.size();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 검색</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<script src="script.js"></script>
<script>
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
		<form name="zipForm" method="post" action="zipCheck.jsp">
			<table>
				<tr>
					<td>동이름 입력 :&nbsp;<input type="text" name="dong">
					<input type="button" value="검색" onClick="dongCheckHandler()"></td>
				</tr>
			</table>
			<input type="hidden" name="check" value="n">
		</form>
		<table>
		<%
			if(check.equals("n")) {
				if(zipList.isEmpty()) {
		%>
			<tr>
				<td align="center"><br>검색된 결과가 없습니다</td>
			</tr>
		<%
				} else {
		%>
					<tr>
						<td align="center"><br>*우편번호 클릭시 자동입력</td>
					</tr>
		<%
					for(int i=0; i<totalList; i++) {
						ZipCodeVO vo = zipList.elementAt(i);
						String tempZipcode = vo.getZipcode();
						String tempSido = vo.getSido();
						String tempGugun = vo.getGugun();
						String tempDong = vo.getDong();
						String tempRi = vo.getRi();
						String tempBunji = vo.getBunji();
						if(tempRi == null) tempRi = "";
						if(tempBunji == null) tempBunji = "";
		%>
						<tr>
							<td>
								<a href="javascript:sendAddress('<%= tempZipcode %>','<%= tempSido %>',
								'<%= tempGugun %>','<%= tempDong %>','<%= tempRi %>','<%= tempBunji %>')">
								<%= tempZipcode %>&nbsp;<%= tempSido %>&nbsp;<%= tempGugun %>&nbsp;<%= tempDong %>&nbsp;<%= tempRi %>&nbsp;<%= tempBunji %>
								</a><br>
		<%
					}// end for
				}//end else
			}//end if
		%>
							</td>
						</tr>
			<tr>
				<td align="center"><a href="javascript:this.close();">닫기</a></td>
			</tr>		
		</table>
	</div>
</body>
</html>