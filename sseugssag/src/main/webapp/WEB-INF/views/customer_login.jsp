<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/address.js"></script>
<script type="text/javascript" src="resources/js/LeeValidChecker.js"></script>
<script type="text/javascript" src="resources/js/JoinValidChecker.js"></script>
<script type="text/javascript" src="resources/js/idChecker.js"></script>
<link rel="stylesheet" href="resources/css/customer_login.css">
</head>
<body id="cusjoinbody" >
	<!-- 이름
아이디-pk
비밀번호
휴대폰번호
주소 -->
	<table id="cusjointbl">
		<tr>
			<td id="cusjointitle">고객회원가입</td>
		</tr>
		<tr>
			<td>
				<form action="customer.go" method="post" name="cusjoin" onsubmit="return joinCheck();">
				<table id="cusjoin">
					<tr id="tr1">
						<td id="name">
							이름&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <input class="cusjoininput" name="c_name" placeholder="이름" autocomplete="off" autofocus="autofocus">
						</td>	
					</tr>
					<tr id="tr2">
						<td>전화번호&emsp;&emsp;&emsp;&emsp; <input class="cusjoininput" name="c_phone" placeholder="ex) 010-0000-0000"></td>
					</tr>
					<tr id="tr3">
						<td>
							아이디&emsp;&emsp;&emsp;&emsp;&emsp; <input class="cusjoininput" name="c_id" id="check_c_id" placeholder="아이디" autocomplete="off" autofocus="autofocus">
						</td>
					</tr>
					<tr id="tr4">
						<td>
							비밀번호&emsp;&emsp;&emsp;&emsp; <input class="cusjoininput" name="c_pw" placeholder="비밀번호(8자이상)" autocomplete="off" autofocus="autofocus" type="password">
						</td>
					</tr>
					<tr id="tr5">
						<td>
							비밀번호 확인&emsp;&emsp;<input class="cusjoininput" name="c_pwCheck" placeholder="비밀번호 확인" autocomplete="off" autofocus="autofocus" type="password">
						</td>
					</tr>
					<tr id="tr6">
						<td>
							<!-- 여기는 db랑 관련없음 /dao에서 다담아 -->
							우편번호&emsp;&emsp;&emsp;&emsp; <input class="cusjoininput" id="join_c_addr1" name="c_addr1" placeholder="우편번호" autocomplete="off" readonly="readonly"><p>
							주소&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <input class="cusjoininput" id="join_c_addr2" name="c_addr2" placeholder="주소" autocomplete="off" readonly="readonly"><p>
							상세주소&emsp;&emsp;&emsp;&emsp; <input class="cusjoininput" name="c_addr3" placeholder="상세주소" autocomplete="off" maxlength="50"><p>
						</td>
					</tr>
				</table>
				<button id="cusjoinbt">가입하기</button>
				</form>
				<c:if test="${r!=null }">${r }</c:if>
			</td>
		</tr>
	</table>


</body>
</html>