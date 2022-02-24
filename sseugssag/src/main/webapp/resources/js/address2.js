$(function(){
	connectSearchAddressEvent();
});

function connectSearchAddressEvent(){
	$("#join_com_addr1, #join_com_addr2").click(function(){
		new daum.Postcode({
	        oncomplete: function(data) {
	        	$("#join_com_addr1").val(data.zonecode);
	        	$("#join_com_addr2").val(data.roadAddress);
	        }
	    }).open();
	});
}