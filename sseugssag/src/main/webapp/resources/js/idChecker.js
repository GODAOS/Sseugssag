//alert("d");
//name="c_id" id="check_c_id"
function idCheck(){
	$("#check_c_id").keyup(function(){
		let gs_id=$(this).val();
		//alert(gs_id);
		//JavaScript + DB연동
		
		//$.getJSON("p_customer.c_id.check?c_id= 컨트롤러랑 연결
		$.getJSON("member.id.check?c_id=" + gs_id, function(memberJSON) {
			console.log(gs_id);
			//Customer라는 자바빈에1서 id가 몇번째에 있는지 확인
			//자바빈이랑 db랑 연결되니까
			if (memberJSON.Customer[0]==null) {
				//중복 x
				$("#check_c_id").css('color','black');
			} else {
				//중복
				$("#check_c_id").css('color','red');
			}
		})
		
	})
}

$(function(){
	idCheck();
});
//<input name="this_iD" id="check_this_id">
//$("#check_this_id").keyup(function() {
//	var gs_id = $(this).val();
//	// JavaScript + DB연동(member.id.check)
//	$.getJSON("member.id.check?this_id=" + this_id, function(memberJSON) {
//		if (memberJSON.member[0] == null){
//			$("#check_this_id").css("color", "black"); // 중복아니면
//		} else {
//			$("#check_this_id").css("color", "red"); // 중복이면
//		}
//	});
//});