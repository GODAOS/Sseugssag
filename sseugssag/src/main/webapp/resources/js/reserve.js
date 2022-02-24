function reserveDelete(num){
	if (confirm("해당 예약을 삭제하시겠습니까?")) {
		location.href = "reserve.delete?r_num=" + num;
	}
}