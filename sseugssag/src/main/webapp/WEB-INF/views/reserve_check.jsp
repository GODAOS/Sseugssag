<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/reserve_check.css">
<script type="text/javascript" src="resources/js/reserve.js"></script>
</head>
<body>
	<c:forEach var="mr" items="${myRS }">
		<table id="rechecktbl">
			<tr>
				<td id="rechecktitle">예약확인</td>
			</tr>
			<tr>
				<td>
					<table id="recheck">
						<tr>
							<td class="rechecktd" align="center">예약 번호</td>
							<td class="rechecktd">${mr.r_num }</td>
						</tr>
						<tr>
							<td class="rechecktd" align="center">이름</td>
							<td class="rechecktd">${mr.r_name }</td>
						</tr>
						<tr>
							<td class="rechecktd" align="center">전화번호</td>
							<td class="rechecktd">${mr.r_phone }</td>
						</tr>
						<tr>
							<td class="rechecktd" align="center">평수</td>
							<td class="rechecktd">${mr.r_area}</td>
						</tr>
						<tr>
							<td class="rechecktd" align="center">주소</td>
							<td class="rechecktd" align="center">${mr.r_address}</td>
						</tr>
						<tr>
							<td class="rechecktd" align="center">예약날짜</td>
							<td class="rechecktd"><fmt:formatDate value="${mr.r_date}"
									dateStyle="long" /></td>
						</tr>
						<tr>
							<td class="rechecktd" colspan="2" align="center">
								<button id="rsDelBt" onclick="reserveDelete(${mr.r_num});">삭제</button>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>