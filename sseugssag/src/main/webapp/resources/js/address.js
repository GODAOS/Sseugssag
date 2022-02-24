$(function(){
	connectSearchAddressEvent();
});

function connectSearchAddressEvent(){
	$("#join_c_addr1, #join_c_addr2").click(function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	        	$("#join_c_addr1").val(data.zonecode);
	        	$("#join_c_addr2").val(data.roadAddress);
	        }
	    }).open();
	});
}