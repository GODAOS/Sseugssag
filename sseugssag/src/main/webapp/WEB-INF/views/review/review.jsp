<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/review.css">
<link rel="stylesheet" href="resources/css/star.css">
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/star1.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	const result = "${r}";
	if(result === "글이 등록되었습니다"){
		alert("글이 등록되었습니다");
	} else if (result === "글 등록 실패1") {
		alert("글 등록 실패1");
	} else if (result === "글 등록 실패2") {
		alert("글 등록 실패2")
	}
</script>
</head>
<body>
	<h1 align="center">리뷰 게시판</h1>
	<!--  <div>${r }</div>-->
	<form action="review.search" method="post">
		<table id="search">
			<tr>
				<td><input name="search" placeholder="검색어를 입력하세요"
					autocomplete="off"></td>
				<td><button>검색</button></td>
			</tr>
		</table>
		<br>
	</form>
	<c:if test="${sessionScope.loginCustomer != null }">
		<form action="review.write" method="post"
			enctype="multipart/form-data">
			<table id="write-review" align="center">
				<tr>
					<td class="rv-title">리뷰를 등록해주세요</td>
				</tr>
				<tr>
					<td>평점을 남겨주세요</td>
				</tr>
				<tr>
					<td><span class="star"> ★★★★★ 
					<span>★★★★★</span> 
					<input name="r_star" type="range" oninput="drawStar(this)" value="1" step="1" min="0" max="10"></span>
					</td>
				</tr>
				<tr>
					<td>사진을 첨부해주세요</td>
				</tr>
				<tr>
					<td><input name="r_photo" type="file" multiple="multiple"></td>
					<!--<img src="resources/img/${rt.r_photo }"></td>-->
				</tr>
				<tr>
					<td><input name="token" value="${token }" type="hidden">
					<p>
							<textarea name="r_txt" placeholder="리뷰를 작성하세요" maxlength="500"
								align="center"></textarea></td>
				</tr>
				<tr>
					<td align="center"><button class="upload-bu">등록하기</button></td>
				</tr>
			</table>
		</form>
	</c:if>
	<br>
	<table id="other-review" align="center">
		<tr>
			<td>↓ 최근 리뷰를 확인해보세요 ↓</td>
		</tr>
	</table>
	<br>
	<c:forEach var="rt" items="${rv }">
		<!-- rt: review text 줄임 -->
		<table id="written-review" align="center">
			<tr>
				<td>
					<table id="review-profile">
						<tr>
							<!-- 하도 안돼서 일단 기본이미지 넣어놓음 -->
							<td rowspan="2"><img src="resources/img/${rt.r_photo }"
								width="200px"></td>
							<td class="id" align="center">${rt.c_id }</td>
						</tr>
					</table>
				</td>
				<td>
					<table class="written-txt">
						<tr>
							<!-- date는 formatting 사용하기 -->
							<td><fmt:formatDate value="${rt.r_date }" type="both"
									dateStyle="long" timeStyle="short" /></td>
						</tr>
						<tr>
							<!--  <td>${s }</td>-->
							<!--  <td><label type="text" name="r_star" value="${rt.r_star }"></label></td>-->
							<td>${rt.r_txt }</td>
							<td align="center">
							<%-- 평점 ${rt.r_star } 점 --%>
							<c:if test="${rt.r_star==1 }">평점 : ☆ <p>0.5점</c:if>
							<c:if test="${rt.r_star==2 }">평점 : ★<p>1점</c:if>
							<c:if test="${rt.r_star==3 }">평점 : ★☆<p>1.5점</c:if>
							<c:if test="${rt.r_star==4 }">평점 : ★★<p>2점</c:if>
							<c:if test="${rt.r_star==5 }">평점 : ★★☆<p>2.5점</c:if>
							<c:if test="${rt.r_star==6 }">평점 : ★★★<p>3점</c:if>
							<c:if test="${rt.r_star==7 }">평점 : ★★★☆<p>3.5점</c:if>
							<c:if test="${rt.r_star==8 }">평점 : ★★★★<p>4점</c:if>
							<c:if test="${rt.r_star==9 }">평점 : ★★★★☆<p>4.5점</c:if>
							<c:if test="${rt.r_star==10 }">평점 : ★★★★★<p>5점</c:if>
							</td>
						<tr>
							<td>${star }</td>
						</tr>
					</table>
				</td>
				<td>
					<table>
						<tr>
							<!-- 로그인정보가 일치했을 때만 수정, 삭제 버튼이 보여야 함 ->if문 -->
							<c:if test="${rt.c_id == sessionScope.loginCustomer.c_id }">
								<td><button
										onclick="reviewUpdate(${rt.r_no}, '${rt.r_txt }');">수정</button></td>
								<td><button onclick="reviewDelete(${rt.r_no});">삭제</button></td>
							</c:if>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<br>
	</c:forEach>
	<c:if test="${pageNo != 1 }">
		<table>
			<tr>
				<th onclick="reviewPageChange(${pageNo - 1 })">&lt;</th>
			</tr>
		</table>
	</c:if>
	<jsp:include page="${p }" />
	<c:if test="${pageNo != allPageCount }">
		<table>
			<tr>
				<th onclick="reviewPageChange(${pageNo + 1 })">&gt;</th>
			</tr>
		</table>
	</c:if>
</body>
</html>