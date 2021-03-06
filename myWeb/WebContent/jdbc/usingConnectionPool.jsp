<%@page import="java.sql.*, jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	ConnectionPool pool = ConnectionPool.getInstance();
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String id = "";
	String passwd = "";
	String name = "";
	String mem_num1 = "";
	String mem_num2 = "";
	String e_mail = "";
	String phone = "";
	String zipcode = "";
	String address = "";
	String job = "";
	int counter = 0;
	
	try {
		conn = pool.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM TEMPMEMBER");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP에서 데이터베이스 연동</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2>JSP 스클립트릿에서 데이터베이스 연동 예제</h2><br>
<h3>회원정보</h3>
<table bordercolor="#0000ff" border="1" >
	<tr>
		<td><strong>ID</strong></td>
		<td><strong>PASSWD</strong></td>
		<td><strong>NAME</strong></td>
		<td><strong>MEM_NUM1</strong></td>
		<td><strong>MEM_NUM2</strong></td>
		<td><strong>E_MAIL</strong></td>
		<td><strong>PHONE</strong></td>
		<td><strong>ZIPCODE/ADDRESS</strong></td>
		<td><strong>JOB</strong></td>
	</tr>
<%
		if(rs!=null) {
			while(rs.next()) {
				id= rs.getString("id");
				passwd = rs.getString("passwd");
				name = rs.getString("name");
				mem_num1 = rs.getString("mem_num1");
				mem_num2 = rs.getString("mem_num2");
				e_mail = rs.getString("e_mail");
				phone = rs.getString("phone");
				zipcode = rs.getString("zipcode");
				address = rs.getString("address");
				job = rs.getString("job");
%>
			<tr>
				<td><%= id %></td>
				<td><%= passwd %></td>
				<td><%= name %></td>
				<td><%= mem_num1 %></td>
				<td><%= mem_num2 %></td>
				<td><%= e_mail %></td>
				<td><%= phone %></td>
				<td><%= zipcode %>/<%= address %></td>
				<td><%= job %></td>
			</tr>
<%
				counter++;
			}//end while
		}// end if
%>
</table><br>
<%
	} catch(SQLException se) {
		System.out.println("sql exception");
	} catch(Exception e) {
		System.out.println("exception");
	} finally {
		if(rs != null) try {rs.close();}catch(SQLException e){}
		if(stmt != null) try {stmt.close();}catch(SQLException e){}
		if(conn != null) try {pool.releaseConnection(conn);}catch(Exception e){}
	}
%>
</body>
</html>