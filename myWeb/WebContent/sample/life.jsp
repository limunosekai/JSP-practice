<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%! 
		private int numOne = 0;
		public void jspInit() {
			System.out.println("jspInit() ȣ��");
		}
		public void jspDestroy() {
			System.out.println("jspDestroy() ȣ��");
		}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP LifeCycle</title>
</head>
<body>
<%
	int numTwo = 0;
	numOne++;
	numTwo++;
%>
<ul>
	<li>NumbOne : <%=numOne %></li>
	<li>NumbTwo : <%=numTwo %></li>
</ul>
</body>
</html>