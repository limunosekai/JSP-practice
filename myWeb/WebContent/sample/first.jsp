<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP File</title>
</head>
<body>
	<h2>JSP Script ����</h2>
	<% // Scriptlet - ����, ó��
		String scriptlet = "��ũ��Ʈ�Դϴ�";
		String comment = "�ּ����Դϴ�";
		out.println("���尴ü�� �̿��� ��� : "+declation+"<br>");
	%>
	���� ����ϱ� (����) : <%= declation %><br>
	���� ����ϱ� (�޼ҵ�) : <%= declationMethod() %><br>
	��ũ��Ʈ ����ϱ� : <%= scriptlet %><br>
	<!-- JSP���� ����ϴ� HTML �ּ� �κ� -->
	<!-- HTML �ּ� : <%=comment%> --><br>
	<%-- JSP �ּ�  : <%=comment%>--%><br>
	<%
		//�ڹ� �ּ�
		/*
			������ �ּ�
		*/
	%>
	<%! //declation - ���� ���� 
		String declation = "���� �Դϴ�";
	%>
	<%! //declation - �޼ҵ� ����
		public String declationMethod() {
		return declation;
		}
	%>	
</body>
</html>