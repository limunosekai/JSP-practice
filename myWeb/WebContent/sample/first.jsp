<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP File</title>
</head>
<body>
	<h2>JSP Script 예제</h2>
	<% // Scriptlet - 연산, 처리
		String scriptlet = "스크립트입니다";
		String comment = "주석문입니다";
		out.println("내장객체를 이용한 출력 : "+declation+"<br>");
	%>
	선언문 출력하기 (변수) : <%= declation %><br>
	선언문 출력하기 (메소드) : <%= declationMethod() %><br>
	스크립트 출력하기 : <%= scriptlet %><br>
	<!-- JSP에서 사용하는 HTML 주석 부분 -->
	<!-- HTML 주석 : <%=comment%> --><br>
	<%-- JSP 주석  : <%=comment%>--%><br>
	<%
		//자바 주석
		/*
			여러줄 주석
		*/
	%>
	<%! //declation - 변수 선언 
		String declation = "선언문 입니다";
	%>
	<%! //declation - 메소드 선언
		public String declationMethod() {
		return declation;
		}
	%>	
</body>
</html>