<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="in">
		<form action="login.gogo" method="post">
			<tr>
				<td class="loginInput">ID <input name="c_id"
					placeholder="ID를 입력하세요"></td>
				<td class="loginInput">PW <input name="c_pw" type="password"
					placeholder="PW를 입력하세요"></td>
				<td align="center">
					<button class="loginBt">로그인</button>
				</td>
			</tr>
		</form>
		<tr align="center">
			<td>
				<form action="company.go">
					<button class="loginBt">업체 로그인</button>
				</form>
			</td>
			<td>
				<form action="customer.join">
					<button class="loginBt">개인회원가입</button>
				</form>
			</td>
			<td>
				<form action="company.join">
					<button class="loginBt">업체회원가입</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>