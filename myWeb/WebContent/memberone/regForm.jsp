<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Form</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<script src="script.js"></script>
</head>
<body>
<form method="post" action="regProc.jsp" name="regForm">
<table border="1">
	<tr>
		<td colspan="2" align="center">회원가입 정보입력</td>
	</tr>
	<tr>
		<td align="right">아이디 :&nbsp;</td>
		<td><input type="text" name="id" />&nbsp;
		<input type="button" value="중복확인" onClick="idCheckHandler(this.form.id.value)" /></td>
	</tr>
	<tr>
		<td align="right">패스워드 :&nbsp;</td>
		<td><input type="password" name="pass" /></td>
	</tr>
	<tr>
		<td align="right">패스워드 확인 :&nbsp;</td>
		<td><input type="password" name="repass" /></td>
	</tr>
	<tr>
		<td align="right">이름 :&nbsp;</td>
		<td><input type="text" name="name" /></td>
	</tr>
	<tr>
		<td align="right">전화번호 :&nbsp;</td>
		<td>
			<select name="phone1">
				<option value="02">02</option>
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
				<option value="018">018</option>
				<option value="019">019</option>
			</select> - 
			<input type="text" name="phone2" size="5" /> - 
			<input type="text" name="phone3" size="5" />
		</td>
	</tr>
	<tr>
		<td align="right">이메일 :&nbsp;</td>
		<td><input type="text" name="email" /></td>
	</tr>
	<tr>
		<td align="right">우편번호 :&nbsp;</td>
		<td><input type="text" name="zipcode" />
		<input type="button" value="찾기" onClick="zipFindHandler()" /></td>
	</tr>
	<tr>
		<td align="right">주소1 :&nbsp;</td>
		<td><input type="text" name="address1" size="50" /></td>
	</tr>
	<tr>
		<td align="right">주소2 :&nbsp;</td>
		<td><input type="text" name="address2" size="30" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="회원가입" onClick="inputCheckHandler()" />&nbsp;&nbsp;
			<input type="reset" value="재입력" />
		</td>
	</tr>
</table>
</form>
</body>
</html>