<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setAttribute("PAGETITLE", "��������"); %>
<jsp:forward page="/temp/template/template.jsp">
	<jsp:param value="info_view.jsp" name="CONTENTPAGE"/>
</jsp:forward>