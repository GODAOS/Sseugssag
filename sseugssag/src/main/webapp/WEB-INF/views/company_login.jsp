<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/address2.js"></script>
<script type="text/javascript" src="resources/js/LeeValidChecker.js"></script>
<script type="text/javascript" src="resources/js/JoinValidChecker.js"></script>
<link rel="stylesheet" href="resources/css/company_login.css">
<title>Insert title here</title>
</head>
<body id="comjoinbody">
<table id="comjointbl">
	<tr>
		<td id="comjointitle">업체 회원가입</td>
	</tr>
	<tr>
		<td>
			<form action="companylogin.gogo" method="post" name="comjoin" onsubmit="return joinCheck2();">
				<table id="comjoin">
					<tr class="tr1">
						<td>아이디&emsp;&emsp;&emsp;&emsp; <input class="input1" name="com_id" placeholder="아이디"></td>
					</tr>
					<tr class="tr1">
						<td>전화번호&emsp;&emsp;&emsp; <input class="input1" name="com_phone" placeholder="전화번호"></td>
					</tr>
					<tr class="tr1">
						<td>비밀번호&emsp;&emsp;&emsp; <input class="input1" name="com_pw" placeholder="비밀번호(8자이상)" type="password"></td>
					</tr>
					<tr class="tr1">
						<td>비밀번호 확인&emsp;<input class="input1" name="com_pwCheck" placeholder="비밀번호확인" type="password"></td>
					</tr>
					<tr class="tr1">
						<td>회사명&emsp;&emsp;&emsp;&emsp; <input class="input1" name="com_name" placeholder="회사명"></td>
					</tr>
					<!-- <tr>
						<td>
							input에 비밀번호:123을 입력하면 123이 들어가듯이 여기서 value값중 하나들어감
							<input type="radio" name="com_category" value="입주청소"/ checked="checked">입주청소 
							<input type="radio" name="com_category" value="가사청소"/>가사청소
							<input type="radio" name="com_category" value="사무실청소"/>사무실청소
						</td>
					</tr> -->
					<tr id="tr2">
						<td>카테고리 선택&emsp;
							<select id="comjoinselect" name="com_category">
								<option  value="입주청소" selected>입주청소</option> 
								<option  value="가사청소" >가사청소</option> 
								<option  value="사무실청소">사무실청소</option> 
							</select>
						</td>
					</tr>
					<tr class="tr1">
						<td>
							<!-- 여기는 db랑 관련없음 /dao에서 다담아 -->
							우편번호&emsp;&emsp;&emsp; <input class="input1" id="join_com_addr1" name="com_addr1" placeholder="우편번호" autocomplete="off" readonly="readonly"><p>
							주소&emsp;&emsp;&emsp;&emsp;&emsp; <input class="input1" id="join_com_addr2" name="com_addr2" placeholder="주소" autocomplete="off" readonly="readonly"><p>
							상세주소&emsp;&emsp;&emsp; <input class="input1" name="com_addr3" placeholder="상세주소" autocomplete="off" maxlength="50"><p>
						</td>
					</tr>
				</table>
				<button id="comjoinbt">가입하기</button>
			</form>
		</td>
	</tr>
</table>

</body>
</html>