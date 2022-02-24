<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/com_login.css">
</head>
<body id="comloginbody">
<table id="comlogintbl">
	<tr>
		<td id="comlogintitle">업체측 로그인</td>
	</tr>
	<tr>
		<td>
			<form action="company.gogo" method="post">
			<input id="comlogininput1"class="comlogininput" name="com_id" placeholder="ID를 입력하세요"><P>
			<input class="comlogininput" name="com_pw" type="password" placeholder="PW를 입력하세요"><p>
			<button id="comloginbt">로그인</button><br>
			</form>
		</td>
	</tr>
</table>
</body>
</html>