<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td colspan="3" class="loginInput">${sessionScope.loginCustomer.c_name }님
				환영합니다!</td>
		</tr>
		<tr align="right">
			<td></td>
			<td>
				<form action="customer.logout">
				<button class="loginBt">로그아웃</button>
				</form>
			</td>
			<td>
				<form action="member.info.go">
				<button class="loginBt">정보수정</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>