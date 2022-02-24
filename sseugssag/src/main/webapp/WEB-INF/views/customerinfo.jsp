<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/customerinfo.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/address.js"></script>
</head>
<body id="cusinfobody">
	<table id="cusinfotbl">
		<tr>
			<td id="cusinfotitle">고객정보수정</td>
		</tr>
		<tr>
			<td>
				<form action="customer.update" method="post">
				<table id="cusinfo">
					<tr>
						<td class="cusinfotd">아이디</td>
						<td class="cusinfotd"><input class="cusinfoinput" value="${sessionScope.loginCustomer.c_id }"
							name="c_id" readonly="readonly"></td>
					</tr>
					<tr>
						<td class="cusinfotd">이름</td>
						<td class="cusinfotd"><input class="cusinfoinput" value="${sessionScope.loginCustomer.c_name }"
							name="c_name"></td>
					</tr>
					<tr>
						<td class="cusinfotd">비밀번호</td>
						<td class="cusinfotd"><input class="cusinfoinput" value="${sessionScope.loginCustomer.c_pw }"
							name="c_pw" type="password"></td>
					</tr>
					<tr>
						<td class="cusinfotd">전화번호</td>
						<td class="cusinfotd"><input class="cusinfoinput" value="${sessionScope.loginCustomer.c_phone }"
							name="c_phone"></td>
					</tr>
					<tr>
						<td class="cusinfotd">주소</td>
						<td class="cusinfotd"><input class="cusinfoinput" value="${addr[0]}" id="join_c_addr1" name="c_addr1"
							autocomplete="off" readonly="readonly">
						<p>
							<input class="cusinfoinput" value="${addr[1]}" id="join_c_addr2" name="c_addr2"
							autocomplete="off" readonly="readonly">
						<p>
							<input class="cusinfoinput" value="${addr[2]}" name="c_addr3" autocomplete="off"
							maxlength="50">
						<p></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><button id="cusinfobt">수정하기</button></td>
					</tr>
				</table>
				</form>

				<form action="customer.bye">
					<button id="cusbyebt">탈퇴하기</button>
				</form>
			</td>
		</tr>
	</table>
	
</body>
</html>