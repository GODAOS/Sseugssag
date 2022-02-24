<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<link rel="stylesheet" href="resources/css/reserve.css">
</head>
<body id="reservebody">
<form action="cus_reserve" method="post">
<!-- r_num : mapper에서 nextval해서 가져오기-->
<!-- r_date: select option으로 날짜 선택 -->
<!-- r_address : 원래 주소 값 가져오기  or 새로 입력하 -->
<!-- r_name : customer table가져오기 -->
<!-- r_phone : customer table가져오기 -->
<!-- r_area : 입력받기 -->

<table id="reservetbl">
<tr>
<td id="reserveTitle">예약하기</td>
</tr>
<tr>

<!-- 날짜 한꺼번에 합쳐서 db에 넣어야함 -->
<td class="reservetd" align="center">예약날짜</td>
	<td class="reservetd">
		<select name="y">
<c:forEach var="i" begin="2022" end="2030">
	<option value="${i}">${i }</option>
</c:forEach>
</select>년&emsp;

<select name="m">
<c:forEach var="i" begin="1" end="12">
<c:choose>
      <c:when test="${i lt 10 }">
          <option value="0${i}">0${i}</option>
      </c:when>
      <c:otherwise>
          <option value="${i}">${i}</option>
      </c:otherwise>
  </c:choose>
</c:forEach>
</select>월&emsp;

<select name="d">
<c:forEach var="i" begin="1" end="31">
<c:choose>
      <c:when test="${i lt 10 }">
          <option value="0${i}">0${i}</option>
      </c:when>
      <c:otherwise>
          <option value="${i}">${i}</option>
      </c:otherwise>
  </c:choose>
</c:forEach>
</select>일
	</td>
</tr>

<tr>
<!-- 이름 : 원래이름 불러오기 -->
<td align="center" class="reservetd">이름</td>
<td class="reservetd">
	<input class="reserveinput" value="${sessionScope.loginCustomer.c_name }" name="c_name1">
	<%-- ${sessionScope.loginCustomer.r_name } -->이건 업체측에 넘길때? --%>
</td>
</tr>
<tr>
<td align="center" class="reservetd">전화번호</td>
	<td class="reservetd">
		<input class="reserveinput" value="${sessionScope.loginCustomer.c_phone }" name="c_phone1">
	</td>
</tr>
<tr>
<td align="center" class="reservetd">주소</td> 
<td class="reservetd">
	<!-- 주소 :새로 입력하고싶은경우  js가져와야함-->
	<input class="reserveinput" value="${addr[2] }" id="join_c_addr1" name="c_addr1" autocomplete="off" readonly="readonly"><p>
	<input class="reserveinput" value="${addr[0] }" id="join_c_addr2" name="c_addr2" autocomplete="off" readonly="readonly"><p>
	<input class="reserveinput" value="${addr[1] }" name="c_addr3" autocomplete="off" maxlength="50" readonly="readonly"><p>
</td> 
</tr>
<tr>
	<td align="center" class="reservetd">평수</td>
	<td class="reservetd"><input class="reserveinput" name="r_area" placeholder="평수입력"></td>
</tr>
</table>
<button id="reservebt">예약하기</button>
</form>


</body>
</html>