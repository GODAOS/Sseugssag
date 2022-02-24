$(function() {

	const ssHelp = $("#ssHelp1").offset().top;
	const cleanP = $("#cleanQn").offset().top;
	const payP = $("#pay_Qn").offset().top;
	const serviceP = $("#service_Qn").offset().top;
	const bookingP = $("#booking_Qn").offset().top;
	const memberP = $("#member_Info_Qn").offset().top;
	const chattingP = $("#chatTime").offset().top;

	function menuWhite() {
		$(".qnaMenu").css("background-color", "white");
		$(".qnaMenu").css("color", "black");
	}
	
	function moveQn(m) {
		$(m).css("background-color", "rgb(26, 159, 227)");
		$(m).css("color", "white");
	}
	
	function menuHover(p) {
		$(p).hover(function() {
			  $(this).css("background-color","rgb(26, 159, 227, 0.3)");
			  $(this).css("color","black");
			}, function(){
			  $(this).css("background-color","white");
			  $(this).css("color","black");
			});
	}

	$("#upTop").click(function() {
		$("html").animate({
			scrollTop : ssHelp - 150
		}, 500);// 해당 메뉴까지 스크롤이 애니메이션 효과가 나도록(슈루룩 ver.)
	});
	
	
	$("#clean_M").click(function() {
		menuWhite();
		moveQn(this);
		$("html").animate({
			scrollTop : cleanP - 150
		}, 500);
	});

	$("#pay_M").click(function() {
		menuWhite();
		moveQn(this);
		$("html").animate({
			scrollTop : payP - 170
		}, 500);
	});

	$("#service_M").click(function() {
		menuWhite();
		moveQn(this);
		$("html").animate({
			scrollTop : serviceP - 190
		}, 500);
	});

	$("#booking_M").click(function() {
		menuWhite();
		moveQn(this);
		$("html").animate({
			scrollTop : bookingP - 210
		}, 500);
	});

	$("#member_Info_M").click(function() {
		menuWhite();
		moveQn(this);
		$("html").animate({
			scrollTop : memberP - 230
		}, 500);
	});
	
	$("#chatting_M").click(function() {
		menuWhite();
		moveQn(this);
		$("html").animate({
			scrollTop : chattingP - 230
		}, 500);
	});
	
	menuHover("#clean_M");
	menuHover("#pay_M");
	menuHover("#service_M");
	menuHover("#booking_M");
	menuHover("#member_Info_M");
	menuHover("#chatting_M");
	
});