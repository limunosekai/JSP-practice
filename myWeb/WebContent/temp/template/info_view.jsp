<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<table width="100%" border="1" cellpadding="0" cellspacing="0">
<tr>
	<td>��ǰ��ȣ</td> <td>1234</td>
</tr>
<tr>
	<td>����</td> <td>10,000��</td>
</tr>
</table>
<jsp:include page="infoSub.jsp" flush="false" >
	<jsp:param value="A" name="type"/>
</jsp:include>