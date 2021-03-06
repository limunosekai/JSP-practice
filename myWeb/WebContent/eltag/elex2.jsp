<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="actiontag.Customer, java.util.*" %>
<%
	ArrayList<String> singer = new ArrayList<>();
	singer.add("오마이걸");
	singer.add("블랙핑크");
	request.setAttribute("singer", singer);
	
	Customer[] customer = new Customer[2];
	customer[0] = new Customer();
	customer[0].setName("손고쿠");
	customer[0].setEmail("son@google.com");
	customer[0].setPhone("010-123-123");
	customer[1] = new Customer();
	customer[1].setName("양탄자");
	customer[1].setEmail("yang@google.com");
	customer[1].setPhone("010-456-1677");
	request.setAttribute("customer", customer);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Example2</title>
</head>
<body>
	<ul>
		<li>${singer[0]}, ${singer[1]}</li>
	</ul>
	<ul>
		<li>이름: ${customer[0].name }</li>
		<li>메일: ${customer[0].email }</li>
		<li>전화: ${customer[0].phone }</li>
	</ul>
	<ul>
		<li>이름: ${customer[1].name }</li>
		<li>메일: ${customer[1].email }</li>
		<li>전화: ${customer[1].phone }</li>
	</ul>
</body>
</html>