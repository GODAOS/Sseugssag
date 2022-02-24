<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쓱싹-Q&A</title>

</head>
<body>
	<div id="chatBody">
		<table id="qnaTitle">
			<tr>
				<td id="ssHelp">쓱싹 도움말</td>
			</tr>
			<tr>
				<td id="ssHelp1">도움이 필요하신가요?</td>
			</tr>
		</table>
		<hr class="qna_hr">

		<table id="qnaMain">
			<tr>
				<td class="qnaMenu" id="clean_M">청소</td>
				<td class="qnaMenu" id="pay_M">요금 및 결제</td>
				<td class="qnaMenu" id="service_M">서비스</td>
				<td class="qnaMenu" id="booking_M">예약</td>
				<td class="qnaMenu" id="member_Info_M">회원정보</td>
				<td class="qnaMenu" id="chatting_M">상담원 연결</td>
			</tr>
		</table>


		<div id="qnaList">
			<div id="cleanQn" class="qnaList1">
				<ul class="qnaTitle">
					<li>청소</li>
				</ul>
				<hr class="qn_list_hr">
				<div class="questionQn">
					<ul id="qnaContent1">
						<li>Q.청소하는데 얼마나 시간이 소요 되나요?</li>
					</ul>
					<ul class="qnaContent" id="qnaContent1A">
						<li>- 평수에 따라 다르지만 최소 1시간에서 최대 3시간 정도 소요 됩니다.</li>
					</ul>
				</div>
				<div class="questionQn">
					<ul id="qnaContent2">
						<li>Q.청소도구는 무엇을 준비해야하나요?</li>
					</ul>
					<ul class="qnaContent">
						<li>&lt;소지하고 계신 청소 도구를 사용합니다. 청소에 필요한 도구를 미리 준비해주세요.&gt;
							<p>- 진공 청소기(또는 빗자루)
							<p>- 막대걸레
							<p>- 청소포(막대걸레 부착용)
							<p>- 걸레
							<p>- 고무장갑
							<p>- 세제
							<p>- 세척용품
							<p>- 종량제 쓰레기봉투
						</li>
					</ul>
				</div>
			</div>
			<div id="pay_Qn" class="qnaList1">
				<ul class="qnaTitle">
					<li>요금 및 결제</li>
				</ul>
				<hr class="qn_list_hr">
				<div class="questionQn">
					<ul>
						<li>Q.금액을 알고싶어요</li>
					</ul>
					<ul class="qnaContent">
						<li>- 홈 메뉴의 견적 확인을 통해 확인하시면 됩니다.</li>
					</ul>
				</div>
				<div class="questionQn">
					<ul>
						<li>Q.영수증 발급이 필요해요</li>
					</ul>
					<ul class="qnaContent">
						<li>- 1:1상담을 통해 안내해드립니다.</li>
					</ul>
				</div>
			</div>
			<div id="service_Qn" class="qnaList1">
				<ul class="qnaTitle">
					<li>서비스</li>
				</ul>
				<hr class="qn_list_hr">
				<div class="questionQn">
					<ul>
						<li>Q.야간에도 서비스가 가능한가요?</li>
					</ul>
					<ul class="qnaContent">
						<li>- 업체에 따라 다르지만 대체적으로 09:00~20:00를 기준으로 서비스를 제공하고 있습니다.</li>
					</ul>
				</div>
				<div class="questionQn">
					<ul>
						<li>Q.청소 범위가 궁금해요.</li>
					</ul>
					<ul class="qnaContent">
						<li>&lt;서비스 가능 범위 &gt;
							<p>- 거실, 침실의 먼지 제거와 침구 정리
							<p>- 설거지, 주방 청소
							<p>- 욕실, 베란다 물청소
							<p>- 세탁기를 이용한 빨래
							<p>- 정리정돈
							<p>
								<br>&lt;서비스 불가 범위 &gt;
							<p>- 아기 돌봄, 간병
							<p>- 입주 빈집, 공사 후 청소
							<p>- 손빨래
							<p>- 바닥 손 걸레질
							<p>- 파손 위험이 있는 그릇정리
							<p>- 손이 닿지 않는 높은 곳 가구 이동, 재배치
							<p>- 소독, 방충
							<p>- 전문청소가 필요함 곰팡이, 찌든 때, 기름때, 물때 등
							<p>- 반려 동물 배변 청소
							<p>- 반찬 및 국/찌개 조리
							<p>- 다림질
							<p>- 입주,이사,퇴거 청소
						</li>
					</ul>
				</div>
			</div>
			<div id="booking_Qn" class="qnaList1">
				<ul class="qnaTitle">
					<li>예약</li>
				</ul>
				<hr class="qn_list_hr">
				<div class="questionQn">
					<ul>
						<li>Q.예약 확인을 하고 싶어요.</li>
					</ul>
					<ul class="qnaContent">
						<li>- 메뉴의 "예약확인"을 통해 확인 하실 수 있습니다.</li>
					</ul>
				</div>
				<div class="questionQn">
					<ul>
						<li>Q.예약을 변경하고 싶어요.</li>
					</ul>
					<ul class="qnaContent">
						<li>예약확인 페이지에 들어가셔서 수정하시면 됩니다.</li>
					</ul>
				</div>
			</div>
			<div id="member_Info_Qn" class="qnaList1">
				<ul class="qnaTitle">
					<li>회원정보</li>
				</ul>
				<hr class="qn_list_hr">
				<div class="questionQn">
					<ul>
						<li>Q.회원정보를 변경하고 싶어요.</li>
					</ul>
					<ul class="qnaContent">
						<li>로그인하신 후 정보수정 버튼을 누르시면 정보수정 하실수 있습니다.</li>
					</ul>
				</div>
				<div class="questionQn">
					<ul>
						<li>Q.주소 입력이 안돼요.</li>
					</ul>
					<ul class="qnaContent">
						<li>로그아웃 후 사이트에 재 접속 하시면 가능합니다.</li>
					</ul>
				</div>
				<div class="questionQn">
					<ul>
						<li>Q.탈퇴하고 싶어요.</li>
					</ul>
					<ul class="qnaContent">
						<li>로그인 후 정보수정 페이지 맨 하단에 탈퇴 버튼을 누르시면 탈퇴가 가능합니다.</li>
					</ul>
				</div>
			</div>
		</div>
		<br>
		<div id="chat">
			<div id="chatTitle">고객 상담</div>
			<div id="chatTime">
				상담원과 1:1 상담은 09:00~18:00까지만 가능합니다.
				<p>(점심시간 : 12:00~13:00)
				<p>시간외 상담은 챗봇을 통해서 상담해주시길 바랍니다.
			</div>
			<div id="chatButton">
				<form action="chat.go" method="post">
					<button class="chatting">1:1상담</button>
				</form>
				<form action="chatbot.go" method="post">
					<button class="chatting">쓱싹봇</button>
				</form>
			</div>
		</div>

		<table id="upTop">
			<tr>
				<td>△</td>
			</tr>
		</table>
	</div>

</body>
</html>