<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쓱싹</title>
<link rel="shortcut icon" type="image⁄x-icon"
	href="resources/img/sseugssag.png">
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/chat.css">
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/qnaJQ.js"></script>
<script type="text/javascript" src="resources/js/LeeValidChecker.js"></script>
<script type="text/javascript" src="resources/js/JoinValidChecker.js"></script>
<script type="text/javascript" src="resources/js/idChecker.js"></script>
<script type="text/javascript" src="resources/js/address.js"></script>
<script type="text/javascript" src="resources/js/address2.js"></script>
</head>
<body>
	<table id="Tbl1">
		<tr>
			<td><a href="home.go"><img id="titleImg"
					src="resources/img/aa.png"></a></td>
			<td align="right">
				<table id="in">
					<tr>
						<td><jsp:include page="${lp }"></jsp:include></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table id="maintbl">
		<tr>
			<td><jsp:include page="${cp }" /></td>
		</tr>
	</table>
</body>
</html>