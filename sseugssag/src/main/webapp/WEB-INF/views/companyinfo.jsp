<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/companyinfo.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/address2.js"></script>
</head>
<body id="cominfobody">
<table id="cominfotbl">
	<tr>
		<td id="cominfotitle">업체 정보 수정</td>
	</tr>
	<tr>
		<td>
			<form action="company.update" method="post">
				<table id="cominfo">
					<tr>
						<td class="cominfotd">아이디</td>
						<td class="cominfotd"><input class="cominfoinput" value="${sessionScope.loginCompany.com_id }"
							name="com_id" readonly="readonly"></td>
					</tr>
					<tr>
						<td class="cominfotd">비밀번호</td>
						<td class="cominfotd"><input class="cominfoinput" value="${sessionScope.loginCompany.com_pw }"
							name="com_pw" type="password"></td>
					</tr>
					<tr>
						<td class="cominfotd">전화번호</td>
						<td class="cominfotd"><input class="cominfoinput" value="${sessionScope.loginCompany.com_phone }"
							name="com_phone"></td>
					</tr>
					<tr>
						<td class="cominfotd">이름</td>
						<td class="cominfotd"><input class="cominfoinput" value="${sessionScope.loginCompany.com_name }"
							name="com_name"></td>
					</tr>
					<tr>
						<td class="cominfotd">주소</td>
						<td class="cominfotd"><input class="cominfoinput" value="${addr[0]}" id="join_com_addr1"
								name="com_addr1" autocomplete="off" readonly="readonly">
						<p>
							<input class="cominfoinput" value="${addr[1]}" id="join_com_addr2" name="com_addr2"
								autocomplete="off" readonly="readonly">
						<p>
							<input class="cominfoinput" value="${addr[2]}" name="com_addr3" autocomplete="off"
								maxlength="50">
						<p></td>
					</tr>
					<tr>
						<td class="cominfotd">카테고리 선택</td>
						<td class="cominfotd"><select id="cominfoselect" name="com_category">
							<option value="입주청소"
								<c:if test="${sessionScope.loginCompany.com_category == '입주청소'}">selected</c:if>>입주청소</option>
							<option value="가사청소"
								<c:if test="${sessionScope.loginCompany.com_category == '가사청소'}">selected</c:if>>가사청소</option>
							<option value="사무실청소"
								<c:if test="${sessionScope.loginCompany.com_category == '사무실청소'}">selected</c:if>>사무실청소</option>
							<p>
						</select></td>
					</tr>
				</table>
				<button id="cominfobt">수정하기</button>
			</form>
			<form action="company.bye">
				<button id="combyebt">탈퇴하기</button>
			</form>
		</td>
	</tr>
</table>
</body>
</html>