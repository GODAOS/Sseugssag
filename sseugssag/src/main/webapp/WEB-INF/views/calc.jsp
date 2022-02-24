<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/calc.css">
<script type="text/javascript">
	function isEmpty(input) {
		return (!input.value);
	}
	
	function calcCheck(){
		const c_value = document.getElementById('c_value');
		
		if(isEmpty(c_value)){
			alert("값을 입력해주세요.");
			c_value.value="";
			c_value.focus();
			return false;
		}
		return true;
	}
	
</script>
</head>
<body id="calcbody">
	<table id="calctbl">
		<tr>
			<td>
				<table id="calc">
					<tr>
						<th class="calcth">공급평수</th>
						<th class="calcth">서비스 요금</th>
					</tr>
					<tr>
						<td class="calctd">9평이하</td>
						<td class="calctd">150,000</td>
					</tr>
					<tr>
						<td class="calctd">10-18평</td>
						<td class="calctd">200,000</td>
					</tr>
					<tr>
						<td class="calctd">19평이상</td>
						<td class="calctd">평당 10,900</td>
					</tr>
				</table>
				<table id="calculate">
					<tr>
						<td>
							<form action="calculate" onsubmit="return calcCheck();">
								<b>분양 평수를 입력해주세요</b>
								<p>
									<input id="c_value" name="cal" placeholder=ex)45>평
									<button id="calcbt">계산</button>
								<p>
									<c:if test="${result!=null }">${result }원</c:if>
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>