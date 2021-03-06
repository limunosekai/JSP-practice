<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="actiontag.Customer, java.util.*" %>
<%
	// Bean을 사용한 경우
	Customer customer = new Customer();
	customer.setName("손오공");
	customer.setEmail("son@google.com");
	customer.setPhone("010-3199-9213");
	request.setAttribute("customer", customer);
	
	// Map을 사용한 경우
	HashMap<String,String> map = new HashMap<String, String>();
	map.put("name", "소나타");
	map.put("maker", "현대차");
	request.setAttribute("car", map);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Example</title>
</head>
<body>
	<ul>
		<li>이름: ${customer.name}</li>
		<li>메일: ${customer.email}</li>
		<li>전화: ${customer.phone}</li>
	</ul>
<br><br>
	<ul>
		<li>자동차: ${car.name}</li>
		<li>자동차: ${car.maker}</li>
	</ul>
</body>
</html>