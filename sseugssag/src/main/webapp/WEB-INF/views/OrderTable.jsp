<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/OrderTable.css">
</head>
<body id="orderbody">
<table id="ordertbl">
	<tr>
		<td id="ordertitle">주문테이블</td>
	</tr>
	<tr>
		<td>
			<table id="orderhead">
				<tr>
					<td class="ordernumber" align="center">예약번호</td>
					<td class="ordername" align="center">이름</td>
					<td class="orderID" align="center">아이디</td>
					<td class="orderphone" align="center">전화번호</td>
					<td class="orderadd" align="center">주소</td>
					<td class="orderarea" align="center">면적</td>
					<td class="orderdate" align="center">날짜</td>
				</tr>
			</table>
			<c:forEach var="c" items="${CheckReserve }">
			<table id="ordermain">
				<tr>
					<td class="ordernumber" align="center">${c.r_num }</td>
					<td class="ordername" align="center">${c.r_name }</td>
					<td class="orderID" align="center">${c.r_id }</td>
					<td class="orderphone" align="center">${c.r_phone }</td>
					<td class="orderadd" align="center">${c.r_address }</td>
					<td class="orderarea" align="center">${c.r_area }</td>
					<td class="orderdate" align="center">
						<fmt:formatDate value="${c.r_date }" type="date" dateStyle="long" /> <br>
					</td>
				</tr>
			</table>
			</c:forEach>
		</td>
	</tr>
</table>
</body>
